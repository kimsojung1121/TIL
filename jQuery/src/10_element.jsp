<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>태그(Element 객체) 추가(삽입)과 삭제</h1>
	<hr>
	<div id="imageList1"></div>
	<hr>
	<div id="imageList2"></div>
	<hr>
	<div id="imageList3">
		<img src="images/1.jpg" width="100" height="100" id="image1">
		<img src="images/2.jpg" width="100" height="100" id="image2">
		<img src="images/3.jpg" width="100" height="100" id="image3">
	</div>
	
	<script type="text/javascript">
	//$변수명 : jQuery 객체를 저장하는 변수 - jQuery 메소드 호출
	//$(html) : HTML 태그를 이용하여 jQuery 객체 생성 - 엘리먼트 생성
	var $image=$("<img src='images/1.jpg' width='100' height='100'>");
	
	//$(selector).appendTo(targetSelector) : 검색 엘리먼트를 타겟 엘리먼트의 마지막 자식
	//엘리먼트로 추가(이동)하는 메소드
	// => 검색 엘리먼트가 없는 경우 엘리먼트를 생성하여 추가하고 검색 엘리먼트가 있는 경우 이동 처리
	$image.appendTo("#imageList1");
	$("<img src='images/2.jpg' width='100' height='100'>").appendTo("#imageList1");

	//$(selector).prependTo(targetSelector) : 검색 엘리먼트를 타겟 엘리먼트의 첫번째 자식
	//엘리먼트로 추가(이동)하는 메소드
	// => 검색 엘리먼트가 없는 경우 엘리먼트를 생성하여 추가하고 검색 엘리먼트가 있는 경우 이동 처리
	$("<img src='images/3.jpg' width='100' height='100'>").prependTo("#imageList1");
	$("<img src='images/4.jpg' width='100' height='100'>").prependTo("#imageList1");

	//$(selector).insertBefore(targetSelector) : 검색 엘리먼트를 타겟 엘리먼트 앞의 
	//엘리먼트로 삽입(이동)하는 메소드
	// => 검색 엘리먼트가 없는 경우 엘리먼트를 생성하여 삽입하고 검색 엘리먼트가 있는 경우 이동 처리
	$("<img src='images/5.jpg' width='100' height='100'>").insertBefore("#imageList1 img[src='images/1.jpg']");

	//$(selector).insertAfter(targetSelector) : 검색 엘리먼트를 타겟 엘리먼트 뒤의 
	//엘리먼트로 삽입(이동)하는 메소드
	// => 검색 엘리먼트가 없는 경우 엘리먼트를 생성하여 삽입하고 검색 엘리먼트가 있는 경우 이동 처리
	$("<img src='images/6.jpg' width='100' height='100'>").insertAfter("#imageList1 img[src='images/1.jpg']");
	
	//$(targetSelector).append(newElement) : 타겟 엘리먼트를 검색하여 마지막 자식 엘리먼트로
	//새로운 엘리먼트를 추가하는 메소드
	$("#imageList2").append("<img src='images/1.jpg' width='100' height='100'>");
	$("#imageList2").append("<img src='images/2.jpg' width='100' height='100'>");
	
	//$(targetSelector).prepend(newElement) : 타겟 엘리먼트를 검색하여 첫번째 자식 엘리먼트로
	//새로운 엘리먼트를 추가하는 메소드
	$("#imageList2").prepend("<img src='images/3.jpg' width='100' height='100'>");
	$("#imageList2").prepend("<img src='images/4.jpg' width='100' height='100'>");
	
	//$(targetSelector).before(newElement) : 타겟 엘리먼트를 검색하여 타겟 엘리먼트 앞에
	//새로운 엘리먼트를 삽입하는 메소드
	$("#imageList2 img[src='images/1.jpg']").before("<img src='images/5.jpg' width='100' height='100'>");

	//$(targetSelector).after(newElement) : 타겟 엘리먼트를 검색하여 타겟 엘리먼트 뒤에
	//새로운 엘리먼트를 삽입하는 메소드
	$("#imageList2 img[src='images/1.jpg']").after("<img src='images/6.jpg' width='100' height='100'>");
	
	//$(seletor).remove([selector]) : 검색 엘리먼트를 삭제하는 메소드
	// => 부모 엘리먼트를 삭제하면 모든 후손 엘리먼트 삭제
	// => remove 메소드의 매개변수에 선택자를 전달하여 특정 엘리먼트만 선택하여 삭제 가능
	//$("#imageList3").remove();
	
	//부모 엘리먼트의 특정 자식 엘리먼트만 선택하여 삭제 가능
	//$("#imageList3").children().eq(0).remove();
	//$("#imageList3").children(":eq(1)").remove();
	//$("#imageList3").children().remove(":eq(2)");
	
	//아이디 선택자를 이용하여 엘리먼트 삭제
	//$("#image1").remove();
	//$("#image2").remove();
	$("#image3").remove();
	</script>
</body>
</html>












