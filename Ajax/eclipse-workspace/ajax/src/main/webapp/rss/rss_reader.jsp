<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- RSS 서비스를 제공하는 웹프로그램을 AJAX 기능으로 요청하여 응답결과를 제공받아 
클라이언트에게 전달하는 JSP 문서 --%>
<%-- RSS(Really Simple Syndication 또는 Rich Site Summary) : 실시간으로 변경되는 정보를
제공하기 위한 웹프로그램의 종류 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>RSS Reader</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		//url: "https://www.khan.co.kr/rss/rssdata/kh_entertainment.xml",
		url: "rss_proxy.jsp",
		dataType: "xml",
		success: function(xml) {
			var channelTitle=$(xml).find("channel").children("title").text();
			
			var html="<h2>"+channelTitle+"</h2>";
			html+="<ul>";
			$(xml).find("item").each(function() {
				var title=$(this).find("title").text();
				var link=$(this).find("link").text();
				var date;
				if($(this).find("pubDate").length!=0) {
					date=$(this).find("pubDate").text();
				} else {
					date=$(this).find("dc\\:date").text();
				}
				html+="<li><a href='"+link+"'>"+title+"["+date+"]</a></li>";
			});
			html+="</ul>";
			
			$("#display").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>
</body>
</html>