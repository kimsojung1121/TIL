package xyz.itwill.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
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

	//��û����(Key)�� �� �ν��Ͻ�(Value)�� �����ϱ� ���� �ݷ��� �ʵ�
	private Map<String, Action> actionMap;
	
	//Ŭ���̾�Ʈ ��û�� ���� ���� Ŭ������ �ν��Ͻ��� ������ �� ���� ���� �ڵ� ȣ���ϴ� �޼ҵ�
	// => �ν��Ͻ� ���� �� �ѹ��� ȣ�� - �ʱ�ȭ �۾�
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("ControllerServlet Ŭ������ init() �޼ҵ� ȣ��");
		
		//�ݷ��� �ʵ忡 HashMap �ν��Ͻ��� �����Ͽ� ����
		actionMap=new HashMap<String, Action>();
		
		/*
		//�ݷ��� �ʵ忡 ��Ʈ��(��û���� - Key, �� �ν��Ͻ� - Value)�� �߰��Ͽ� ����
		actionMap.put("/loginForm.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeForm.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyForm.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
		
		//Properties ���Ͽ� ��û������ �� Ŭ������ �����ϰ� ������ ������ �о� �ݷ��� 
		//�ʵ��� ��Ʈ���� �߰� - ���������� ȿ���� ����
		//Properties ����(XXX.properties) : ���α׷� ���࿡ �ʿ��� ���� �����ϴ� �ؽ�Ʈ ����
		
		//Properties ������ ������ �о� �����ϱ� ���� Properties �ν��Ͻ�(Map) ����
		Properties properties=new Properties();
		
		//Properties ������ �ý��� ��θ� ��ȯ�޾� ����
		//String configFilePath=config.getServletContext().getRealPath("/WEB-INF/model.properties");
		
		//ServletConfig.getInitParameter(String name) : web.xml ���Ͽ��� servlet ������Ʈ��
		//�ڽ� ������Ʈ �� init-param ������Ʈ�� �����Ǵ� ���� ���� ��ȯ�ϴ� �޼ҵ�
		String configFile=config.getInitParameter("configFile");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		
		try {
			//Properties ���Ͽ� ���� �Է½�Ʈ�� �����Ͽ� ����
			FileInputStream in=new FileInputStream(configFilePath);
			
			//Properties ���Ͽ� ����� �������� Properties �ν��Ͻ��� ��Ʈ���� �߰�
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Properties �ν��Ͻ��� ��Ʈ��(��û������ ��Ŭ����)�� �о� �ݷ��� �ʵ��� 
		//��Ʈ��(��û������ �� �ν��Ͻ�)�� �߰�
		//Properties.keySet() : Properties �ν��Ͻ��� ����� ��� Ű(Key)���� Set �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
		for(Object key:properties.keySet()) {//Set �ν��Ͻ��� ���(Key)�� ���ʴ�� �����޾� �ݺ�ó�� 
			String actionCommand=(String)key;//��û���� ����
			
			//Properties.get(Object key) : Properties �ν��Ͻ��� ��Ʈ�� �� Ű(Key - ��û����)�� 
			//���޹޾� ��(Value - ��Ŭ����)�� ��ȯ�ϴ� �޼ҵ�
			String actionClass=(String)properties.get(key);//��Ŭ���� ����
			
			try {
				//��Ŭ������ �̿��Ͽ� �� �ν��Ͻ� ���� - ���÷��� ��� �̿�
				//���÷���(Reflection) : ���α׷� ����� Ŭ������ �о� �ν��Ͻ��� �����Ͽ�
				//�ν��Ͻ��� ���(�ʵ� �Ǵ� �޼ҵ�)�� ���� �����ϵ��� �����ϴ� ���
				//Class.forName(String className) : ���޹��� ���ڿ��� Ŭ������ �̿��Ͽ�
				//�޸𸮿� �����ϴ� �޼ҵ� - Class �ν��Ͻ�(Clazz) ��ȯ
				//Class.getDeclaredConstructor().newInstance() : �޸𸮿� ����� Ŭ����(Clazz)��
				//�̿��Ͽ� �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ� - Object Ÿ���� �ν��Ͻ� ��ȯ
				Action actionObject=(Action)Class.forName(actionClass).getDeclaredConstructor().newInstance();
				
				//�ݷ��� �ʵ忡 ��Ʈ��(Key - ��û����, Value - �� �ν��Ͻ�) �߰�
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �ڵ� ȣ��Ǵ� �޼ҵ� 
	// => Ŭ���̾�Ʈ�� ��û�� ���� ������ �ݺ������� ȣ��
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ControllerServlet Ŭ������ service() �޼ҵ� ȣ��");
		
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
		
		/*
		//�������̽��� ����Ͽ� �������� ����
		// => ������������ �������̽��� ��ӹ��� ��� �ڽ�Ŭ������ �ν��Ͻ� ���� ����
		Action action=null;		
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();
		} else if(command.equals("/writeForm.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/list.do")) {
			action=new ListModel();
		} else if(command.equals("/view.do")) {
			action=new ViewModel();
		} else if(command.equals("/modifyForm.do")) {
			action=new ModifyFormModel();
		} else if(command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if(command.equals("/remove.do")) {
			action=new RemoveModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {//Ŭ���̾�Ʈ ��û�� ���� Model Ŭ������ ���� ���
			action=new ErrorModel();
		}
		*/
		
		//�ݷ��� �ʵ忡 ����� ��Ʈ������ ��û����(Key - command)�� �����Ͽ� �� �ν��Ͻ�
		//(Value)�� ��ȯ�޾� �θ� �������̽��� ���������� ���� - ������ ����
		Action action=actionMap.get(command);
		if(action==null) {//Ŭ���̾�Ʈ ��û�� ���� �� �ν��Ͻ��� ���� ���
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
