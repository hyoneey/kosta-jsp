package kosta.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RegisterDao {

	private static RegisterDao dao = new RegisterDao();

	public static RegisterDao getInstance() {
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
		
	public void insert(Register register) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member values(?,?,?,?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, register.getId());
			pstmt.setString(2, register.getPass());
			pstmt.setString(3, register.getName());
			pstmt.setInt(4, register.getAge());
			
			pstmt.executeUpdate(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Register> listInfo(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		String sql = "select * from member";
		List<Register> list = new ArrayList<Register>();
		
		try {
			conn = getConnection(); //db연결
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery(); 
			
			while(rs.next()){
				Register register = new Register();
				register.setId(rs.getString("id"));
				register.setPass(rs.getString("pass"));
				register.setName(rs.getString("name"));
				register.setAge(rs.getInt("age"));
				
				list.add(register);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Register info(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where id=?";
		Register register = new Register();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				register.setId(rs.getString("id"));
				register.setPass(rs.getString("password"));
				register.setName(rs.getString("name"));
				register.setAge(rs.getInt("age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return register;
	}

}
