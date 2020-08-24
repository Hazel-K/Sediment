package blog.hyojin4588.pjt.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.hyojin4588.pjt.Utils;
import blog.hyojin4588.pjt.db.BoardDAO;
import blog.hyojin4588.pjt.vo.UserLikeVO;
import blog.hyojin4588.pjt.vo.UserVO;

@WebServlet("/like")
public class BoardLikeSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.isLogout(request, response);
		UserVO userInfo = Utils.userInfo(request, response);
		int i_user = userInfo.getI_user();
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board);
		
//		System.out.println("i_user "+i_user);
//		System.out.println("i_board "+i_board);
		
		UserLikeVO param = new UserLikeVO();
		param.setI_board(i_board);
		param.setI_user(i_user);
		
		BoardDAO.selLike(param);
		
//		System.out.println("like "+param.getLike());
		
		String likeResult = "";
		if(param.getLike() == 0) {
			BoardDAO.insLike(param);
			likeResult = "♥";
		} else {
			BoardDAO.delLike(param);
			likeResult = "♡";
		}
		
		request.setAttribute("like", likeResult);
		response.sendRedirect("detail?i_board=" + i_board);
	}

}
