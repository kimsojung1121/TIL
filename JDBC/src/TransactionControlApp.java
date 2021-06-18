package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC ���α׷��� �⺻������ AutoCommit ����� Ȱ��ȭ ó���Ǿ� SQL ���(DML)�� ���޵Ǿ� ����Ǹ� �ڵ����� Ŀ�� ó��
// => ���α׷� ���� �� ���ܰ� �߻��� ��� ���� �߻� ���� ����� SQL ��ɿ� ���� �ѹ� ó�� �Ұ���

//AutoCommit ����� ��Ȱ��ȭ ó���Ͽ� ���α׷��� ���������� ����� ��� Ŀ�� ó���ϰ�,
//���ܰ� �߻��� ��� �ѹ� ó���ϴ� ���� ����

//STUDENT ���̺��� �����ȣ�� [2000]�� ����� ����̸��� [�Ӳ���]���� �����ϴ� JDBC ���α׷�
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
			
			//Connection.setAutoCommit(boolean autoCommit) : AutoCommit ����� ��뿩�θ� �����ϴ� �޼ҵ�
			// => false : AutoCommit ��� ��Ȱ��ȭ,true : AutoCommit ��� Ȱ��ȭ(�⺻)
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			String sql="UPDATE STUDENT SET NAME='�Ӳ���' WHERE NO=2000";
			int rows=stmt.executeUpdate(sql);
			
			//������ ���� �߻�
//			if(con!=null) throw new Exception(); //������ ���� �߻�
			
			if(rows>0) {
				System.out.println("[�޼���]"+rows+"���� �л������� �����Ͽ����ϴ�.");
			} else {
				System.out.println("[�޼���]�����ϰ��� �ϴ� �й��� �л������� ã�� �� �����ϴ�.");
			}
			
			//Connection.commit() : COMMIT ����� �����Ͽ� �����ϴ� �޼ҵ� 
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} catch(Exception e) {
			// TODO: handle exception
			System.out.println("���α׷��� ����ġ ���� ������ �߻��Ǿ����ϴ�.");
			
			try {
				//Connection.rollback() : ROLLBACK ����� �����Ͽ� �����ϴ� �޼ҵ�
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
