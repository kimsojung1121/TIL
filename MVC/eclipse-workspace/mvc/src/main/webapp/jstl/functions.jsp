<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- Functions 태그 라이브러리를 JSP 문서에 포함 - prefix 속성값은 "fn"로 설정 --%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Functions - EL 함수</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678"/>
	<p>전화번호 = ${phone }</p>
	<hr>
	<%-- split 함수 : 문자열을 원하는 문자로 구분 분리하여 배열로 반환하는 함수 --%>
	<c:set var="array" value="${fn:split(phone,'-') }"/>
	<c:forEach var="num" items="${array }">
		<div>${num }</div>
	</c:forEach>
	<hr>
	<%-- substring 함수 : 문자열을 시작첨자와 종료첨자로 분리하여 반환하는 함수 --%>
	<div>${fn:substring(phone,0,3) }</div>
	<div>${fn:substring(phone,4,8) }</div>
	<div>${fn:substring(phone,9,13) }</div>
	<hr>
	<c:set var="content" value="안녕하세요.\n반갑습니다."/>
	<div>${content}</div>
	<%-- replace 함수 : 문자열에서 원하는 문자열을 검색하여 다른 문자열로 변환하여 반환하는 함수 --%>
	<div>${fn:replace(content,'\\n','<br>') }</div>
	<hr>
	<c:set var="html" value="<font size='7' color='red'>안녕하세요.</font>"/>
	<%-- HTML 태그가 포함된 문자열을 EL를 이용하여 출력할 경우 HTML 태그로 적용되어 출력 --%>
	<div>${html }</div>
	<%-- out 태그를 사용하여 출력할 경우 HTML 태그를 포함하여 모두 문자열로 출력 --%>
	<div><c:out value="${html }"/></div>
	<%-- escapeXml 함수 : 스코프 객체로 저장된 속성값을 문자열로 변환하여 반환하는 태그  --%>
	<%-- => HTML 태그를 포함하여 모두 문자열로 출력 --%>
	<div>${fn:escapeXml(html) }</div>
</body>
</html>







