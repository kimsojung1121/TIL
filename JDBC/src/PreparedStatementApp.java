package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PreparedStatement : 접속된 DBMS 서버에 SQL 명령을 전달하여, 실행된 결과를 반환하는 기능(메소드)을 제공하는 인스턴스
//- 장점 : InParameter를 이용하여 값을 전달받아 SQL 명령 작성
// => InParameter를 사용하여 가독성과 유지보수의 효율성 증가
// => InSQL 해킹 기술 무효화 처리 - 사용자 입력값을 무조건 SQL 명령의 값으로 처리
//- 단점 : PreparedStatement 인스턴스는 하나의 SQL 명령만을 저장하여 전달
public class PreparedStatementApp {
	public static void main(String[] args) throws Exception {
		
		/*
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하여 저장하고, STUDENT 테이블에 저장된
		//모든 학생정보를 검색하여 출력하는 JDBC 프로그램
				
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
				
		//키보드로 학생정보를 입력받아 저장
		System.out.println("<<학생정보 입력>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());

		System.out.print("이름 입력 >> ");
		String name=in.readLine();
				
		System.out.print("전화번호 입력 >> ");
		String phone=in.readLine();
				
		System.out.print("주소 입력 >> ");
		String address=in.readLine();
				
		System.out.print("생년월일 입력 >> ");
		String birthday=in.readLine();
				
		System.out.println("============================================");
		
		//입력된 학생정보를 STUDENT 테이블에 행으로 삽입하여 저장 
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : 접속된 DBMS 서버에 전달될 SQL 명령을
		//저장한 PreparedStatement 인스턴스를 반환하는 메소드
		// => PreparedStatement 인스턴스에 저장된 SQL 명령에서는 ?(InParameter) 기호 사용 가능
		//InParameter : Java 변수값을 제공받아 SQL 명령의 값으로 표현하기 위한 기호
		// => 모든 InParameter에는 반드시 Java 변수값이 전달되어야만 SQL 명령 완성되어 전달 가능
		//RreparedStatement.setXXX(int parameterIndex, XXX value) 
		// => 원하는 위치의 InParameter에 Java 변수값을 전달하는 메소드
		// => XXX는 Java 자료형을 표현하며 메소드는 InParameter의 개수만큼 호출
		String sql1="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : PreparedStatement 인스턴스에 저장된 SQL 명령
		//(INSERT,UPDATE,DELETE)을 전달하는 메소드 - 조작행의 개수(int) 반환
		int rows=pstmt.executeUpdate(); //매개변수에 sql 변수를 넣지 않음 - pstmt에 이미 들어가 있기 때문에
		
		System.out.println("[결과]"+rows+"명의 학생정보를 저장하였습니다");
		System.out.println("============================================");

		//STUDENT 테이블에 저장된 모든 행(학생정보)을 검색하여 출력
		String sql2="SELECT * FROM STUDENT ORDER BY NO";//InParameter 없기 때문에 setXXX 사용할 필요 X
		pstmt=con.prepareStatement(sql2);
		
		//PreparedStatement.executeQuery() : PreparedStatement 인스턴스에 저장된 SQL 명령
		//(SELECT)을 전달하는 메소드 - 검색행(ResultSet 인스턴스) 반환
		ResultSet rs=pstmt.executeQuery();
		
		
		System.out.println("<<학생목록 출력>>");
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("NO")+", 이름 = "+rs.getString("NAME"));
		}
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("============================================");
		*/
		
		
		
		
		//키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생정보를 입력한 이름으로 검색하여 출력하는 JDBC 프로그램 작성
		
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
				
		//키보드로 이름을 입력받아 저장
		System.out.println("<<학생정보 검색>>");				
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.println("============================================");
		
		//STUDENT 테이블에서 저장된 학생정보 중 입력된 이름의 학생정보를 검색하여 출력
		Connection con=ConnectionFactory.getConnection();
		
		//InParameter는 Java 변수값을 무조건 SQL 명령의 값으로만 인식되어 처리
		String sql="SELECT * FROM STUDENT WHERE NAME=? ORDER BY NO";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name); //값으로 인식 - InSQL 해킹 기술 사용 불가능
		
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<검색결과 출력>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("NO")+", 이름 = "+rs.getString("NAME"));
			} while(rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		
	}//end of main
}//end of class
