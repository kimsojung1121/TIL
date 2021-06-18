package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 프로그램은 기본적으로 AutoCommit 기능이 활성화 처리되어 SQL 명령(DML)이 전달되어 실행되면 자동으로 커밋 처리
// => 프로그램 실행 시 예외가 발생된 경우 예외 발생 전에 실행된 SQL 명령에 대한 롤백 처리 불가능

//AutoCommit 기능을 비활성화 처리하여 프로그램이 정상적으로 실행된 경우 커밋 처리하고,
//예외가 발생된 경우 롤백 처리하는 것을 권장

//STUDENT 테이블에서 사원번호가 [2000]인 사원의 사원이름을 [임꺽정]으로 변경하는 JDBC 프로그램
public class TransactionControlApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url,user,password);
			
			//Connection.setAutoCommit(boolean autoCommit) : AutoCommit 기능의 사용여부를 변경하는 메소드
			// => false : AutoCommit 기능 비활성화,true : AutoCommit 기능 활성화(기본)
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			String sql="UPDATE STUDENT SET NAME='임꺽정' WHERE NO=2000";
			int rows=stmt.executeUpdate(sql);
			
			//인위적 예외 발생
//			if(con!=null) throw new Exception(); //무조건 예외 발생
			
			if(rows>0) {
				System.out.println("[메세지]"+rows+"명의 학생정보를 변경하였습니다.");
			} else {
				System.out.println("[메세지]변경하고자 하는 학번의 학생정보를 찾을 수 없습니다.");
			}
			
			//Connection.commit() : COMMIT 명령을 전달하여 실행하는 메소드 
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} catch(Exception e) {
			// TODO: handle exception
			System.out.println("프로그램에 예기치 못한 오류가 발생되었습니다.");
			
			try {
				//Connection.rollback() : ROLLBACK 명령을 전달하여 실행하는 메소드
				con.rollback();
			} catch (SQLException e1) {
				// TODO: handle exception
			}
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
