package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� [/modify.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => ȸ�������� ���޹޾� USERINFO ���̺� ����� �ش� ȸ�������� ����ǵ��� ó��
// => [view.do]�� �����̷�Ʈ �̵��ϱ� ���� ���� ��ȯ - ���̵� ����
public class ModifyModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			request.setCharacterEncoding("utf-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			int status=Integer.parseInt(request.getParameter("status"));
			
			UserinfoDTO userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			//��й�ȣ�� ���޵��� ���� ��� - ���� ��й�ȣ�� �����Ͽ� ����
			if(password==null || password.equals("")) {
				userinfo.setPassword(UserinfoService.getService().getUserinfo(userid).getPassword());
			} else {//��й�ȣ�� ���޵� ��� - ���ο� ��й�ȣ�� ����Ͽ� ����
				userinfo.setPassword(password);
			}
			userinfo.setName(name);
			userinfo.setEmail(email);
			userinfo.setStatus(status);
			
			//ȸ�������� ���޹޾� USERINFO ���̺� ����� �ش� ȸ�������� �����ϴ� Service Ŭ������ �޼ҵ� ȣ��
			UserinfoService.getService().modifyUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("view.do?userid="+userid);
		} catch (Exception e) {
			System.out.println("[����]�޼��� = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}

}
