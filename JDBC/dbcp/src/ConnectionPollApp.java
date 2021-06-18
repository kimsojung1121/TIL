package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase Connection Poll) : Connection 인스턴스를 미리 여러개 생성하여 저장하고
//Connection을 반환하는 기능을 제공하기 위한 클래스
// => Connection 인스턴스의 접속정보에 대한 변경이 용이 ex)driver 변경, url 변경...
// => Connection 인스턴스를 미리 만들어 사용하므로 JDBC 프로그램의 실행 속도 증가
// => Connection 인스턴스의 개수 제한 가능
public class ConnectionPollApp {
	public static void main(String[] args) throws SQLException {
		//ConnectionPool 인스턴스를 반환받아 저장
		// => 싱글톤 디자인 패턴이 적용된 클래스이므로 프로그램에 하나의 인스턴스만 제공
		// => Connection 인스턴스를 미리 여러개 생성하여 콜렉션 필드에 저장
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//CoonectionPool.getConnection() : 미리 생성되어 저장된 Connection 인스턴스 중
		//하나를 반환하는 메소드
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		
		//CoonectionPool.freeConnection() : 제공받은 Connection 인스턴스를 다시 ConnectionPool
		//인스턴스에 돌려주는 메소드
//		cp.freeConnection(con1);
		
		Connection con2=cp.getConnection();
		System.out.println("con2 = "+con2);
		cp.freeConnection(con2);
		
		Connection con3=cp.getConnection();
		System.out.println("con3 = "+con3);
		cp.freeConnection(con3);
		
		Connection con4=cp.getConnection();
		System.out.println("con4 = "+con4);
		cp.freeConnection(con4);
	}//end of main
}//end of class
