package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� [/remove.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => �����ڸ� ��û �����ϵ��� ���� ����
// => ���̵� ���޹޾� USERINFO ���̺� ����� �ش� ���̵��� ȸ�������� �����ǵ��� ó��
// => [list.do] �Ǵ� [logout.do]�� �����̷�Ʈ �̵��ϱ� ���� ���� ��ȯ
public class RemoveModel implements Action {
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

			//���̵� ���޹޾� USERINFO ���̺� ����� �ش� ���̵��� ȸ�������� �����ϴ� Service Ŭ������ �޼ҵ� ȣ��
			UserinfoService.getService().removeUserinfo(userid);
			
			actionForward.setForward(false);
			if(loginUserinfo.getUserid().equals(userid)) {
				actionForward.setPath("logout.do");
			} else {
				actionForward.setPath("list.do");
			}
		} catch (Exception e) {
			System.out.println("[����]�޼��� = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
