package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//PHONEBOOK ���̺� ����� ��� ���� �˻��Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ���� - JDBC
@WebServlet("/old.itwill")
public class PhonebookOldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.OracleDriver Ŭ������ �о� �޸𸮿� ���� - Ŭ���� �ε� �۾�
			// => OracleDriver �ν��Ͻ��� �����Ͽ� DriverManager Ŭ������ JDBC Driver ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DriverManager Ŭ������ ��ϵ� JDBC Driver�� �̿��Ͽ� Oracle DBMS Server��
			//�����Ͽ� Connection �ν��Ͻ��� ��ȯ�޾� ����
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			//3.Connection �ν��Ͻ��� SQL ����� ������ PreparedStatement �ν��Ͻ��� ��ȯ�޾� ����
			String sql="select * from phonebook order by phone";
			pstmt=con.prepareStatement(sql);
			
			//4.PreparedStatement �ν��Ͻ��� ����� SQL ����� DBMS ������ �����ϰ� �������� ��ȯ�޾� ����
			rs=pstmt.executeQuery();
			
			//5.��ȯ���� ����� �̿��Ͽ� ó�� �۾� - SQL ���� ����� Ŭ���̾�Ʈ���� HTML ������ ����
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>��ȭ��ȣ��</h1>");
			out.println("<hr>");
			out.println("<table border='1' cellspacing='0'>");
			out.println("<tr>");
			out.println("<th width='200'>��ȭ��ȣ</th>");
			out.println("<th width='200'>�̸�</th>");
			out.println("<th width='200'>�ּ�</th>");
			out.println("</tr>");
			//ResultSet Ŀ���� ���������� �̵��Ͽ� ó������ �ִ� ��� �ݺ� ó��
			// => ResultSet Ŀ�� ��ġ�� ó������ ���� ��� �ݺ� ����
			while(rs.next()) {
				out.println("<tr>");
				//ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ��ȯ�޾� Ŭ���̾�Ʈ���� ����
				out.println("<td>"+rs.getString("phone")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getString("address")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]SQL ���� = "+e.getMessage());
		} finally {
			//6.JDBC ���� �ν��Ͻ� ����
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		
	}
}