package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDao {

	List<BoardVO> selectBoardList();

	BoardVO selectBoard(int no);

	int insertBoard(BoardVO vo);

	int deleteBoard(int no);

}
