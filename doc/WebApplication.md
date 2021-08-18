### Web Application 개발을 위한 프로그램 설치 및 환경설정

---

1. Download
    - JDK 설치 및 환경설정
    - [JDK 다운로드](https://www.oracle.com)
    - DBMS 설치
    - [Eclipse 설치](https://www.eclipse.org)
    - WAS(Web Application Server) 설치 : [Apache Tomcat](https://tomcat.apache.org)

#

2. 이클립스에서 사용될 수 있도록 WAS 추가 작업
    - JavaEE로 Perspective 변경
    - Servers View에서 WAS 추가 : Apache Tomcat 등록
    - 등록된 WAS 환경설정
      - Server 위치 변경 : Apache Tomcat 프로그램 설치 위치(Deploy Path 변경)
      - PORT 변경 : HTTP/1.1(8080 > 8000)
    - 클라이언트의 요청과 응답처리을 위해 WAS를 실행상태로 변경


#


3. Web Application 개발
    - Dynamic Web Project 생성
      - 프로젝트명은 웹에서 컨테스트명(ContextName)과 동일
      - 프로젝트의 프로그램을 실행하기 위한 WAS 선택    
      - web.xml 생성 : 프로젝트의 WAS 실행환경 설정
    - Project 파일(Java Resource, WebContent)
      - Java Resource : Java 소스파일(Servlet 또는 JavaBean - DTO, DAO)
      - WebContent : CSL(HTML, CSS, JavaScript) 파일 또는 JSP 파일 
      > WebContent에 작성되는 파일은 캐릭터셋 변경 후 생성(Encoding : UTF-8)
    - 웹어플리이션 실행 : URL 주소를 이용한 서버 자원을 WAS에게 요청 
      - URL 주소 : http://ServerName:Port/Context/WebFilePath


#

- 브라우저는 크롬(Chrome) 사용 (Window > Web Browser : Chrome)
