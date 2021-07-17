package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����(�����α׷�)�� Ŭ���̾�Ʈ ��û�� ���� WAS(Web Application Server)�� ��ϵ� ����
//Ŭ������ �о� �޸𸮿� �����ϰ� �ν��Ͻ��� �����Ͽ� service() �޼ҵ带 ȣ���Ͽ� ��û��
//���� ó���� ���� ��� ����
// => ���� Ŭ������ �ν��Ͻ��� �̹� ������ ��� �ν��Ͻ��� �������� �ʰ� ���� �ν��Ͻ��� service() �޼ҵ� ȣ��
// => WAS�� �ֿ� ��� �� �ϳ��� ���� ���� �ν��Ͻ��� �����ϴ� �����̳�(Container) ���
//�����̳�(Container) : �ν��Ͻ��� �����ֱ�(LifeCycle)�� ����(����,���,�Ҹ�)�ϴ� ���α׷�
@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	//������(Constructor) : �ν��Ͻ��� �����ϱ� ���� �޼ҵ� - �ʱ�ȭ �۾� : �ʵ� �ʱ�ȭ
	// => Ŭ���̾�Ʈ ��û�� WAS�� ���� ���� Ŭ������ �ν��Ͻ��� ������ �� �ѹ��� ȣ��
	public LifeCycleServlet() {
		System.out.println("### LifeCycleServlet Ŭ������ ������ ȣ�� ###");
		//name="ȫ�浿";
	}
	
	//init() : WAS�� ���� Ŭ������ �ν��Ͻ��� �����ϰ� ���� ���� �ѹ��� ȣ���ϴ� �޼ҵ�
	// => ������ ��� init() �޼ҵ�� �ʵ� �ʱ�ȭ �۾�
	//������ ��� init() �޼ҵ�� �ʱ�ȭ �۾��� �ϴ� ������ ServletConfig �ν��Ͻ��� 
	//�Ű������� �����޾� ����Ͽ� �ʵ� �ʱ�ȭ �۾��� ����
	//ServletConfig : ���ؽ�Ʈ ���� ȯ�������� �����ϴ� �ν��Ͻ�
	// => [web.xml] ���Ͽ� ������ ������ �����޾� ��� ����
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("### LifeCycleServlet Ŭ������ init() �޼ҵ� ȣ�� ###");
		//name="ȫ�浿";
		
		//ServletConfig.getServletContext() : ServletContext �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//ServletContext.getInitParameter(String parameterName) : [web.xml] ������ context-param
		//������Ʈ�� �����Ǵ� ���� ���� ��ȯ�ϴ� �޼ҵ�
		name=config.getServletContext().getInitParameter("name");
	}
	
	//service() : Ŭ���̾�Ʈ ��û���� WAS�� ���� �ݺ������� ȣ��Ǵ� �޼ҵ�
	// => Ŭ���̾�Ʈ ��û�� ���� ó���� ���� ��� �����Ͽ� ����
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet Ŭ������ service() �޼ҵ� ȣ�� ###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>������ �����ֱ�</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"��, �ȳ��ϼ���.</p>");
		out.println("<img src='image.itwill' width='300'>");
		out.println("</body>");
		out.println("</html>");
	}
	
	//destroy() : ���� �ν��Ͻ� �Ҹ� �� �ѹ��� ȣ��Ǵ� �޼ҵ� - ������ �۾�
	// => WAS ����� WAS�� ���� ������ �ν��Ͻ��� �ڵ� �Ҹ�
	@Override
	public void destroy() {
		System.out.println("### LifeCycleServlet Ŭ������ destroy() �޼ҵ� ȣ�� ###");
	}
}








