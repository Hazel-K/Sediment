package blog.hyojin4588.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.hyojin4588.pjt.Utils;
import blog.hyojin4588.pjt.ViewResolver;
import blog.hyojin4588.pjt.db.UserDAO;
import blog.hyojin4588.pjt.vo.UserVO;

@WebServlet("/join")
public class JoinSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViewResolver.forward("user/Join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String encrypt_pw = Utils.encryptString(user_pw);
		String nm = request.getParameter("nm");
		String email = request.getParameter("email");
		
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(encrypt_pw);
		param.setUser_nm(nm);
		param.setEmail(email);
		
		int result = UserDAO.insUser(param);
		
		if (result != 1) {
			request.setAttribute("msg", "에러가 발생했습니다. 관리자에게 문의하십시오.");
			request.setAttribute("data", param);
			doGet(request, response);
			// 오류가 발생 하였읍니다 메세지 표시
			return;
		}
		response.sendRedirect("/login");
	}

}