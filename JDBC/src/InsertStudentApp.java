package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 프로그램을 작성하기 위한 JDBC Driver 관련 클래스가 포함된 라이브러리를 빌드 처리
// => Oracle JDBC Driver : ojdbc6.jar

//STUDENT 테이블 : 학번(숫자형-PRIMARY KEY),이름(문자형),전화번호(문자형),주소(문자형),생년월일(날짜형)

/*
CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY,NAME VARCHAR2(30),PHONE VARCHAR2(20),
    ADDRESS VARCHAR2(100),BIRTHDAY DATE);
*/


//STUDENT 테이블에 학생정보(행)를 삽입하여 저장하는 JDBC 프로그램
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC 관련 인스턴스를 저장하기 위한 참조변수는 try 영역 밖에서 선언
		// => 모든 영역에서 참조변수를 사용하여 메소드 호출 가능
		Connection con=null;
		Statement stmt=null;
		try {
			//1.OracleDriver 클래스로 인스턴스를 생성하여 DriverManager 클래스의 JDBC Driver로 등록
			
			//JDBC Driver : DriverManager 클래스에 등록된 Driver 인스턴스
			// => Driver 인스턴스 : DBMS 서버에 접속할 수 있는 기능 제공
			// => 접속 URL 주소로 DBMS 서버에 접속할 수 있는 기능 제공
			//DriverManager 클래스 : JDBC Driver를 관리하기 위한 기능을 제공하는 클래스
			
			
			//권장하지 않음
			/*
			//DriverManager.registerDriver(Driver driver) : Driver 인스턴스를 DriverManager
			//클래스에 JDBC Driver로 등록하는 메소드
			//OracleDriver 클래스로 다수의 인스턴스를 생성하여 JDBC Driver로 등록 가능
			// => 불필요한 JDBC Driver가 존재 가능
			DriverManager.registerDriver(new OracleDriver());
			DriverManager.registerDriver(new OracleDriver()); //같은 인스턴스 등록 - 불필요한 Driver 등록
			*/
			
			
			//권장
			//OracleDriver 클래스를 읽어 메모리에 저장
			// => OracleDriver 클래스의 정적영역에서 OracleDriver 클래스를 인스턴스로 생성하여
			//    DriverManager 클래스에 JDBC Driver로 등록 처리 - 1번만 실행
			// => 불필요한 Driver가 등록되지 않음
			Class.forName("oracle.jdbc.driver.OracleDriver"); //문자열로 표현된 클래스를 전달받아 해당 위치의 클래스로 읽어들여 메모리에 저장
			
			
			//2.JDBC Driver를 이용하여 DBMS 서버에 접속하고 접속정보(Connection 인스턴스)를 반환받아 저장
			
			//DriverManager.getConnection(String url, String user, String password)
			// => DBMS 서버에 접속하는 메소드 - 접속 성공 시 Connection 인스턴스 반환
			// => 메소드의 매개변수에 전달된 URL 정보에 따라 특정 DBMS 서버에 접속
			// => 서버 접속이 실패하면 SQLException 발생
			//SQLException : JDBC 관련 인스턴스의 메소드에서 발생되는 예외
			// => DBMS 서버에서 접속 오류 또는 SQL 명령에 문제가 있는 경우 예외 발생
			//URL : 인터넷에 존재하는 자원을 표현하기 위한 주소 
			//Protocol:ServerName:Port:Resource - ex) https:www.daum.net:80:/index.html
			//Oracle DBMS Server에 대한 JDBC URL
			//형식)jdbc:oracle:thin:@ServerName:Port:SID
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			//Connection : DBMS 서버의 접속정보를 저장하기 위한 인스턴스
			// => Connection 인터페이스의 참조변수에 자식 클래스의 인스턴스를 반환받아 저장
			con=DriverManager.getConnection(url, user, password);
			
			
			//3.접속된 DBMS 서버에 SQL 명령을 전달하기 위한 Statement 인스턴스를 반환받아 저장
			
			//Connection.createStatement() : Connection 인스턴스로부터 SQL 명령을 전달할 수 있는
			//Statement 인스턴스를 생성하여 반환하는 메소드 - SQLException 발생
			//Statement : 접속된 DBMS 서버에 SQL 명령을 전달하기 위한 인스턴스
			// => Statement 인터페이스의 참조변수에 자식 클래스의 인스턴스를 반환받아 저장
			stmt=con.createStatement();//Connection 인스턴스가 없으면 Statement 인스턴스를 반환받아 저장할 수 없다
			
			
			//4.Statement 인스턴스로 접속된 DBMS 서버에 SQL 명령을 전달하여 실행하고, 실행된 결과값을 반환받아 저장
			
			//Statement.executeUpdate(String sql) : INSERT,UPDATE,DELETE 명령을 서버에 전달하는 메소드
			// => 조작행의 개수(int) 반환 ex)삽입된 행의 개수, 변경된 행의 개수, 삭제된 행의 개수
			//Statement.excuteQuery(String sql) : SELECT 명령을 서버에 전달하는 메소드
			// => 검색행(ResultSet 인스턴스) 반환 - 테이블 형식 - SQLException 발생
//			String sql="INSERT INTO STUDENT VALUES(1000,'홍길동','010-1234-5678','서울시 강남구','1999-12-31')";
			String sql="INSERT INTO STUDENT VALUES(3000,'안은경','010-1234-1234','경기도 구리시','1999-11-20')";
			int rows=stmt.executeUpdate(sql);
			
			//5.SQL 명령의 실행 결과를 처리 - 출력(프로그램) 또는 반환(메소드)
			
			System.out.println("[메세지]"+rows+"명의 학생정보를 저장하였습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());			
		} finally {//예외와 상관없이 실행될 명령 작성
			//6.JDBC 관련 인스턴스 제거 - close() 메소드 호출 - SQLException 발생
			
			// => 인스턴스 생성의 반대 순서대로 제거
			//Connection은 무조건 제거해 주는 것을 권장 - Oracle 라이센스 문제 
			// => Connection 접속 해제를 위해 Statement 인스턴스를 먼저 close해야 함
			
			try {
				//if 구문을 이용하여 NullPointerException 발생 방지
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();//DBMS 서버 접속 해제
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		
	}//end of main
}//end of class
