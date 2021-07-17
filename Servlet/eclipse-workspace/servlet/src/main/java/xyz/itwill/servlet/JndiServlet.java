package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//JNDI(Java Naming Directory Interface) : �ν��Ͻ� ������ �ʿ��� ������ �̸��� �ο��Ͽ�
//WAS�� �ڿ����� ����ϰ� �ʿ��� ��� �ν��Ͻ��� �����Ͽ� ����Ͽ� ���
// => �ν��Ͻ� ������ �ʿ��� ������ ������ ���� �ʿ� - /src/main/webapp/META-INF/context.xml

//WAS�� ��ϵ� �ڿ��� �̿��Ͽ� DataSource �ν��Ͻ�(ConnectionPool)�� ������ Connection 
//�ν��Ͻ��� �����޾� Ŭ���̾�Ʈ���� �����ϴ� ����
@WebServlet("/jndi.itwill")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			//InitialContext �ν��Ͻ� ����
			//InitialContext : WAS�� ��ϵ� �ڿ��� �ڿ��� �ĺ��ڷ� �о� �ν��Ͻ��� �����Ͽ�
			//��ȯ�ϴ� ����� �����ϴ� �ν��Ͻ�
			InitialContext ic=new InitialContext();
			
			//InitialContext.lookup(String name) : �ڿ��� �ĺ��ڷ� �ν��Ͻ� ������ �ʿ���
			//������ �о� �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
			// => Object Ÿ������ �ν��Ͻ��� ��ȯ�ϹǷ� ����� ��ü ����ȯ�Ͽ� ���
			// => NamingException �߻� : �ĺ��ڷ� ��ϵ� �ڿ��� ���� ��� �߻��Ǵ� ����
			DataSource dataSource=(DataSource)ic.lookup("java:comp/env/jdbc/oracle");
			
			Connection con=dataSource.getConnection();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Apache DBCP</h1>");
			out.println("<hr>");
			out.println("<p>Connection = "+con+"</p>");
			out.println("</body>");
			out.println("</html>");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}











