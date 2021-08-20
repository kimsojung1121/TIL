<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="org.apache.commons.httpclient.HttpClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 가상의 클라이언트(브라우저)를 이용하여 다른 서버의 웹프로그램을 요청하여 제공받은 
응답결과를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 프록시(Proxy) 기능을 제공하는 웹프로그램 : HttpClient 클래스 사용 --%>
<%-- https://apache.org 사이트에서 필요한 라이브러리 파일을 다운로드 받아 프로젝트에 필드되도록 설정 --%>
<%-- => commons-httpclient-3.1.jar, commons-codec-1.15.jar, commons-logging-1.2.jar --%>    
<%
	//요청 웹프로그램의 URL 주소 저장
	String url="https://www.khan.co.kr/rss/rssdata/kh_entertainment.xml";

	//HttpClient 인스턴스 생성 - 가상의 브라우저 역활을 하기 위한 인스턴스 
	HttpClient client=new HttpClient();
	
	//GetMethod 인스턴스 생성 - 가상의 브라우저를 이용하여 웹프로그램을 요청하기 위한 인스턴스
	// => GetMethod : GET 방식으로 웹프로그램을 요청하기 위한 클래스
	// => PostMethod : POST 방식으로 웹프로그램을 요청하기 위한 클래스
	GetMethod method=new GetMethod(url);
	
	try {
		//HttpClient.executeMethod(Method method) : 가상의 브라우저를 이용하여 웹프로그램을
		//요청하는 메소드 - 요청에 대한 상태코드(StatusCode : int) 반환
		int statusCode=client.executeMethod(method);
		
		//현재 웹프로그램의 응답 관련 인스턴스를 초기화 처리
		out.clearBuffer();
		response.reset();
		
		//현재 웹프로그램의 요청에 대한 상태코드 전달
		response.setStatus(statusCode);
		
		//가상의 브라우저를 이용하여 요청한 웹프로그램의 응답 상태코드가 200(정상적인 응답)인 경우
		if(statusCode==HttpServletResponse.SC_OK) {
			//응답결과를 반환받아 원하는 문자형태(캐릭터셋)로 변환하여 저장
			//Method.getResponseBodyAsString() : 요청에 대한 응답결과를 문자열로 변환하여 반환하는 메소드
			String result=new String(method.getResponseBodyAsString().getBytes("8859_1"),"utf-8");
			
			//현재 웹프로그램의 요청에 대한 응답결과의 문서 종류와 캐릭터셋 전달
			response.setContentType("text/xml;charset=utf-8");
			
			//현재 웹프로그램의 요청에 대한 응답결과 전달
			out.println(result);
		}
	} finally {
		//요청 인스턴스 제거 : 가상의 브라우저를 이용하여 서버에 접속된 정보 제거
		if(method!=null) method.releaseConnection();
	}
%>
