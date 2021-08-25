package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.exception.PasswordMissMatchException;
import xyz.itwill.exception.UserinfoNotFoundException;
import xyz.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� [/login.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => ���������� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���Ͽ� ����ó�� ��� ����
// => ���� ���� : ���ǿ� ���� ���� ������ �����ϰ� [loginForm.do]�� �����̷�Ʈ �̵��ϱ� ���� ���� ��ȯ
// => ���� ���� : [user_login.jsp]�� ������ �̵��ϱ� ���� ���� ��ȯ - JSP ������ �޼����� ���̵� ����
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		//��û ó���� �߻��Ǵ� ��� ���ܸ� ��Ƴ��� ����ó��
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();//������ ���� �߻�
			}
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//�� Ŭ������ ��û ó�� �޼ҵ�� Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ��û ó��
			//UserinfoService Ŭ������ ���� ó�� �޼ҵ� ȣ��
			// => Service Ŭ������ �޼ҵ忡�� ���ܰ� �߻��� ��� ���� ����
			UserinfoService.getService().auth(userid, password);
			
			//���� Ŭ������ �޼ҵ带 ȣ���Ͽ� ���ܰ� �߻����� ���� ��� ���� ����
			// => ���ǿ� ���� ���� ������ �Ӽ������� ����
			HttpSession session=request.getSession();//������ ���ε��Ͽ� ����
			session.setAttribute("loginUserinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (UserinfoNotFoundException | PasswordMissMatchException e) {//JDK1.7 �̻�
			//Request Scope : �����尡 �̵��Ǵ� JSP ���������� �Ӽ������� ����� �ν��Ͻ��� 
			//��ȯ�޾� ��� ����
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_login.jsp");
		} catch (Exception e) {//��� �߻� ���ܿ� ���� ó�� - ������������ �����̷�Ʈ �̵�
			System.out.println("[����]�޼��� = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
