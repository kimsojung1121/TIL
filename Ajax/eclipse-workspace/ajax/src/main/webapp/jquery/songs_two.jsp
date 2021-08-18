<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 음원목록을 JSON 형식의 텍스트 데이타로 응답하는 JSP 문서 --%>
<%
	String now=new SimpleDateFormat("yyyy년 MM월 dd일 HH시").format(new Date());
%>
{"now":"<%=now%>","songs":[{"title":"신호등","singer":"이무진"}
,{"title":"바라만 본다","singer":"MSG워너비(M.O.M)"},{"title":"낙하(with 아이유)","singer":"AKMU(악뮤)"}
,{"title":"Next Level","singer":"aespa"},{"title":"Permission to Dance","singer":"방탄소년단"}]}