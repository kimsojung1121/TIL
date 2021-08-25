package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� [/list.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => �α��� ����ڸ� ��û �����ϵ��� ���� ����
// => USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� Request Scope�� �Ӽ������� ����
// => [user_list.jsp]�� ������ �̵��ϱ� ���� ���� ��ȯ
public class ListModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null) {
				throw new Exception();
			}
			
			//USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� Service Ŭ������ �޼ҵ� ȣ��
			// => ��ȯ�޾� ���(ȸ�����)�� ��(JSP)���� ����ϵ��� Request Scope�� �Ӽ������� ����
			request.setAttribute("userinfoList", UserinfoService.getService().getUserinfoList());
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_list.jsp");
		} catch (Exception e) {
			System.out.println("[����]�޼��� = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
