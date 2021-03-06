package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에서 모든 사원의 사원번호,사원이름,업무,급여를 
//급여순으로 내림차순 정렬되도록 검색하여 출력하는 JDBC 프로그램
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="SELECT EMPNO,ENAME,JOB,SAL FROM EMP ORDER BY SAL DESC";
			
			rs=stmt.executeQuery(sql);

			if(rs.next()) {
				do {
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					String job=rs.getString("job");
					int sal=rs.getInt("sal");
					
					System.out.println("사원번호 = "+empno);
					System.out.println("사원이름 = "+ename);
					System.out.println("업무 = "+job);
					System.out.println("급여 = "+sal);
					System.out.println("==============================");
					
				}while(rs.next());
			} else {
				System.out.println("사원정보가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("[에러]");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[에러]"+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}//end of main
}//end of class
