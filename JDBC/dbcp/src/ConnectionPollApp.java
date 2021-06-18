package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase Connection Poll) : Connection �ν��Ͻ��� �̸� ������ �����Ͽ� �����ϰ�
//Connection�� ��ȯ�ϴ� ����� �����ϱ� ���� Ŭ����
// => Connection �ν��Ͻ��� ���������� ���� ������ ���� ex)driver ����, url ����...
// => Connection �ν��Ͻ��� �̸� ����� ����ϹǷ� JDBC ���α׷��� ���� �ӵ� ����
// => Connection �ν��Ͻ��� ���� ���� ����
public class ConnectionPollApp {
	public static void main(String[] args) throws SQLException {
		//ConnectionPool �ν��Ͻ��� ��ȯ�޾� ����
		// => �̱��� ������ ������ ����� Ŭ�����̹Ƿ� ���α׷��� �ϳ��� �ν��Ͻ��� ����
		// => Connection �ν��Ͻ��� �̸� ������ �����Ͽ� �ݷ��� �ʵ忡 ����
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//CoonectionPool.getConnection() : �̸� �����Ǿ� ����� Connection �ν��Ͻ� ��
		//�ϳ��� ��ȯ�ϴ� �޼ҵ�
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		
		//CoonectionPool.freeConnection() : �������� Connection �ν��Ͻ��� �ٽ� ConnectionPool
		//�ν��Ͻ��� �����ִ� �޼ҵ�
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
