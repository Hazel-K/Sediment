package blog.hyojin4588.pjt.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.hyojin4588.pjt.Const;
import blog.hyojin4588.pjt.ViewResolver;
import blog.hyojin4588.pjt.db.BoardDAO;
import blog.hyojin4588.pjt.vo.BoardVO;

@WebServlet("/boardlist")
public class BoardListSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(); // 세션을 가져온다
		if (null == hs.getAttribute(Const.LOGIN_USER)) {
			response.sendRedirect("login");
			return;
		}
		List<BoardVO> list = BoardDAO.selBoard();
		request.setAttribute("data", list);
		
		ViewResolver.forward("board/BoardList", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
