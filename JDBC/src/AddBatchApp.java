package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

//�ټ��� ���� �����ϰų� �����ϰ��� �� ��� Batch ������ SQL ����� �����Ͽ�
//�ѹ��� ����� �����Ͽ� �����ϴ� ���
//- �ӵ��� ������ �ϳ��� PreparedStatement �ν��Ͻ��� ��Ȱ���ϱ� ������ �������� ����
//- �׽�Ʈ ��Ȳ���� Ȱ��
//- AutoCommit ��Ȱ��ȭ ����
public class AddBatchApp {
	public static void main(String[] args) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		
		String sql="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, 4000);
		pstmt.setString(2, "����");
		pstmt.setString(3, "010-9856-4521");
		pstmt.setString(4, "����� ������");
		pstmt.setString(5, "2001-12-12");
		//PreparedStatement.addBatch() : SQL ����� Batch ������ �߰��ϴ� �޼ҵ�
		pstmt.addBatch();//�ӽ� �޸� ����
		
		pstmt.setInt(1, 5000);
		pstmt.setString(2, "ȫ�淡");
		pstmt.setString(3, "010-5252-4463");
		pstmt.setString(4, "�λ�� ���ϱ�");
		pstmt.setString(5, "1997-12-3");
		pstmt.addBatch();
		
		pstmt.setInt(1, 6000);
		pstmt.setString(2, "�κ���");
		pstmt.setString(3, "010-4875-3365");
		pstmt.setString(4, "����� ������");
		pstmt.setString(5, "2000-2-10");
		pstmt.addBatch();
		
		//PreparedStatement.executeBatch() : Batch ������ �߰��� ��� SQL ����� ���ӵ�
		//DBMS ������ �����Ͽ� �����ϴ� �޼ҵ� - int[] ��ȯ
		pstmt.executeBatch();
		
		System.out.println("[�޼���]SQL ��ɿ� ���� ��ġ �۾� �Ϸ�");
		
		ConnectionFactory.close(con, pstmt);
		
	}//end of main
}//end of class
