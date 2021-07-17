package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ���� ������ ��Ű�� �о� Ŭ���̾�Ʈ���� ��Ű���� �����ϴ� ����
// => Ŭ���̾�Ʈ�� ��û URL �ּҸ� �̿��Ͽ� �ش� ���� ������ ����� ��� ��Ű�� ������ ����  
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Ŭ���̾�Ʈ���� ������ ��� ��Ű�� ��ȯ�޾� ����
		//HttpServletRequest.getCookies() : Ŭ���̾�Ʈ���� ������ ��� ��Ű�� Cookie 
		//�ν��Ͻ� �迭�� ��ȯ�ϴ� �޼ҵ�
		Cookie[] cookies=request.getCookies();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>��Ű �б�</h1>");
		out.println("<hr>");
		if(cookies==null) {//Ŭ���̾�Ʈ���� ������ ��Ű�� ���� ���
			out.println("<p>�� �ȿ� ��Ű ����.</p>");
		} else {
			String id="";
			String count="";
			
			//Ŭ���̾�Ʈ���� ������ ��Ű �� ���ϴ� ��Ű�� ��Ű���� ��ȯ�޾� ����
			for(Cookie cookie:cookies) {
				//Cookie.getName() : ��Ű�� ����� ��Ű���� ��ȯ�ϴ� �޼ҵ�
				if(cookie.getName().equals("id")) {
					//Cookie.getValue() : ��Ű�� ����� ��Ű���� ��ȯ�ϴ� �޼ҵ�
					id=cookie.getValue();
				} else if(cookie.getName().equals("count")) {
					count=cookie.getValue();
				}
			}
			
			//��Ű���� Ŭ���̾�Ʈ���� ����
			if(!id.equals("")) {//��Ű���� �ִ� ��� 
				out.println("<p>���̵� = "+id+"</p>");
			}
			
			if(!count.equals("")) {//��Ű���� �ִ� ���
				int cnt=Integer.parseInt(count)+1;
				out.println("<p>��ûȽ�� = "+cnt+"</p>");
				
				//Cookie �ν��Ͻ��� �����Ͽ� Ŭ���̾�Ʈ���� ����
				// => ��Ű���� ���� ��� ���� ��Ű�� ��� ���ο� ��Ű������ ����
				Cookie cookie=new Cookie("count", cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}
		}
		
		out.println("<hr>");
		out.println("<p><a href='create.itwill'>��Ű ����</a></p>");
		out.println("<p><a href='remove.itwill'>��Ű ����</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}











