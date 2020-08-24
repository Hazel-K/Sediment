package blog.hyojin4588.pjt.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.hyojin4588.pjt.Const;
import blog.hyojin4588.pjt.db.BoardDAO;
import blog.hyojin4588.pjt.vo.BoardVO;
import blog.hyojin4588.pjt.vo.UserVO;

@WebServlet("/delete")
public class BoardDeleteSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		param.setI_user(((UserVO)request.getSession().getAttribute(Const.LOGIN_USER)).getI_user());
		int result = BoardDAO.delDetail(param);
		if (result != 1) {
			response.sendRedirect("detail?i_board=" + i_board);
			return;
		}
		response.sendRedirect("boardlist");
	}

}
