<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 삭제하고 회원목록
출력페이지(user_list.jsp)로 이동하는 JSP 문서 --%>
<%-- => 관리자가 자신을 삭제 처리한 경우 로그아웃 처리페이지(user_logout_action.jsp)로 이동 --%>    
<%-- => 관리자만 요청 가능 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	//비로그인 사용자이거나 로그인 사용자가 관리자가 아닌 경우
	if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoModelOneDAO.getDAO().deleteUserinfo(userid);
	
	if(loginUserinfo.getUserid().equals(userid)) {//로그인 사용자와 삭제 사용자가 같은 경우
		response.sendRedirect("user_logout_action.jsp");
	} else {
		response.sendRedirect("user_list.jsp");
	}
%>