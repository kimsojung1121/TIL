<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 해당 댓글정보를 검색하여 XML 텍스트
데이타로 응답하는 JSP 문서 --%>    
<%
	if(request.getParameter("num")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	int num=Integer.parseInt(request.getParameter("num"));
	
	AjaxCommentDTO ajaxComment=AjaxCommentDAO.getDAO().selectAjaxComment(num);
%>
<result>
	<% if(ajaxComment!=null) {//검색결과가 있는 경우 %>
	<code>success</code>
	<data><![CDATA[
		{"num":<%=ajaxComment.getNum()%>
		,"writer":"<%=Utility.toJSON(ajaxComment.getWriter())%>"
		,"content":"<%=Utility.toJSON(ajaxComment.getContent())%>"
		,"writeDate":"<%=ajaxComment.getWriteDate()%>"}
	]]>
	</data>
	<% } else {//검색결과가 없는 경우 %>
	<code>empty</code>
	<% } %>
</result>
