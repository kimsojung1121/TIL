<%@page import="xyz.itwill.el.Car"%>
<%@page import="xyz.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Member 클래스로 인스턴스를 생성하여 Request Scope 속성값으로 저장하고 응답 JSP 문서로
포워드 이동하는 JSP 문서 - Model 역활 --%>    
<%
	Member member=new Member("홍길동", new Car("싼타페", "하얀색"));

	//Member 인스턴스를 Request Scope의 속성값으로 저장
	//Request Scope : 속성값을 저장한 웹프로그램과 스레드가 이동된 웹프로그램에서만 속성값을
	//반환받아 사용 가능
	request.setAttribute("member", member);
	
	//포워드 이동 : 현재 웹프로그램의 스레드를 다른 웹프로그램으로 이동하여 실행하는 기능
	// => 스레드가 이동되는 웹프로그램에게 request 인스턴스와 response 인스턴스 전달
	//request.getRequestDispatcher("member_non_el.jsp").forward(request, response);
	request.getRequestDispatcher("member_el.jsp").forward(request, response);
%>