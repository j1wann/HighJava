package kr.or.ddit.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;


@WebServlet("/board/delete.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBoardService service = BoardServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		int status = service.deleteBoard(Integer.parseInt(no));
		
		if(status > 0) { // 삭제 성공
			response.sendRedirect("/board/list.do");
		}else {	// 삭제 실패
			response.sendRedirect("/board/detail.do?no=" + no);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
