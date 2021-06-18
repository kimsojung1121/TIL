package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DEFT 테이블에 저장된 모든 부서정보를 검색하여 출력하는 JDBC 프로그램
public class ConnectionFactoryApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=ConnectionFactory.getConnection();
			
			stmt=con.createStatement();
			
			String sql="SELECT * FROM DEPT ORDER BY DEPTNO";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("부서번호 = "+rs.getString("DEPTNO")
						+", 부서이름 = "+rs.getString("DNAME")
						+", 부서위치 = "+rs.getString("LOC"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[에러]SQL오류 = "+e.getMessage());
		} finally {
			ConnectionFactory.close(con,stmt,rs);
		}
	}//end of main
}//end of class
