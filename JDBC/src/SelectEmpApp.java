package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP ���̺��� ��� ����� �����ȣ,����̸�,����,�޿��� 
//�޿������� �������� ���ĵǵ��� �˻��Ͽ� ����ϴ� JDBC ���α׷�
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
					
					System.out.println("�����ȣ = "+empno);
					System.out.println("����̸� = "+ename);
					System.out.println("���� = "+job);
					System.out.println("�޿� = "+sal);
					System.out.println("==============================");
					
				}while(rs.next());
			} else {
				System.out.println("��������� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("[����]");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[����]"+e.getMessage());
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
