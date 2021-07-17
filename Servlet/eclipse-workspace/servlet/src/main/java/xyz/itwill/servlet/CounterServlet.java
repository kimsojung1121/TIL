package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� ���� ��ûȽ���� �����Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ����
// => Ŭ���̾�Ʈ�� ���� ��ûȽ���� ���� ����(/WEB-INF/counter.txt)�� �����Ͽ� ���
@WebServlet("/counter.itwill")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//������ ��ûȽ���� �����ϱ� ���� �ʵ�
	// => WAS ����� �ν��Ͻ��� ���ŵǱ� �� �ʵ� �ڵ� �Ҹ� - �ʵ尪 ���� �Ұ���
	private int count;
	
	//ī���� ������ �����ϴ� ������ �ý��� ��θ� �����ϱ� ���� �ʵ�
	private String counterFilePath;
	
	//init() �޼ҵ�� ī���� ������ ������ ���Ͽ��� ���� ��ûȽ���� �о� �ʵ忡 ����
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ī���� ������ �����ϴ� ������ �ý��� ��θ� ��ȯ�޾� ����
		// => workspace ������ �ƴ� webapps ������ �ý��� ��� ��ȯ
		counterFilePath=config.getServletContext().getRealPath("/WEB-INF/counter.txt");
		//System.out.println("counterFilePath = "+counterFilePath);
		
		try {
			//ī���� ������ �����ϴ� ������ �Է� ��Ʈ���� �����Ͽ� ����
			// => ī���� ������ �����ϴ� ������ ���� ��� FileNotFoundException �߻�
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(counterFilePath));
			
			//���� �Է� ��Ʈ���� �̿��Ͽ� ���Ͽ� ����� ���� ��ûȽ���� �о� �ʵ忡 ����
			count=(Integer)in.readObject();
			
			//���� �Է� ��Ʈ�� ����
			in.close();
		} catch (Exception e) {
			count=0;
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//������ ��ûȽ���� �����ϱ� ���� ����
		// => �޼ҵ尡 ����Ǹ� �ڵ� �Ҹ�Ǵ� �������� - ������ ���� �Ұ���
		//int count=0;
		
		//���� ��ûȽ�� ����
		count++;
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>������ ī����</h1>");
		out.println("<hr>");
		out.println("<p>���� ��ûȽ�� = "+count+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	//destroy() �޼ҵ�� ī���� ������ ������ ���Ͽ� �ʵ忡 ����� ���� ��ûȽ���� ����
	@Override
	public void destroy() {
		try {
			//ī���� ������ ������ ������ ��� ��Ʈ���� �����Ͽ� ����
			// => ī���� ������ ������ ������ ���� ��� ������ �����Ͽ� �ʵ尪 ����
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(counterFilePath));
			
			//�ʵ尪�� ���� ��� ��Ʈ������ �����Ͽ� ���Ͽ� ����
			out.writeObject(count);
			
			//���� ��� ��Ʈ�� ����
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







