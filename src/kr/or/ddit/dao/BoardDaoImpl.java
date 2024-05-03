package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {

	private static BoardDaoImpl instance = null;

	private BoardDaoImpl() {

	}

	public static BoardDaoImpl getInstance() {

		if (instance == null) {
			instance = new BoardDaoImpl();
		}
		return instance;
	}

	@Override
	public List<BoardVO> selectBoardList() {
		// 게시판 목록 전체 조회하기 위한 쿼리 필요
		SqlSession session = null;
		List<BoardVO> boardList = null;

		try {
			session = MyBatisUtil.getSqlSession(true);
			// session.selectList("Namespace.id");
			boardList = session.selectList("board.selectBoardList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return boardList;
	}

	@Override
	public BoardVO selectBoard(int no) {
		SqlSession session = null;
		BoardVO vo = null;

		try {
			session = MyBatisUtil.getSqlSession(true);
			// session.selectList("Namespace.id");
			vo = session.selectOne("board.selectBoard", no);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return vo;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		SqlSession session = null;
		int status = 0;

		try {
			session = MyBatisUtil.getSqlSession();
			// session.selectList("Namespace.id");
			status = session.insert("board.insertBoard", vo);
			if(status > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}

		return status;
	}

	@Override
	public int deleteBoard(int no) {
		SqlSession session = null;
		int status = 0;

		try {
			session = MyBatisUtil.getSqlSession();
			// session.selectList("Namespace.id");
			status = session.delete("board.deleteBoard", no);
			if(status > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return status;
	}

}
