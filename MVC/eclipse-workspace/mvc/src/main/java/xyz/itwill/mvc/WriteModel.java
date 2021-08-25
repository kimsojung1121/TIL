package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.exception.ExistsUserinfoException;
import xyz.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� [/write.do]�� ��û�� ��� ���۵Ǵ� �� Ŭ����
// => ȸ�������� ���޹޾� USERINFO ���̺� ����ǵ��� ó��
// => [loginForm.do]�� �����̷�Ʈ �̵��ϱ� ���� ���� ��ȯ
public class WriteModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		UserinfoDTO userinfo=null;
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
			
			userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			userinfo.setPassword(password);
			userinfo.setName(name);
			userinfo.setEmail(email);
			userinfo.setStatus(status);
			
			//ȸ�������� ���޹޾� USERINFO ���̺� �����ϴ� Service Ŭ������ �޼ҵ� ȣ��
			// => ���̵� �ߺ��� ��� ExistsUserinfoExcpetion �߻�
			UserinfoService.getService().addUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (ExistsUserinfoException e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userinfo", userinfo);
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
