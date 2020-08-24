package blog.hyojin4588.pjt.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.hyojin4588.pjt.Const;
import blog.hyojin4588.pjt.ViewResolver;
import blog.hyojin4588.pjt.db.BoardDAO;
import blog.hyojin4588.pjt.vo.BoardVO;
import blog.hyojin4588.pjt.vo.UserVO;

@WebServlet("/detail")
public class BoardDetailSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		BoardVO vo = BoardDAO.selDetail(param);
		
		ServletContext application = getServletContext();
		Integer readI_user = (Integer)application.getAttribute("read_" + strI_board); // Integer는 null 들어감
		UserVO temp = (UserVO)(request.getSession().getAttribute(Const.LOGIN_USER));
		int getI_user = temp.getI_user();
		
		if(readI_user == null || readI_user != getI_user) {
			BoardDAO.updateHits(vo);
			application.setAttribute("read_" + strI_board, getI_user);
		}
		
		request.setAttribute("data", vo);
		ViewResolver.forward("board/BoardDetail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
