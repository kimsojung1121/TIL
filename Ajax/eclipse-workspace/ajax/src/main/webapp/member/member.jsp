<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/log.js"></script>
</head>
<body>
	<h1>자바스크립트 객체</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	/*
	document.getElementById("log").innerHTML+="메세지 출력-1<br>";
	document.getElementById("log").innerHTML+="메세지 출력-2<br>";
	*/
	
	/*
	function log(message) {
		var logElement=document.getElementById("log");
		if(logElement!=null) {
			logElement.innerHTML+=message+"<br>";
		}
	}
	*/
	
	//log("메세지 출력-1");
	//log("메세지 출력-2");
	
	/*
	var member=new Object();//Object 객체 생성 >> var member={};
	member.id="abc123";//속성 추가
	member.name="홍길동";
	
	//log("아이디 = "+member.id+", 이름 = "+member.name);
	
	member.display=function() {//메소드 추가
		log("아이디 = "+this.id+", 이름 = "+this.name);
	}
	
	member.display();
	*/
	
	//클래스 함수(객체를 생성하기 위한 함수) 선언
	function Member(id, name) {
		this.id=id;
		this.name=name;
	}
	
	Member.prototype.display=function() {
		log("아이디 = "+this.id+", 이름 = "+this.name);
	}
	
	//new 연산자로 클래스 함수를 호출하여 객체 생성
	var member=new Member("abc123", "홍길동");
	//log("아이디 = "+member.id+", 이름 = "+member.name);
	member.display();
	</script>
</body>
</html>













