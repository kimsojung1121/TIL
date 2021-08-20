<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX_COMMENT 테이블의 댓글정보에 대한 저장,삭제,변경 기능을 제공하고 댓글 목록을 검색하여
클라이언트에게 전달하는 JSP 문서 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

.comment_table {
	width: 500px;
	margin: 0 auto;
	border: 2px solid #cccccc;
	border-collapse: collapse;
}

.title {
	width: 100px;
	padding: 5px 10px;
	text-align: center;
	border: 1px solid #cccccc;
}

.input {
	width: 400px;
	padding: 5px 10px;
	border: 1px solid #cccccc;
}

.btn {
	text-align: center;
	border: 1px solid #cccccc;
}

#comment_add {
	margin-bottom: 5px;
}

#comment_modify, #comment_remove {
	margin: 10px;
	display: none;	
}

#add_message, #modify_message {
	width: 500px;
	margin: 0 auto;
	margin-bottom: 20px;
	text-align: center;
	color: red;
}

#remove_message {
	padding: 3px;
	text-align: center;
	border: 1px solid #cccccc;
}

.comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	padding: 3px;
	border: 1px solid #cccccc;
}

.no_comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	border: 2px solid #cccccc;
	text-align: center;
}
</style>
</head>
<body>
	<h1>AJAX 댓글</h1>
	<hr>
	<%-- 댓글 등록 영역 --%>
	<div id="comment_add">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input"><input type="text" id="add_writer"></td> 
			</tr>
			<tr>
				<td class="title">댓글내용</td>
				<td class="input"><textarea rows="3" cols="50" id="add_content"></textarea></td> 
			</tr>
			<tr>
				<td class="btn" colspan="2">
					<button type="button" id="add_btn">댓글등록</button>
				</td>
			</tr>
		</table>
		<div id="add_message">&nbsp;</div>
	</div>
	
	<%-- 댓글목록 출력 영역 --%>
	<div id="comment_list"></div>
	
	<%-- 댓글 변경 영역 --%>
	<div id="comment_modify">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input"><input type="text" id="modify_writer"></td> 
			</tr>
			<tr>
				<td class="title">댓글내용</td>
				<td class="input"><textarea rows="3" cols="50" id="modify_content"></textarea></td> 
			</tr>
			<tr>
				<td class="btn" colspan="2">
					<button type="button" id="modify_btn">변경</button>
					<button type="button" id="modify_cancel_btn">취소</button>
				</td>
			</tr>
		</table>
		<div id="modify_message">&nbsp;</div>
	</div>
	
	<%-- 댓글 삭제 영역 --%>
	<div id="comment_remove">
		<div id="remove_message">
			<b>정말로 삭제 하시겠습니까?</b>
			<button type="button" id="remove_btn">삭제</button>
			<button type="button" id="remove_cancel_btn">취소</button>
		</div>
	</div>
	
	<script type="text/javascript">
	//댓글목록을 제공하는 웹프로그램(comment_list.jsp)을 AJAX 기능으로 요청하여 응답결과를
	//제공받아 출력하는 함수
	function loadComment() {
		$.ajax({
			type: "get",
			url: "comment_list.jsp",
			dataType: "xml",
			success: function(xml) {
				var code=$(xml).find("code").text();
				
				//댓글목록 출력영역 초기화 - 기존 댓글목록 삭제
				$("#comment_list").children().remove();
				
				if(code=="success") {
					//data 엘리먼트의 값(JSON 형식의 텍스트 데이타)을 자바스크립트 객체로 변환하여 저장
					var commentArray=JSON.parse($(xml).find("data").text());
					
					$(commentArray).each(function() {
						var html="<div class='comment' id='comment_"+this.num+"' num='"+this.num+"'>";
						html+="<b>["+this.writer+"]</b><br>";//댓글 작성자
						html+=this.content.replace(/\n/g,"<br>")+"<br>";//댓글 내용
						html+="("+this.writeDate+")<br>";//댓글 작성일
						html+="<button type='button' onclick='modifyComment("+this.num+");'>댓글변경</button>&nbsp;";//변경 버튼
						html+="<button type='button' onclick='removeComment("+this.num+");'>댓글삭제</button>";//삭제 버튼
						html+="</div>";
						
						$("#comment_list").append(html);//댓글목록에 댓글을 추가하여 출력
					});
				} else {
					var message=$(xml).find("message").text();
					$("#comment_list").html("<div class='no_comment'>"+message+"</div>");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//댓글목록을 출력하는 함수 호출
	loadComment();
	
	//[댓글등록]을 클릭한 경우 호출될 이벤트 처리 함수를 등록
	// => 입력값을 전달받아 댓글로 저장하는 웹프로그램(comment_add.jsp)을 AJAX 기능으로 
	//요청하여 응답결과를 제공받아 처리
	$("#add_btn").click(function() {
		//입력태그의 입력값을 제공받아 저장
		var writer=$("#add_writer").val();
		if(writer=="") {
			$("#add_message").html("작성자를 입력해 주세요.");
			$("#add_writer").focus();
			return;
		}
		
		var content=$("#add_content").val();
		if(content=="") {
			$("#add_message").html("댓글내용을 입력해 주세요.");
			$("#add_content").focus();
			return;
		}
		
		$("#add_writer").val("");
		$("#add_content").val("");
		$("#add_message").html("&nbsp;");
		
		$.ajax({
			type: "post",
			url: "comment_add.jsp",
			data: {"writer":writer, "content":content},
			dataType: "xml",
			success: function(xml) {
				var code=$(xml).find("code").text();
				
				if(code=="success") {
					loadComment();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	
	//댓글 변경 영역과 댓글 삭제 영역을 초기화 처리하는 함수
	function init() {
		$("#modify_writer").val("");
		$("#modify_content").val("");
		$("#modify_message").html("&nbsp;");
		
		$("#comment_modify").hide().appendTo(document.documentElement);
		$("#comment_remove").hide().appendTo(document.documentElement);
	}
	
	//댓글의 [댓글변경]을 클릭한 경우 호출되는 이벤트 처리 함수
	// => 변경하고자 하는 댓글정보를 검색하는 웹프로그램(comment_get.jsp)을 AJAX 기능으로 
	//요청하여 응답결과를 제공받아 처리
	function modifyComment(num) {
		//alert(num);
		
		init();
		
		//댓글 변경 영역을 보여주고 변경될 댓글의 자식 엘리먼트로 이동 처리
		$("#comment_modify").show().appendTo("#comment_"+num);
		
		$.ajax({
			type: "get",
			url: "comment_get.jsp",
			data: {"num":num},
			dataType: "xml",
			success: function(xml) {
				var code=$(xml).find("code").text();
				
				if(code=="success") {
					var comment=JSON.parse($(xml).find("data").text());
					$("#modify_writer").val(comment.writer);
					$("#modify_content").val(comment.content);
				} else {
					//댓글 변경 영역을 숨기고 document 객체의 마지막 자식 엘리먼트로 이동 처리
					//$("#comment_modify").hide().appendTo(document.documentElement);
					
					init();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//댓글 변경 영역에서 [변경]을 클릭한 경우 호출될 이벤트 처리 함수 등록
	// => 댓글번호와 입력태그의 입력값을 전달받아 댓글정보를 변경하는 웹프로그램(comment_modify.jsp)을
	//AJAX 기능으로 요청하고 응답결과를 제공받아 처리
	$("#modify_btn").click(function() {
		//댓글 출력 영역(div 태그)에서 댓글번호(num 속성값)를 제공받아 저장 
		var num=$("#comment_modify").parent().attr("num");
		//alert("num = "+num);
		
		//입력태그의 입력값을 제공받아 저장
		var writer=$("#modify_writer").val();
		if(writer=="") {
			$("#modify_message").html("작성자를 입력해 주세요.");
			$("#modify_writer").focus();
			return;
		}
		
		var content=$("#modify_content").val();
		if(content=="") {
			$("#modify_message").html("댓글내용을 입력해 주세요.");
			$("#modify_content").focus();
			return;
		}

		$.ajax({
			type: "post",
			url: "comment_modify.jsp",
			data: {"num":num, "writer":writer, "content":content},
			dataType: "xml",
			success: function(xml) {
				var code=$(xml).find("code").text();
				
				if(code=="success") {
					init();
					loadComment();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	
	//댓글 변경 영역에서 [취소]을 클릭한 경우 호출될 이벤트 처리 함수 등록
	$("#modify_cancel_btn").click(init);
	
	//댓글의 [댓글삭제]를 클릭한 경우 호출되는 이벤트 처리 함수
	function removeComment(num) {
		init();

		//댓글 삭제 영역을 보여주고 삭제될 댓글의 자식 엘리먼트로 이동 처리
		$("#comment_remove").show().appendTo("#comment_"+num);
	}
	
	//댓글 삭제 영역에서 [삭제]을 클릭한 경우 호출될 이벤트 처리 함수 등록
	// => 댓글번호를 전달받아 댓글정보를 삭제하는 웹프로그램(comment_remove.jsp)을
	//AJAX 기능으로 요청하고 응답결과를 제공받아 처리
	$("#remove_btn").click(function() {
		var num=$("#comment_remove").parent().attr("num");
		//alert("num = "+num);
		
		$.ajax({
			type: "get",
			url: "comment_remove.jsp",
			data: {"num":num},
			dataType: "xml",
			success: function(xml) {
				var code=$(xml).find("code").text();
				
				if(code=="success") {
					init();
					loadComment();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	
	//댓글 삭제 영역에서 [취소]을 클릭한 경우 호출될 이벤트 처리 함수 등록
	$("#remove_cancel_btn").click(init);
	</script>
</body>
</html>