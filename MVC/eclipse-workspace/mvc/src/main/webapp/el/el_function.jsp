<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="elfun" uri="http://www.itwill.xyz/mvc/el"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL Function</h1>
	<hr>
	<p>${elfun:hello("홍길동") }</p>
	<p>${elfun:hello("임꺽정") }</p>
</body>
</html>