package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� [/error.do]�� ��û�ϰų� ��û�� ���� ���� ���� ��� ���۵Ǵ� �� Ŭ����
// => [user_error.jsp]�� ������ �̵��ϱ� ���� ���� ��ȯ
public class ErrorModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("model_two/user_error.jsp");
		return actionForward;
	}
}
