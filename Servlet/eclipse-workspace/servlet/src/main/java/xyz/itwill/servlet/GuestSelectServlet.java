package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//GUEST ���̺� ����� ��� ���� �Խñ��� �˻��Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ���� - ���������
// => [���� ����]�� Ŭ���ϸ� ���� �Խñ� �Է�������(insert.html)�� ��û�Ͽ� ������ �̵�
// => ���� �Խñ��� [����]�� Ŭ���ϸ� ���� �Խñ� ���� ó��������(delete.itwill)�� ��û�Ͽ� ������ �̵� - ���� �Խñ۹�ȣ ���� 
@WebServlet("/select.itwill")
public class GuestSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//GUEST ���̺� ����� ��� ���� �Խñ��� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		List<GuestDTO> guestList=GuestDAO.getDAO().selectAllGuestList();
		
		//��ȯ���� �˻������ Ŭ���̾�Ʈ���� ����
		out.println("<html>"); 
		out.println("<head>"); 
		out.println("<meta http-equiv='Content-Type' content='ext/html; charset=UTF-8'>"); 
		out.println("<title>::: ����:::</title>"); 
		out.println("<link rel='stylesheet' type='text/css' href='css/common.css'>"); 
		out.println("</head>"); 
		out.println("<body>"); 
		out.println("<table width='80%' align='center' border='0' cellspacing='0' cellpadding='0'>"); 
		out.println("<tr bgcolor='#000080' valign='middle'>"); 
		out.println("<td height='25' class='t1' align='center'>"); 
		out.println("<b><font color='#FFFFFF'>:::���� �б� :::</font></b>"); 
		out.println("</td>"); 
		out.println("</tr>"); 

		out.println("<tr>"); 
		out.println("<td height='30' align='right' valign='bottom' class='t1'>"); 
		out.println("<a href='insert.html'>���� ����</a></td>"); 
		out.println("</tr>"); 
		
		if(guestList.isEmpty()) {//List �ν��Ͻ��� ����� ��Ұ� �ϳ��� ���� ���
			out.println("<tr align='center'>");
			out.println("<td>���Ͽ� ����� �Խñ��� �ϳ��� �����ϴ�.</td>");
			out.println("</tr>");
		} else {
			for(GuestDTO guest:guestList) {
				out.println("<tr>"); 
				out.println("<td>"); 
				out.println("<table width='100%' align='center' border='1' cellspacing='0' bgcolor='#f5f5f5'>"); 
				out.println("<tr>"); 
				out.println("<td>"); 
				out.println("<table width='100%' align='center' border='0' cellspacing='0'>"); 
				out.println("<tr>"); 
				out.println("<td bgcolor='#808000' align='center' height='20' width='20%' class='t1'>"); 
				out.println("<font color='#FFFFFF'>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</font></td>"); 
				out.println("<td height='20' width='80%' class='t1'>"); 
				out.println("<b><font color='#0000FF'>&nbsp;&nbsp;"+guest.getTitle()+"</font></b></td>"); 
				out.println("</tr>"); 
				out.println("</table>"); 
				out.println("</td>"); 
				out.println("</tr>"); 
		
				out.println("<tr>"); 
				out.println("<td>"); 
				out.println("<table width='100%' align='center' border='0' cellspacing='0'>"); 
				out.println("<tr>"); 
				out.println("<td bgcolor='#808000' align='center' height='20' width='20%' class='t1'>"); 
				out.println("<font color='#FFFFFF'>�� �� ��</font></td>"); 
				out.println("<td align='center' height='20' width='30%' class='t1'>"+guest.getName()+"</td>"); 
				out.println("<td bgcolor='#808000' align='center' height='20' width='20%' class='t1'>"); 
				out.println("<font color='#FFFFFF'>�� �� ��</font></td>"); 
				out.println("<td align='center' height='20' width='30%' class='t1'>"+guest.getRegdate()+"</td>"); 
				out.println("</tr>"); 
				out.println("</table>"); 
				out.println("</td>"); 
				out.println("</tr>"); 
		
				out.println("<tr>"); 
				out.println("<td>"); 
				out.println("<table width='100%' align='center' border='0' cellspacing='10'>"); 
				out.println("<tr>"); 
				out.println("<td height='50' width='100%' class='t1'>"); 
				out.println(guest.getContent().replace("\n", "<br>")); 
				out.println("</td>"); 
				out.println("</tr>"); 
				
				out.println("<tr>"); 
				out.println("<td height='50' width='100%' class='t1'>"); 
				out.println("<button type='button' onclick='location.href=\"delete.itwill?no="+guest.getNo()+"\"'>����</button>"); 
				out.println("</td>"); 
				out.println("</tr>");
				
				out.println("</table>"); 
				out.println("</td>"); 
				out.println("</tr>"); 
				out.println("</table>"); 
				out.println("</td>"); 
				out.println("</tr>"); 
				out.println("<tr>"); 
				out.println("<td height='20'>"); 
				out.println("<hr color='#000077'>"); 
				out.println("</td>"); 
				out.println("</tr>"); 
			}
		}
		out.println("</table>"); 
		out.println("</body>"); 
		out.println("</html>"); 
	}

}










