<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JSP 내장객체에 따라 저장된 속성값의 사용 범위 구분
	// => 속성값 사용 범위(Scope) : Page Scope, Request Scope, Session Scope, Application Scope
	pageContext.setAttribute("pageName", "홍길동");
	request.setAttribute("requestName", "임꺽정");
	session.setAttribute("sessionName", "전우치");
	application.setAttribute("applicationName", "일지매");
	
	//JSP 내장객체가 다른 경우 같은 속성명을 사용하여 속성값 저장 가능
	// => 동일한 JSP 내장객체에 같은 속성명을 사용하면 기존 속성값 대신 새로운 속성값으로 저장
	pageContext.setAttribute("name", "홍길동");
	request.setAttribute("name", "임꺽정");
	session.setAttribute("name", "전우치");
	application.setAttribute("name", "일지매");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Scope Attribute</h1>
	<hr>
	<h3>Scope 객체에 저장된 속성명이 모두 다른 경우</h3>
	<ul>
		<li>pageName 속성값(Page Scope) = ${pageName }</li>
		<li>requestName 속성값(Request Scope) = ${requestName }</li>
		<li>sessionName 속성값(Session Scope) = ${sessionName }</li>
		<li>applicationName 속성값(Application Scope) = ${applicationName }</li>
	</ul>
	<hr>
	<%-- EL 표현식의 속성명은 속성값을 검색하는 순서 존재 --%>
	<%-- => Page Scope >> Request Scope >> Session Scope >> Application Scope --%>
	<%-- => EL를 사용할 경우 스코프 객체의 속성명을 모두 다르게 선언하는 것을 권장 --%>
	<%-- 
	<h3>Scope 객체에 저장된 속성명이 모두 같은 경우</h3>
	<ul>
		<li>name 속성값(Page Scope) = ${name }</li>
		<li>name 속성값(Request Scope) = ${name }</li>
		<li>name 속성값(Session Scope) = ${name }</li>
		<li>name 속성값(Application Scope) = ${name }</li>
	</ul>
	--%>
	
	<%-- 스코프 객체의 속성명이 같은 경우 EL 표현식에서 EL 내장객체를 이용해 스코프를 구분
	하여 속성값 출력 가능 --%>
	<%-- => Scope Attribute : pageScope, requestScope, sessionScope, applicationScope --%>
	<h3>Scope 객체에 저장된 속성명이 모두 같은 경우</h3>
	<ul>
		<li>name 속성값(Page Scope) = ${pageScope.name }</li>
		<li>name 속성값(Request Scope) = ${requestScope.name }</li>
		<li>name 속성값(Session Scope) = ${sessionScope.name }</li>
		<li>name 속성값(Application Scope) = ${applicationScope.name }</li>
	</ul>
</body>
</html>
