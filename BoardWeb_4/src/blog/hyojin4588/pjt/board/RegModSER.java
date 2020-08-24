package blog.hyojin4588.pjt.board;

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
import blog.hyojin4588.pjt.db.BoardDAO;
import blog.hyojin4588.pjt.vo.BoardVO;
import blog.hyojin4588.pjt.vo.UserVO;

@WebServlet("/regmod")
public class RegModSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
//		System.out.println(strI_board);
		BoardVO vo = null;
		String titleMsg = "";
		if(strI_board != null && !(strI_board.equals(""))) {
			int i_board = Utils.parseStringToInt(strI_board);
			BoardVO param = new BoardVO();
			param.setI_board(i_board);
			vo = BoardDAO.selDetail(param);
			request.setAttribute("data", vo);
			titleMsg = "글수정";
		} else {
			titleMsg = "글쓰기";
		}
		request.setAttribute("titleMsg", titleMsg);
		ViewResolver.forward("board/RegMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		if (null == hs.getAttribute(Const.LOGIN_USER)) {
			response.sendRedirect("login");
			return;
		}
		UserVO vo = (UserVO)hs.getAttribute(Const.LOGIN_USER);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int i_user = vo.getI_user();
		
		BoardVO param = new BoardVO();
		String strI_board = request.getParameter("i_board");
		
		if(!(strI_board.equals(""))) {
			param.setI_board(Utils.parseStringToInt(strI_board));
		}
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setI_user(i_user);
		
		int result = 0;
		
		if(!(strI_board.equals(""))) {
			result = BoardDAO.modDetail(param);
		} else {
			result = BoardDAO.insDetail(param);
//			System.out.println(result);
		}
		
		if (result != 1) {
			request.setAttribute("errMsg", "글 등록에 실패했습니다.");
			doGet(request, response);
			return;
		}
		
		if(!(strI_board.equals(""))) {
			response.sendRedirect("detail?i_board=" + Utils.parseStringToInt(strI_board));
			return;
		} else {
			response.sendRedirect("boardlist");
			return;
		}
	}

}