package xyz.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;

//���������(select.itwill)���� ���޵� ���� �Խñ۹�ȣ�� ��ȯ�޾� GUEST ���̺� �����
//�ش� �۹�ȣ�� ���� �Խñ��� �����ϰ� ���������(select.itwill)�� ��û�Ͽ� �̵��ϴ� ������ 
//�����ϴ� ���� - ó��������(����)
@WebServlet("/delete.itwill")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������� ��û�� ���� ó��  
		if(request.getParameter("no")==null) {//���ް��� ���� ���
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		//���ް��� ��ȯ�޾� ���� - ���޹��� ���ڿ��� ���������� ��ȯ�Ͽ� ����
		int no=Integer.parseInt(request.getParameter("no"));
		
		//GUEST ���̺� ����� ���� �Խñ� �� ���޹��� �۹�ȣ�� �Խñ��� �����ϴ�
		//DAO Ŭ������ �޼ҵ� ȣ��
		int rows=GuestDAO.getDAO().deleteGuest(no);
		
		if(rows>0) {//������ ���� �ִ� ���
			response.sendRedirect("select.itwill");
		} else {//������ ���� ���� ��� - ���������� ��û
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
