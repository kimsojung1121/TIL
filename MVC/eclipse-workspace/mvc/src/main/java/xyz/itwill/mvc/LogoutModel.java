package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Ŭ���̾�Ʈ�� [/logout.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => �α׾ƿ� ó�� �� [loginForm.do]�� �����̷�Ʈ �̵��ϱ� ���� ���� ��ȯ
// => �α׾ƿ� ó�� : ���ε��� ���ǿ� ����� ���� ���� ���� ���� �Ǵ� ���� ����ε� ó��
public class LogoutModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//session.removeAttribute("loginUserinfo");
		session.invalidate();
		
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(false);
		actionForward.setPath("loginForm.do");
		return actionForward;
	}

}
