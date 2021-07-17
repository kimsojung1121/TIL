package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����(������ ����Ǵ� ���α׷�) �ۼ� ���
//1.HttpServlet Ŭ������ ��ӹ޾� �ۼ� - ���� Ŭ����
// => HttpServlet Ŭ������ ��ӹ��� �ڽ�Ŭ������ ��ü ����ȭ Ŭ������ serialVersionUID �ʵ带 �����ϴ� ���� ����
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//2.doGet() �Ǵ� doPost() �޼ҵ带 �������̵� ����
	// => Ŭ���̾�Ʈ ��û�� ���� ó���� ó�����(���� - HTML)�� �����ϱ� ���� �޼ҵ� - WAS(Web Application Server)�� ���� �ڵ� ȣ��
	// => doGet() : Ŭ���̾�Ʈ�� GET ������� ��û�� ��� ȣ��Ǵ� �޼ҵ�
	// => doPost() : Ŭ���̾�Ʈ�� POST ������� ��û�� ��� ȣ��Ǵ� �޼ҵ�
	//doGet() �Ǵ� doPost() �޼ҵ� ��� service() �޼ҵ� �������̵� ����
	// => service() : Ŭ���̾�Ʈ�� ��� ��û�� ���� ȣ��Ǵ� �޼ҵ�
	// => doGet() �Ǵ� doPost() �޼ҵ庸�� service() �޼ҵ��� ȣ�� ������ ���� ����
	//WAS�� ���� �޼ҵ尡 ȣ��� �� HttpServletRequest �ν��Ͻ��� HttpServletResponse �ν��Ͻ���
	//�Ű������� �ڵ����� ���޵Ǿ� ����
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest : ������Ʈ �޼���(��û����)�� ����� �ν��Ͻ�
		//HttpServletResponse : �������� �޼���(��������)�� ����� �ν��Ͻ�
		
		//3.Ŭ���̾�Ʈ���� ������ ����(����)�� ����(Mime Type) ����(����)
		// => ���� �������� ������ ��� ������ ĳ���ͼ�(CharacterSet : �������� - ���ڵ�) ����
		// => �⺻ ���� ���� ���� : text/html, ĳ���ͼ� : ISO-8859-1(��������)
		//HttpServletResponse.setContentType(String mimeType[;charset=encoding])
		response.setContentType("text/html;charset=utf-8");
		
		//4.Ŭ���̾�Ʈ���� ��û�� ���� ó�� ����� ����(����)�ϱ� ���� ��� ��Ʈ���� ��ȯ�޾� ����
		//����)HttpServletResponse.getOutputStream() : ���� ����Ÿ(1Byte)�� ������ �� �ִ�
		//��� ��Ʈ��(ServletOutputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		// => �׸�,����,���� ���ϵ��� Ŭ���̾�Ʈ���� �����ϱ� ���� ����ϴ� ��� ��Ʈ�� 
		//����)HttpServletResponse.getWriter() : ���ڵ� ó���� ���� ����Ÿ(2Byte)�� ������
		//�� �ִ� ��� ��Ʈ��(PrintWriter �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		// => PlanText, HTML, XML �������� Ŭ���̾�Ʈ���� �����ϱ� ���� ����ϴ� ��� ��Ʈ��
		PrintWriter out=response.getWriter();
		
		//5.��û ó�� �� ó�� ����� ����(����)�� ���� - ����
		// => ��� ��Ʈ���� �̿��Ͽ� ó�� ����� �����ϸ� ����(����) ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>����(Servlet)</h1>");
		out.println("<hr>");
		out.println("<p>Hello, Servlet!!!</p>");
		out.println("</body>");
		out.println("</html>");
		
		//6.���� Ŭ������ �����α׷����� ��� ����
		// => [web.xml] ���Ͽ��� ���� Ŭ������ �������� ����ϰ� URL �ּҸ� ���� ����
		// => ���ε� URL �ּҷ� Ŭ���̾�Ʈ�� ��û�ϸ� WAS�� ��ϵ� ������ �����Ͽ� ����
	}
}

