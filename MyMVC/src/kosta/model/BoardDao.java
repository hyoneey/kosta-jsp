package kosta.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.BoardMapper;
import kosta.model.Board;

public class BoardDao {
	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	// 쿼리 수행을 위한 sqlSession 생성
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

	// 마이바티스를 이용하여 db에 쓰기 -> sqlsession객체가 있어야함
	public int insertBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1; // 데이터값이 존재하는 유무 판단

		try {
			// board.xml을 호출하는것과 같다 -> mapper사용
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			
			//sqlSession CRUD 사용 , RE는 INSERT한 ROW의 개수를 리턴
			//re = sqlSession.insert("kosta.mapper.BoardMapper.insertBoard",board);
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

		return re;
	}
	public List<Board> listBoard() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			
		//	return sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");//sqlsession방식
			// ID찾는것과 같다
			return sqlSession.getMapper(BoardMapper.class).listBoard(); //mapper방식
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return null;
	}
	

	public Board detailBoard(String seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
		//	return sqlSession.selectOne("kosta.mapper.BoardMapper.detailBoard",seq);
			return sqlSession.getMapper(BoardMapper.class).detailBoard(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return null;
	}

	public int updateBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			// board.xml을 호출하는것과 같다
			re = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
			//re = sqlSession.update("kosta.mapper.BoardMapper.updateBoard",board);
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
		return re;
	}

	public int deleteBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			// board.xml을 호출하는것과 같다
			re = sqlSession.getMapper(BoardMapper.class).deleteBoard(board);
			//re = sqlSession.delete("kosta.mapper.BoardMapper.deleteBoard",board);
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
		return re;
	}
}
