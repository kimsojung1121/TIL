package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JDBC ����� ������ DAO Ŭ������ ��ӹ޾� ����ϱ� ���� Ŭ����
// => DataSource �ν��Ͻ�(DBCP) ���� - WAS�� ��ϵ� �ڿ� ���(JNDI)
// => DBCP�κ��� Connection �ν��Ͻ��� �����޾� ��ȯ�ϰų� JDBC ���� �ڿ��� ���޹޾� �����ϴ� �޼ҵ� �ۼ�
// => �ν��Ͻ� ������ ������ �ƴ� ����� ������ Ŭ�����̹Ƿ� �߻� Ŭ������ �����ϴ� ���� ����
public abstract class JdbcDAO {
	private static DataSource dataSource;
	
	static {
		try {
			//WAS�� ��ϵ� �ڿ��� �о� DataSource �ν��Ͻ��� �����Ͽ� ��ȯ�޾� �ʵ忡 ����
			// => DataSource �ν��Ͻ��� Connection �ν��Ͻ��� �̸� �����Ǿ� ���� 
			dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//DataSource �ν��Ͻ��κ��� Connection �ν��Ͻ��� �����޾� ��ȯ�ϴ� �޼ҵ�
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//JDBC ���� �ν��Ͻ��� ���޹޾� �����ϴ� �޼ҵ� - �޼ҵ� �����ε� ����
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}








