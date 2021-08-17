<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- books.jsp 문서를 AJAX 기능으로 요청하여 실행결과를 XML 텍스트 데이타로 응답받아 HTML
태그로 변환하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => books.xsl 문서를 이용하여 XML 텍스트 데이타를 HTML 태그로 변환 --%>
<%-- => xhr.js 모듈 사용 : 전역변수와 함수를 사용하여 AJAX 기능 제공 --%>

<%-- XSL 문서를 이용한 XML 텍스트 데이타 파싱 방법 --%>
<%-- 1.JSP 문서(XML)와 XSL 문서(XSLT)를 AJAX 요청하여 두 문서의 응답결과를 반환받아 저장 --%>
<%-- 2.XSL 문서의 응답결과(XSLT)를 이용하여 JSP 문서의 응답결과(XML)를 변환(HTML)하여 저장 --%>
<%-- 3.변환된 결과를 이용하여 페이지의 박스모델 변경 - DHTML --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>