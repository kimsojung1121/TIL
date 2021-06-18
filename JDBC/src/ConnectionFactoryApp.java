package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DEFT ���̺� ����� ��� �μ������� �˻��Ͽ� ����ϴ� JDBC ���α׷�
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
				System.out.println("�μ���ȣ = "+rs.getString("DEPTNO")
						+", �μ��̸� = "+rs.getString("DNAME")
						+", �μ���ġ = "+rs.getString("LOC"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[����]SQL���� = "+e.getMessage());
		} finally {
			ConnectionFactory.close(con,stmt,rs);
		}
	}//end of main
}//end of class
