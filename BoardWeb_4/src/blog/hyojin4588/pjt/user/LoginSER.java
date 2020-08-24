package blog.hyojin4588.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.hyojin4588.pjt.Const;
import blog.hyojin4588.pjt.Utils;
import blog.hyojin4588.pjt.ViewResolver;
import blog.hyojin4588.pjt.db.UserDAO;
import blog.hyojin4588.pjt.vo.UserLoginHistoryVO;
import blog.hyojin4588.pjt.vo.UserVO;

@WebServlet("/login")
public class LoginSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO vo = (UserVO)hs.getAttribute(Const.LOGIN_USER);
		if (null != vo) {
			response.sendRedirect("boardlist");
			return;
		}
		
		ViewResolver.forward("user/Login", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String encrypt_pw = Utils.encryptString(user_pw);
		
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(encrypt_pw);
		
		int result = UserDAO.login(param);
//		System.out.println(result);
		if (result != 1) { // 오류처리
			request.setAttribute("data", param);
			switch(result) {
				case 2:
					request.setAttribute("errMsg", "비밀번호가 올바르지 않습니다.");
					break;
				case 3:
					request.setAttribute("errMsg", "아이디가 존재하지 않습니다.");
					break;
			}
			param = null;
			doGet(request, response);
			return;
		}
		HttpSession hs = request.getSession(); // 세션을 가져온다
		hs.setAttribute(Const.LOGIN_USER, param); // 세션에 해당 정보를 넣는다.
		
		UserLoginHistoryVO ulhVO = new UserLoginHistoryVO();
		String agent = request.getHeader("User-Agent");
		String os = getOs(agent);
		String addr = request.getRemoteAddr();
		String browser = getBrowser(agent);
		ulhVO.setI_user(param.getI_user());
		ulhVO.setIp_addr(addr);
		ulhVO.setOs(os);
		ulhVO.setBrowser(browser);
//		System.out.println(os);
//		System.out.println(browser);
//		System.out.println(addr);
		UserDAO.insUserLoginHistory(ulhVO);
		
		response.sendRedirect("boardlist");
	}
	
	private String getBrowser(String agent) {
		if(agent.contains("msie")) {
			return "IE";
		} else if(agent.toLowerCase().contains("chrome")) {
			return "chrome";
		} else if(agent.toLowerCase().contains("safari")) {
			return "safari";
		}
		return "";
	}
	
	private String getOs(String agent) {
		if(agent.contains("mac")) {
			return "mac";
		} else if(agent.toLowerCase().contains("windows")) {
			return "win";
		} else if(agent.toLowerCase().contains("x11")) {
			return "linux";
		} else if(agent.toLowerCase().contains("android")) {
			return "android";
		} else if(agent.toLowerCase().contains("iphone")) {
			return "iOS";
		}
		return "";
	}

}
