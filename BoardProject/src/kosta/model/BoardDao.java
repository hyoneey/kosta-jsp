package kosta.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.BoardMapper;

public class BoardDao {
	// 싱글톤 방식
	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	// db연결
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}

	public int selectB_id() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectB_id() == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectB_id();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}

	// 게시글 전체를 입력
	public int insertBoard(Board board) {
		int re = -1;
		SqlSession sqlSesseion = getSqlSessionFactory().openSession();
		try {
			re = sqlSesseion.getMapper(BoardMapper.class).insertBoard(board);
			if (re > 0) {
				sqlSesseion.commit();
			} else {
				sqlSesseion.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSesseion.close();
		}

		return re;
	}

	// list
	public List<Board> listBoard(Search search, int startRow) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Board> list = null;

		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(new RowBounds(startRow, 2), search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return list;
	}

	// detail, insert 에서 호출
	public Board selectBoard(int b_id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Board board = null;

		try {
			board = sqlSession.getMapper(BoardMapper.class).selectBoard(b_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return board;
	}

	public void updateStep(HashMap<String, Integer> map) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(BoardMapper.class).updateStep(map);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void hitCount(int b_id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(BoardMapper.class).hitCount(b_id);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public int countBoard(Search search) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).countBoard(search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}

	public int updateBoard(Board board) {
		int re = -1;
		SqlSession sqlSesseion = getSqlSessionFactory().openSession();
		try {
			re = sqlSesseion.getMapper(BoardMapper.class).updateBoard(board);
			if (re > 0) {
				sqlSesseion.commit();
			} else {
				sqlSesseion.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSesseion.close();
		}

		return re;
	}
	
	public int replyInsert(Reply reply){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		int re= -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).replyInsert(reply);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}
	
	public List<Reply> selectReply(int b_id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reply> list = null;

		try {
			list = sqlSession.getMapper(BoardMapper.class).selectReply(b_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return list;
	}

}
