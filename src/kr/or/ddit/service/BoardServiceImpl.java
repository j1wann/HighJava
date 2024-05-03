package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{

	private static BoardServiceImpl instance = null;

	private BoardServiceImpl() {

	}

	public static BoardServiceImpl getInstance() {

		if (instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	private IBoardDao dao = BoardDaoImpl.getInstance();
	
	@Override
	public List<BoardVO> selectBoardList() {
		
		return dao.selectBoardList();
	}

	@Override
	public BoardVO selectBoard(int no) {
		
		return dao.selectBoard(no);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
		
	}

	@Override
	public int deleteBoard(int no) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(no);
	}
	
}
