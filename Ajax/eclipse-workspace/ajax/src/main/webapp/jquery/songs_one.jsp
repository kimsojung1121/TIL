<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- songs_two.jsp 문서를 AJAX 기능으로 요청하여 응답결과(JSON)를 제공받아 박스모델을
변경하여 클라이언트에게 전달하는 JSP 문서 --%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>jQuery AJAX</h1>
	<hr>
	<h2>음원챠트(<span id="now"></span> 현재 기준)</h2>
	<div id="songList"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		url: "songs_two.jsp",
		dataType: "json",
		success: function(data) {
			//alert(data);//[object Object]
			
			$("#now").html(data.now);
			
			var html="<ol>";
			$(data.songs).each(function() {
				html+="<li><b>"+this.title+"</b> - "+this.singer+"</li>";
			});
			html+="</ol>";
			
			$("#songList").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>
</body>
</html>