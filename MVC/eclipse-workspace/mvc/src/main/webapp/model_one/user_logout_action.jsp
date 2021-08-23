<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리하고 로그인정보 입력페이지(user_login.jsp)로 이동하는 JSP 문서 --%>
<%-- => 로그아웃 처리 : 세션에 저장된 권한 관련 정보 제거 --%>
<%
	//session.removeAttribute("loginUserinfo");
	session.invalidate();
	
	response.sendRedirect("user_login.jsp");
%>    
