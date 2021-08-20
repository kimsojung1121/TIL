## Ajax(Asynchronous JavaScript and XML)

#### 개요
- Ajax는 새로운 언어나 기술이 아닌, 현존하는 웹 프로그래밍 관련 기술(HTML, CSS, 자바스크립트, DOM, XML 등)들을 통합하여 대화형 웹 애플리케이션을 개발하는 새로운 개발 방법(패러다임)
- 빠르게 동작하는 동적인 웹 페이지를 만들기 위한 개발 기법의 하나
  > 전통적인 웹 애플리케이션의 경우, 
  > 1. 사용자는 웹 서버로부터 응답을 기다리는 동안 어떠한 작업도 수행할 수 없었으며
  > 2. 웹 서버와의 통신을 위해 페이지 새로고침이 필요했고
  > 3. 즉각적인 피드백을 받지 못하였다.

#### 장점
- 접근이 용이하며, 페이지 이동 없이 고속으로 화면 전환이 가능하다.
- **비동기 통신이 가능하다**
- 웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지의 일부분만 갱신 가능하다.
- 웹 페이지가 로드된 후에 서버로 데이터 요청을 보낼 수 있다.
- 웹 페이지가 로드된 후에 서버로부터 데이터를 받을 수 있다.
- 백그라운드 영역에서 서버로 데이터를 보낼 수 있다.
- 수신 데이터량을 축소할 수 있다.
- 유저인터페이스를 제공한다.
- 다양한 오픈 소스 프레임워크(Prototype, Dojo, jQuery, Google Web Toolkit 등)를 제공한다.

#### 단점
- 브라우저 호환성이 자유롭지 못하다.
- JavaScript는 유지보수 및 디버깅이 어렵다.
- Ajax 스크립트가 포함된 서버가 아닌 다른 서버로 Ajax 요청을 보낼 수 없다.
- 클라이언트의 PC로 Ajax 요청을 보낼 수 없다.


#### 기반 기술
![img](https://github.com/kimsojung1121/TIL/blob/master/Ajax/doc/img/ajax1.png)
- HTTP
  - HTTP(Hyper Text Transfer Protocol)은 웹 브라우저와 웹 서버간의 텍스트 데이터(HTML, XML등)를 송수신 하기 위한 응용 프로토콜
- HTML
  - 웹 브라우저 상에 문자나 이미지 등을 표시하기 위한 고정적인 데이터를 표현하기 위한 마크업 언어(동적인 페이지 작성 불가능)
- XHTML
  - HTML과 동등한 표현능력을 지니는 XML 기반의 독립적인 마크업 언어
  - 엄격한 문법으로 이루어져 있기 때문에 다양한 기기로 웹 페이지에 접근하는 최근 환경에 적합하여 웹 문서 제작의 표준으로 인식
    > Ajax에서는 DOM의 사용이 많이 요구되므로 XHTML이 많이 사용된다.
- DHTML(Dynamic HTML)
  - 정적이고 움직임이 없는 HTML로 구성된 웹 페이지에 동적인 기능을 주기 위한 것 
  - JavaScript, CSS, DOM 등이 사용
- Java Script
  - 웹 페이지의 태그를 동적으로 수정할 수 있도록 하여 웹 브라우저에 좀 더 많은 기능을 제공하기 위한 스크립트 언어
- XMLHttpRequest
  - 웹 브라우저와 웹 서버간 비동기 통신을 위한 JavaScript 객체
- CSS(Cascading Style Sheets)
  - HTML/XHTML 태그 요소의 스타일이나 위치의 정보 등을 정의하기 위한 언어
- DOM(Document Object Model)
  - 문서 객체 모델
  - HTML 문서나 XML 문서에 접근하기 위한 일종의 인터페이스 
  - 마크업  문서의 특정 노드를 객체 단위로 접근하고 조작할 수 있는 일관된 방법 제공
- XSL
  - XML 문서를 XML 또는 HTML 문서로 변환하기 위한 언어
- JSON(JavaScript Object Notation)
  - 구조화된 텍스트 데이터의 교환을 위한 자바스크립트 표현식