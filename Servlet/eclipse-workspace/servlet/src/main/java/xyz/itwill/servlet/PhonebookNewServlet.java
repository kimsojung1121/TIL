package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.PhonebookDAO;
import xyz.itwill.dto.PhonebookDTO;

//PHONEBOOK ���̺� ����� ��� ���� �˻��Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ���� - DAO Ŭ����
@WebServlet("/new.itwill")
public class PhonebookNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//PHONEBOOK ���̺� ����� ��� ���� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		List<PhonebookDTO> phonebookList=PhonebookDAO.getDAO().selectAllPhonebook();
		
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
		for(PhonebookDTO phonebook:phonebookList) {
			out.println("<tr align='center'>");
			out.println("<td>"+phonebook.getPhone()+"</td>");
			out.println("<td>"+phonebook.getName()+"</td>");
			out.println("<td>"+phonebook.getAddress()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
