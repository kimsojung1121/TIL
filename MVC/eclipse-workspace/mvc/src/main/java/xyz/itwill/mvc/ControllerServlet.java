package xyz.itwill.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ�� ��� ��û�� �޾� ��û�� ���� ó���� ��(Model : Ŭ����)��
//���� �����ϰ� ó������� ��(View : JSP)���� �����Ͽ� ����ǵ��� �̵��ϴ� �����α׷�(����)

//1.Ŭ���̾�Ʈ�� ��� ��û�� ���� �� �ִ� ���� �������� ��� ����
//@WebServlet("URL") : Ŭ������ �����α׷�(����)���� ����ϰ� URL �ּҸ� �����ϴ� ������̼�
// => URL �ּҿ� ���ϱ�ȣ(* �Ǵ� ?)�� ����Ͽ� ���� ����
// => @WebServlet("*.do") : Ŭ���̾�Ʈ�� XXX.do ������ URL �ּҷ� ��û�� ��� ���� ����
// => @WebServlet ������̼� ��� web.xml ���Ͽ��� ���� ��ϰ� ���� ���� ���� ����
//@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �ڵ� ȣ��Ǵ� �޼ҵ� 
	// => Ŭ���̾�Ʈ�� ��û�� ���� ������ �ݺ������� ȣ��
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.Ŭ���̾�Ʈ�� ��û �м� : ��û URL �ּ� �̿� - http://localhost:8000/mvc/XXX.do
		//HttpServletRequest.getRequestURI() : ��û URL �ּ��� URI �ּҸ� ��ȯ�ϴ� �޼ҵ�
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);//"/mvc/XXX.do" ��� ���
		
		//HttpServletRequest.getContextPath() : ��û URL �ּ��� ���ؽ�Ʈ ��θ� ��ȯ�ϴ� �޼ҵ� 
		String contextPath=request.getContextPath();
		//System.out.println("contextPath = "+contextPath);//"/mvc" ��� ���
		
		//��û URL �ּ��� [/XXX.do]�� �̿��Ͽ� ��û�� ���� ó���� ���� ����
		String command=requestURI.substring(contextPath.length());
		//System.out.println("command = "+command);//"/XXX.do" ��� ���
		
		//3.Ŭ���̾�Ʈ ��û�� ���� ó��
		// => ��(Model) ��Ȱ�� Ŭ������ �ν��Ͻ��� �����Ͽ� ��û ó�� �޼ҵ� ȣ��
		// => �� Ŭ������ ��û ó�� �޼ҵ�� �� ���� ���� ��ȯ
		/*
		//Ŭ���̾�Ʈ ��û�� ���� �� Ŭ���� ���� ����
		// => �� Ŭ������ �������̽��� ��ӹ޾� ������ ������ �ۼ� - ���������� ȿ���� ����
		/loginForm.do : LoginFormModel Ŭ���� - �α������� �Է������� �Ǵ� ȯ���޼��� ���������
	 	/login.do : LoginModel Ŭ���� - �α��� ó��������
	 	/logout.do : LogoutModel Ŭ���� - �α׾ƿ� ó��������
	 	/writeForm.do : WriteFormModel Ŭ���� - ȸ������ �Է�������
	 	/write.do : WriteModel Ŭ���� - ȸ������ ��� ó��������
	 	/list.do : ListModel Ŭ���� - ȸ����� ���������
	 	/view.do : ViewModel Ŭ���� - ȸ������ �� ���������
	 	/modifyForm.do : ModifyFormModel Ŭ���� - ȸ������ ���� �Է�������
	 	/modify.do : ModifyModel Ŭ���� - ȸ������ ���� ó��������
	 	/remove.do : RemoveModel Ŭ���� - ȸ������ ���� ó��������
	 	/error.do : ErrorModel Ŭ���� - �����޼��� ���������
		*/
		
		//�������̽��� ����Ͽ� �������� ����
		// => ������������ �������̽��� ��ӹ��� ��� �ڽ�Ŭ������ �ν��Ͻ� ���� ����
		Action action=null;		
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {//Ŭ���̾�Ʈ ��û�� ���� Model Ŭ������ ���� ���
			action=new ErrorModel();
		}
		
		//�θ� �������̽��� �߻�޼ҵ带 ȣ���ϸ� ���������� ����� �ڽ� �ν��Ͻ�(��)��
		//�������̵� �޼ҵ� ȣ�� - �޼ҵ� �������̵忡 ���� ������
		// => ��û ó�� �޼ҵ带 ȣ���Ͽ� �� ���� ���� ��ȯ�޾� ����
		ActionForward actionForward=action.execute(request, response);
		
		//4.��ȯ���� �� ���� ������ �̿��Ͽ� Ŭ���̾�Ʈ���� ���� ó��
		if(actionForward.isForward()) {//forward �ʵ尪�� [true]�� ��� - ������ �̵�
			//��Ʈ�ѷ����� ��(View - JSP ����)�� �����带 �̵��Ͽ� JSP ������ Ŭ���̾�Ʈ����
			//HTML�� �����Ͽ� ���� ó��
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//forward �ʵ尪�� [false]�� ��� - �����̷�Ʈ �̵�
			//Ŭ���̾�Ʈ���� URL �ּ�(/XXX.do)�� �����Ͽ� ���û�ϵ��� ���� ó��
			response.sendRedirect(actionForward.getPath());
		}
	}
}
