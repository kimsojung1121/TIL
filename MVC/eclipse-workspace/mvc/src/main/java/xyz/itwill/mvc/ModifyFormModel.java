package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� [/modifyForm.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => �����ڸ� ��û �����ϵ��� ���� ����
// => ���̵� ���޹޾� USERINFO ���̺� ����� �ش� ���̵��� ȸ�������� �˻��Ͽ� Request Scope�� �Ӽ������� ����
// => [user_modify.jsp]�� ������ �̵��ϱ� ���� ���� ��ȯ
public class ModifyFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			//��α��� ������̰ų� �����ڰ� �ƴ� ��� ������ ���� �߻�
			if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
				throw new Exception();
			}
			
			String userid=request.getParameter("userid");
			
			//���̵� ���޹޾� USERINFO ���̺� ����� �ش� ���̵��� ȸ�������� �˻��ϴ� Service Ŭ������ �޼ҵ� ȣ��
			// => ��ȯ�޾� ���(ȸ������)�� ��(JSP)���� ����ϵ��� Request Scope�� �Ӽ������� ����
			request.setAttribute("userinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_modify.jsp");
		} catch (Exception e) {
			System.out.println("[����]�޼��� = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
