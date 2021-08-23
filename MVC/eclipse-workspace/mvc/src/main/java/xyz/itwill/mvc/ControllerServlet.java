package xyz.itwill.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 요청에 대한 처리는 모델(Model : 클래스)을
//통해 구현하고 처리결과를 뷰(View : JSP)에게 전달하여 응답되도록 이동하는 웹프로그램(서블릿)

//1.클라이언트의 모든 요청을 받을 수 있는 단일 진입점의 기능 설정
//@WebServlet("URL") : 클래스를 웹프로그램(서블릿)으로 등록하고 URL 주소를 매핑하는 어노테이션
// => URL 주소에 패턴기호(* 또는 ?)를 사용하여 설정 가능
// => @WebServlet("*.do") : 클라이언트가 XXX.do 형식의 URL 주소로 요청한 경우 서블릿 동작
// => @WebServlet 어노테이션 대신 web.xml 파일에서 서블릿 등록과 서블릿 매핑 설정 가능
//@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트의 요청을 처리하기 위해 자동 호출되는 메소드 
	// => 클라이언트의 요청이 있을 때마다 반복적으로 호출
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.클라이언트의 요청 분석 : 요청 URL 주소 이용 - http://localhost:8000/mvc/XXX.do
		//HttpServletRequest.getRequestURI() : 요청 URL 주소의 URI 주소를 반환하는 메소드
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);//"/mvc/XXX.do" 결과 출력
		
		//HttpServletRequest.getContextPath() : 요청 URL 주소의 컨텍스트 경로를 반환하는 메소드 
		String contextPath=request.getContextPath();
		//System.out.println("contextPath = "+contextPath);//"/mvc" 결과 출력
		
		//요청 URL 주소의 [/XXX.do]를 이용하여 요청에 대한 처리와 응답 구분
		String command=requestURI.substring(contextPath.length());
		//System.out.println("command = "+command);//"/XXX.do" 결과 출력
		
		//3.클라이언트 요청에 대한 처리
		// => 모델(Model) 역활의 클래스로 인스턴스를 생성하여 요청 처리 메소드 호출
		// => 모델 클래스의 요청 처리 메소드는 뷰 관련 정보 반환
		/*
		//클라이언트 요청에 대한 모델 클래스 매핑 설계
		// => 모델 클래스는 인터페이스를 상속받아 동일한 구조로 작성 - 유지보수의 효율성 증가
		/loginForm.do : LoginFormModel 클래스 - 로그인정보 입력페이지 또는 환영메세지 출력페이지
	 	/login.do : LoginModel 클래스 - 로그인 처리페이지
	 	/logout.do : LogoutModel 클래스 - 로그아웃 처리페이지
	 	/writeForm.do : WriteFormModel 클래스 - 회원정보 입력페이지
	 	/write.do : WriteModel 클래스 - 회원정보 등록 처리페이지
	 	/list.do : ListModel 클래스 - 회원목록 출력페이지
	 	/view.do : ViewModel 클래스 - 회원정보 상세 출력페이지
	 	/modifyForm.do : ModifyFormModel 클래스 - 회원정보 변경 입력페이지
	 	/modify.do : ModifyModel 클래스 - 회원정보 변경 처리페이지
	 	/remove.do : RemoveModel 클래스 - 회원정보 삭제 처리페이지
	 	/error.do : ErrorModel 클래스 - 에러메세지 출력페이지
		*/
		
		//인터페이스를 사용하여 참조변수 생성
		// => 참조변수에는 인터페이스를 상속받은 모든 자식클래스의 인스턴스 저장 가능
		Action action=null;		
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {//클라이언트 요청에 대한 Model 클래스가 없는 경우
			action=new ErrorModel();
		}
		
		//부모 인터페이스의 추상메소드를 호출하면 참조변수에 저장된 자식 인스턴스(모델)의
		//오버라이드 메소드 호출 - 메소드 오버라이드에 의한 다형성
		// => 요청 처리 메소드를 호출하여 뷰 관련 정보 반환받아 저장
		ActionForward actionForward=action.execute(request, response);
		
		//4.반환받은 뷰 관련 정보를 이용하여 클라이언트에게 응답 처리
		if(actionForward.isForward()) {//forward 필드값이 [true]인 경우 - 포워드 이동
			//컨트롤러에서 뷰(View - JSP 문서)로 스레드를 이동하여 JSP 문서로 클라이언트에게
			//HTML를 전달하여 응답 처리
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//forward 필드값이 [false]인 경우 - 리다이렉트 이동
			//클라이언트에게 URL 주소(/XXX.do)를 전달하여 재요청하도록 응답 처리
			response.sendRedirect(actionForward.getPath());
		}
	}
}
