package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/view.do]를 요청한 경우 동작되는 모델 클래스
// => 로그인 사용자만 요청 가능하도록 권한 설정
// => 아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 검색하여 Request Scope의 속성값으로 저장
//=> [user_view.jsp]로 포워드 이동하기 위한 정보 반환
public class ViewModel implements Action {
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
			
			String userid=request.getParameter("userid");
			
			//아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 검색하는 Service 클래스의 메소드 호출
			// => 반환받아 결과(회원정보)를 뷰(JSP)에서 출력하도록 Request Scope의 속성값으로 저장
			request.setAttribute("userinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_view.jsp");
		} catch (Exception e) {
			System.out.println("[예외]메세지 = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}

}
