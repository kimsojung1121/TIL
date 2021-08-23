package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 모델 클래스가 반드시 상속 받아야 되는 인터페이스
// => 모델 클래스의 요청 처리 메소드에 작성 규칙 제공
// => 메소드 호출의 편의성 및 유지보수의 효율성 증가
//요청 처리메소드는 HttpServletRequst 인스턴스와 HttpServletResponse 인스턴스를 매개변수로
//전달받아 요청에 대한 처리작업을 실행하고 뷰 관련 정보(이동 관련 정보)를 반환하도록 작성
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
