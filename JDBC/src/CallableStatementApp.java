package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;

//Ű����� �й��� �Է¹޾� STUDENT ���̺� ����� �л����� �� �Էµ� �й��� �л������� �����ϴ� JDBC ���α׷�

public class CallableStatementApp {
	public static void main(String[] args) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<�л����� ����>>");
		System.out.print("�й� �Է� >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("====================================================");
		
		Connection con=ConnectionFactory.getConnection();
		
		//DELETE_STUDENT ���� ���ν��� ����
		/*
		CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN NUMBER) IS
		BEGIN
    		DELETE FROM STUDENT WHERE NO=VNO;
    		COMMIT;
		END;
		 */
		
		//Connection.prepareCall(String sql) : SQL ����� ������ CallableStatement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => CallableStatement �ν��Ͻ��� ���� ���ν����� ȣ���ϴ� SQL ����� ����
		// => ���� ���ν����� ȣ���ϴ� ��� : {call ���ν�����({��|����},{��|����},...)}
		// => ? ��ȣ(InParameter) ��� ����
		String sql="{call DELETE_STUDENT(?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		//CallableStatement.execute() : CallableStatement �ν��Ͻ��� ����� SQL ����� �����Ͽ� �����ϴ� �޼ҵ�
		cstmt.execute();//executeUpdate()�� executeQuery()�� ������� ����
		
		System.out.println("[���]���� ���ν����� ȣ���Ͽ� �л������� �����Ͽ����ϴ�.");
		
		ConnectionFactory.close(con,cstmt);
	}//end of main
}//end of class
