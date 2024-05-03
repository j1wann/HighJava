package kr.or.ddit.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@WebServlet("/board/list.do")
public class BoardListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IBoardService service = BoardServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//목록데이터를 가져와야함
		List<BoardVO> boardList = service.selectBoardList();
		
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}