<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- HTML의 meta 태그를 이용하여 브라우저 캐싱기능 무효화 처리 --%>
<meta http-equiv="Expires" content="-1"><%-- 캐싱 만료 기간 설정 --%>
<meta http-equiv="Pragma" content="no-cache"><%-- 캐싱 기능 미사용 설정(HTTP/1.0) --%>
<meta http-equiv="Cache-control" content="no-cache"><%-- 캐싱 기능 미사용 설정(HTTP/1.1) --%>
<title>AJAX</title>
<script type="text/javascript" src="js/xhr.js"></script>
<style type="text/css">
div {
	font-size: 20px;
	margin: 10px;
}
</style>
</head>
<body>
	<h1>브라우저 캐싱</h1>
	<hr>
	<div>현재 클라이언트 시스템의 날짜와 시간은 <span id="clientTime">2021년 08월 13일
	17시 00분 10초</span>입니다.</div>
	<div>현재 서버 시스템의 날짜와 시간은 <span id="serverTime">2021년 08월 13일
	17시 00분 10초</span>입니다.</div>
	
	<script type="text/javascript">
	//브라우저가 실행되는 클라이언트 시스템의 날짜와 시간을 제공받아 박스모델을 변경하는 함수
	// => 클라이언트에 따라 다른 결과 제공 가능
	function displayClientTime() {
		var now=new Date();
		var displayTime=now.getFullYear()+"년 "+(now.getMonth()+1)+"월 "+now.getDate()+"일 "
			+now.getHours()+"시 "+now.getMinutes()+"분 "+now.getSeconds()+"초";
		document.getElementById("clientTime").innerHTML=displayTime;
	}
	
	displayClientTime();
	setInterval(displayClientTime, 1000);
	
	//서버 시스템의 날짜와 시간을 제공받아 박스모델을 변경하는 함수 - AJAX 이용
	// => 서버 시스템의 날짜와 시간정보를 제공받아 사용하므로 모든 클라이언트에게 동일한 결과 제공
	//문제점)동일한 웹프로그램을 지속적으로 요청할 경우 브라우저 캐싱 기능에 의해 서버의 응답
	//결과가 아닌 기존 응답결과를 재사용 - 최초 응답결과를 계속 사용
	//해결법-1)웹프로그램의 URL 주소를 지속적으로 변경하여 요청 - QueryString 이용
	//해결법-2)현재 페이지에 대한 브라우저 캐싱 기능을 무효화 처리 - HTML(디자이너)
	//해결법-3)요청 웹프로그램에서 응답결과에 대한 브라우저 캐싱 기능을 무효화 처리 - Java(프로그램머)
	function displayServerTime() {
		sendRequest("GET", "clock_two.jsp", null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}				
		});
	}
	
	/*
	function displayServerTime() {
		sendRequest("GET", "clock_two.jsp?dummy="+new Date().getTime(), null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}				
		});
	}
	*/
	
	displayServerTime();
	setInterval(displayServerTime,1000);
	</script>
</body>
</html>












