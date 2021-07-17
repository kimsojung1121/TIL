package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//������ ���ε��Ͽ� Ŭ���̾�Ʈ���� ���������� �����ϴ� ����
//����(Session) : ����(�����α׷�)�� Ŭ���̾�Ʈ���� ���� ���Ӽ��� �����ϱ� ���� ������
//�����ϴ� �� - ���� ���̵�� Ŭ���̾�Ʈ�� �����Ͽ� ���ǰ�(�ν��Ͻ�) ����
//���� ���ε�(Session Binding) : ������ �����α׷����� ����� �� �ֵ��� �����ϴ� �۾� - WAS�� ���� ó��
//Ŭ���̾�Ʈ���� JSESSIONID �̸��� ��Ű�� �������� ���� ��쿡�� ������ �����Ͽ� ���ε� ó��
// => ������ ������ ���̵�(�ĺ���)�� JSESSIONID �̸��� ��Ű������ �����Ͽ� Ŭ���̾�Ʈ���� ����
//Ŭ���̾�Ʈ���� JSESSIONID �̸��� ��Ű�� ������ ��� ���� Ʈ��ŷ �� �˻��� �������� ���ε� ó��
// => ���� Ʈ��ŷ �� �˻��� ������ ���� ��� ������ �����Ͽ� ���ε� ó��
//���� Ʈ��ŷ(Session Tracking) : Ŭ���̾�Ʈ���� ������ JSESSIONID�� ��Ű���� ������ �����ϴ�
//��� ������ ���̵�� ���Ͽ� �˻��Ͽ� �۾�
@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//HttpServletRequest.getSession() : ���ε��� ����(HttpSession �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		// => HttpSession �ν��Ͻ��� �����Ͽ� ���ε��ϰų� ���� HttpSession �ν��Ͻ��� ���ε��Ͽ� ��ȯ
		//������ �����Ǿ� ���ε��� ��� ������ ������ �ĺ���(ID)�� JSESSIONID �̸��� ��Ű�� Ŭ���̾�Ʈ���� ����
		// => JSESSIONID ��Ű�� �⺻������ �����ð��� -1�� �����Ǿ� ������ ����� �Ҹ�
		//HttpSession : ������ �����ϱ� ���� �ν��Ͻ� - WAS�� ���� ����
		HttpSession session=request.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>����(Session)</h1>");
		out.println("<hr>");
		//HttpSession.isNew() : ������ Ʈ��ŷ�Ͽ� ���ε��� ��� false ��ȯ, ������ �����Ͽ�
		//���ε��� ��� ture�� ��ȯ�ϴ� �޼ҵ�
		if(session.isNew()) {
			out.println("<p>������ �����Ͽ� ���ε� �Ͽ����ϴ�.</p>");
		} else {
			out.println("<p>������ Ʈ��ŷ�Ͽ� ���ε� �Ͽ����ϴ�.</p>");
		}
		
		//HttpSession.getId() : ���ε��� ������ �ĺ��ڸ� ��ȯ�ϴ� �޼ҵ�
		out.println("<p>���� ���̵� = "+session.getId()+"</p>");

		//HttpSession.getCreationTime() : ���ε��� ������ ������ �ð�(TimeStamp)�� ��ȯ�ϴ� �޼ҵ�
		out.println("<p>���� �����ð� = "+session.getCreationTime()+"</p>");

		//HttpSession.getMaxInactiveInterval() : ���ε��� ������ �����ð�(��)�� ��ȯ�ϴ� �޼ҵ�
		// => ���� �����ð��� �������� ���� ��� �⺻���� 1800��(30��)���� ����
		out.println("<p>���� �����ð� = "+session.getMaxInactiveInterval()+"</p>");
		
		//HttpSession.setAttribute(String name, Object value) : ���ε��� ���ǿ� ���ǰ��� �����ϴ� �޼ҵ�
		// => ���ǿ� �Ӽ���(AttributeName - String)�� �Ӽ���(AttributeValue - Instance)�� �ϳ��� ��� ����
		// => ������ ���ε��� ��� �����α׷����� �Ӽ����� �̿��Ͽ� �Ӽ����� ��ȯ�޾� ��� - �ν��Ͻ� ���� 
		session.setAttribute("now", new Date());
		
		//HttpSession.getAttribute(String name) : ���ε��� ���ǿ� ����� �Ӽ���(�ν��Ͻ�)��
		//�Ӽ������� ��ȯ�ϴ� �޼ҵ�
		// => �Ӽ����� Object Ÿ���� �ν��Ͻ��� ��ȯ�ǹǷ� ����� ��ü ����ȯ ó���Ͽ� ����
		// => �Ӽ��� ���� �Ӽ����� ���� ��� null ��ȯ
		Date now=(Date)session.getAttribute("now");
		out.println("<p>���ǿ� ����� �ν��Ͻ� = "+now+"</p>");
		
		//HttpSession.removeAttribute(String name) : ���ε��� ���ǿ� ����� �Ӽ���(�ν��Ͻ�)��
		//�Ӽ������� �����ϴ� �޼ҵ�
		session.removeAttribute("now");
		
		//HttpSession.invalidate() : ���ε��� ������ ����ε�(UnBinding)�ϰ� �����ϴ� �޼ҵ�
		//session.invalidate();
		
		out.println("</body>");
		out.println("</html>");
	}

}















