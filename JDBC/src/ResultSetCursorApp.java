package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Statement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ忡 ���޵Ǵ� ���� ���� ResultSet �ν��Ͻ� ����� ����
// => ResultSet Ŀ���� ��ġ ���� �Ǵ� ResultSet Ŀ�� ��ġ�� ó���࿡ ���� �÷��� ���� ����

//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ����ϴ� JDBC ���α׷� �ۼ�
public class ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : Statement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Statement : SQL ����� ���ӵ� DBMS ������ �����ϴ� ����� �����ϴ� �ν��Ͻ�
		//Statement.executeQuery(String sql) : SELECT ����� �����Ͽ� �����ϰ� �˻������ 
		//ResultSet �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => ResultSet �ν��Ͻ��� Ŀ���� �̿��Ͽ� ����� ó��
		// => ResultSet Ŀ���� ���������θ� �̵� �����ϸ� Ŀ�� ��ġ�� �࿡ ���� ���� �Ұ���
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ�
		// => Ŀ�� ��ġ�� ó������ ���� ��� false ��ȯ�ϸ� ó������ �ִ� ��� true ��ȯ 
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet Ŀ���� ��ġ�� ó������ ���ȣ(ColumnIndex)�� ��ȯ�ϴ� �޼ҵ�
			//ResultSet.getXXX(String columnLabel) : ResultSet Ŀ���� ��ġ�� ó������ �÷����� ��ȯ�ϴ� �޼ҵ�
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("===============================================================");
		con=ConnectionFactory.getConnection();
		
		//con.createStatement(int resultSetType, int resultSetConcurrency)
		// => Statement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => �Ű������� ���޵Ǵ� ���� ���� SELECT ����� �������� ������ ResultSet �ν��Ͻ��� �Ӽ� ����
		//resultSetType : ResultSet Ŀ���� �̵� ���� �Ӽ� ����
		// => ResultSet.TYPE_FORWARD_ONLY : ResultSet Ŀ���� ���������θ� �̵�(�⺻)
		// => ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet Ŀ���� ���ϴ� ������ �̵� - ������ �̹�ȯ 
		// => ResultSet.TYPE_SCROLL_SENSITIVE : ResultSet Ŀ���� ���ϴ� ������ �̵� - ������ ��ȯ
		//resultSetConcurrency : ResultSet Ŀ�� ��ġ�� ó���࿡ ���� ���� ���� �Ӽ� ����
		// => ResultSet.CONCUR_READ_ONLY : ó���࿡ ���� ���� �Ұ���(�⺻)
		// => ResultSet.CONCUR_UPDATABLE : ó���࿡ ���� ���� ���� - ���̺� ���� ����
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		sql="select * from student order by no";
		rs=stmt.executeQuery(sql);
		
		//Result.first() : ResultSet Ŀ���� ù��° �˻������� �̵��ϴ� �޼ҵ�
		rs.first();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		//Result.last() : ResultSet Ŀ���� ������ �˻������� �̵��ϴ� �޼ҵ�
		rs.last();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		//Result.absolute(int rowIndex) : ResultSet Ŀ���� ���ϴ� ��ġ(RowIndex)�� �˻������� �̵��ϴ� �޼ҵ�
		rs.absolute(2);
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		System.out.println("===============================================================");
		//Result.beforeFirst() : ResultSet Ŀ���� BOF�� �̵��ϴ� �޼ҵ�
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		System.out.println("===============================================================");
		//Result.afterLast() : ResultSet Ŀ���� EOF�� �̵��ϴ� �޼ҵ�
		rs.afterLast();
		//Result.previous() : ResultSet Ŀ���� ������� �̵��ϴ� �޼ҵ�
		while(rs.previous()) {
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}

		ConnectionFactory.close(con, stmt, rs);
		System.out.println("===============================================================");
		con=ConnectionFactory.getConnection();

		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		//ResultSet Ŀ�� ��ġ�� ���� �����ϰ��� �� ��� SELECT ��ɿ��� �˻�������� * ��� �Ұ��� 
		sql="select no,name,phone,address,birthday from student order by no";
		rs=stmt.executeQuery(sql);
		
		/*
		//ResultSet �ν��Ͻ��� 2��° ��ġ�� ���ο� ���� �����ϰ� ���̺� ����
		rs.absolute(2);
		
		//ResultSet.moveToInsertRow() : ResultSet Ŀ�� ��ġ�� ���ο� ���� �����Ͽ� �����ϴ� �޼ҵ�
		// => ���Ե� �� ������ �����ϴ� ���� ���� �ڵ����� ���������� �̵�
		rs.moveToInsertRow();
		
		//���Ե� ���ο� ���� �÷����� ���� 
		//ResultSet.updateXXX(String columnLabel, XXX value) :  ResultSet Ŀ�� ��ġ�� 
		//ó���࿡ �÷����� �����ϴ� �޼ҵ� - XXX : Java �ڷ���
		rs.updateInt("no", 4000);
		rs.updateString("name", "������");
		rs.updateString("phone", "010-7861-3132");
		rs.updateString("address", "������ �ȴޱ�");
		//rs.updateDate("birthday", new Date(100,11,20));//2000-12-20
		rs.updateString("birthday", "2000-12-20 00:00:00.0");
		
		//ResultSet.insertRow() : Ŀ�� ��ġ�� ������ ���̺� �����ϴ� �޼ҵ�
		rs.insertRow();
		*/
		
		/*
		//ResultSet �ν��Ͻ��� 3��° ��ġ�� ���� �����ϰ� ���̺� ����
		rs.absolute(3);
		
		//ResultSet.deleteRow() : Ŀ�� ��ġ�� ������ ���̺��� ���� �����ϴ� �޼ҵ�
		rs.deleteRow();
		*/
		
		//ResultSet �ν��Ͻ��� 2��° ��ġ�� �࿡ �̸��� [�Ӱ���]���� �����Ͽ� ���̺� ����
		rs.absolute(2);
		rs.updateString("name", "�Ӱ���");
		
		//ResultSet.deleteRow() : Ŀ�� ��ġ�� ������ ���̺��� ���� �����ϴ� �޼ҵ�
		rs.updateRow();
		
		ConnectionFactory.close(con, stmt, rs);
	}
}
