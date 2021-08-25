package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;

//Ŭ���̾�Ʈ�� [/writeForm.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => �����ڸ� ��û �����ϵ��� ���� ����
// => [user_write.jsp]�� ������ �̵��ϱ� ���� ���� ��ȯ
public class WriteFormModel implements Action {
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
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_write.jsp");
		} catch (Exception e) {
			System.out.println("[����]�޼��� = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
