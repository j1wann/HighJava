package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardService {

	public List<BoardVO> selectBoardList();

	public BoardVO selectBoard(int no);

	public int insertBoard(BoardVO vo);

	public int deleteBoard(int no);
	
	
	
	
}
