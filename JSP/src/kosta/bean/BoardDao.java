package kosta.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	// 요청할 때 마다 새로운 객체를 생성할 필요가 없게 설정해줌
	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	// DBCP 방식으로 Connection객체 구하기
	public Connection getConnection() {
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Board> listBoard() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //결과가 들어갈 곳
		
		String sql = "select * from board";
		List<Board> list = new ArrayList<Board>();

		try {
			conn = getConnection(); //db연결
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery(); // 모든 row를 지니고 있음

			while (rs.next()) {
				Board board = new Board();
				board.setSeq(rs.getInt("seq"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void insertBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kosta180";
		String password = "1234";
		String sql = "insert into board values(board_seq.nextval, ?,?,?,sysdate,0)";
		// (시퀀스이름.nextval, 각 데이터)
		int re = -1;

		try {
			// 1단계 - JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2단계 - Connection 객체 구하기(DB연결)
			conn = DriverManager.getConnection(url, user, password);

			// 3단계 - PrepareStatement 객체 구하기
			pstmt = conn.prepareStatement(sql);
			// 각 ?에 대한 것을 순서대로 지정해주기. 문자열인 경우setString 정수형 setInt
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContents());

			// 제대로 입력되면 1, 아니면 -1 : 결과값 확인
			re = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Board detailBoard(String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		String sql = "select * from board where seq=?";

		try {
			conn = getConnection();

			// sql문 설정
			pstmt = conn.prepareStatement(sql);

			// ?값 설정 (몇번째 물음표인지, 값)
			pstmt.setString(1, seq);

			// rs는 결과를 지님. sql실행
			rs = pstmt.executeQuery(); // 모든 row를 지니고 있음
			
			if (rs.next()) {
				board = new Board();
				board.setSeq(rs.getInt("seq"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;
	}

}
