package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 학생정보 중 학번이 [3000]인 학생정보를 삭제하는 JDBC 프로그램 생성
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="DELETE FROM STUDENT WHERE NO=3000";
			
			int rows=stmt.executeUpdate(sql);
			
			System.out.println("[메세지]"+rows+"명의 학생정보가 삭제되었습니다.");
		} catch(ClassNotFoundException e) {
			System.out.println("[에러]");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[에러]"+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}//end of main
}//end of class
