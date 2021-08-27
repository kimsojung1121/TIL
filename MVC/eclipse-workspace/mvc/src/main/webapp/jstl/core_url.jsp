<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - URL 관리 태그</h1>
	<hr>
	<%-- 서버에 저장된 리소스 파일(CSS 파일, JS 파일, 멀티미디어 파일 등)을 상대경로로 표현하여 제공 --%>
	<%-- 상대경로 : 현재 요청 웹프로그램의 경로를 기존으로 리소스 위치 표현 --%>
	<%-- => 요청 웹프로그램(Controller)과 응답 웹프로그램(View)의 경로가 다른 경우 404 에러코드 발생 --%>
	<img src="images/Koala.jpg" width="200">
	
	<%-- 리소스 파일은 절대경로로 표현하여 제공하는 것을 권장 --%>
	<%-- 절대경로 : 루트 디렉토리(서버 디렉토리)를 기준으로 리소스 위치 표현  --%>
	<img src="http://localhost:8000/mvc/jstl/images/Koala.jpg" width="200">
	<%-- 웹프로그램과 동일한 서버에 존재하는 리소스 파일인 경우 접속 서버 생략 가능 --%>
	<%-- => 컨텍스트 이름이 변경될 경우 리소스 파일의 절대경로가 변경되어 404 에러코드 발생 --%>
	<img src="/mvc/jstl/images/Koala.jpg" width="200">

	<%-- request.getContextPath() 메소드를 호출하여 컨텍스트 경로를 반환받아 리소스 파일을 절대경로로 표현 --%>
	<img src="<%=request.getContextPath() %>/jstl/images/Koala.jpg" width="200">
	
	<%-- EL 표현식에서 pageContext 내장객체를 이용하여 컨텍스트 경로를 제공받아 리소스 파일을 절대경로로 표현 --%>
	<img src="${pageContext.request.contextPath }/jstl/images/Koala.jpg" width="200">

	<%-- url 태그 : 컨텍스트 경로가 포함된 리소스 파일의 절대경로를 제공하는 태그 --%>
	<%-- value 속성 : 컨텍스트 경로를 제외한 리소스 파일의 절대경로를 속성값으로 설정 --%>
	<img src="<c:url value="/jstl/images/Koala.jpg"/>" width="200">
</body>
</html>










