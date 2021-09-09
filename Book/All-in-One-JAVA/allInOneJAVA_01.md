## 제 1부. 애플리케이션 아키텍처와 프레임워크
- Spring 프레임워크를 기반으로 하는 애플리케이션 아키텍처의 구성과 Spring 프레임워크의 본질에 대해 논의한다.


### 1. Java 웹 애플리케이션 개요
#### 1.1 Java EE 애플리케이션 플랫폼

- Java 웹 애플리케이션은 Java EE(Enterprise Edition) 플랫폼 상에서 구현된다.
- Java EE 플랫폼은 엔터프라이즈 애플리케이션 중에서도 웹 애플리케이션과 관련된 기술의 표준 사양을 정의한다.
- Java EE 애플리케이션 서버는 컨테이너 모델을 제공한다. 컨테이너는 컴포넌트가 실행되는 환경을 말하며, **트랜잭션 관리, 보안, 상태 관리, 프로세스와 스레드, 시스템 리소스 관리, 데이터베이스 연결 풀링 및 캐싱** 등과 같이 대규모 엔터프라이즈 환경에서 요구되는 필수적인 서비스를 제공한다.
- 코드를 작성하지 않고 지시 사항만 컨테이너에 알려주면 되는 서술적 프로그래밍 모델이다.
- Java EE 애플리케이션 서버는 웹 컨테이너와 EJB 컨테이너로 구성되고, 클라이언트 시스템은 애플리케이션 클라이언트 컨테이너로 구성된다.
  - 이 중에서 웹 어플리케이션과 관련된 것은 웹 컨테이너이다. (서블릿과 JSP 등의 API 포함)
  - EJB 컨테이너는 엔터프라이즈 빈을 관리하고 구현하는 데 사용되는 API가 포함된다. 프로그래밍이 무겁고 성능이 떨어져 현재는 대부분 Spring 프레임워크로 대신한다.
  - Java EE API 중에서 EJB 컨테이너를 제외한 웹 컨테이너의 API만 구현한 서버 제품이 별도로 나와 있으며, 웹 컨테이너라고 한다.
  - 대표적인 웹 컨테이너로는 Tomcat이 있다.
  > 사실상 WAS는 EJB 컨테이너까지 포함하는 Java EE 애플리케이션 서버지만, 이것을 사용할 때도 웹 컨테이너의 기능만 사용하기 때문에 그냥 WAS라고 부른다.
- Java EE 플랫폼에서 웹 컴포넌트는 서블릿, JSP, JSF로 구현된 웹 페이지로 구현될 수 있다.
- **우리나라 실무 프로젝트 환경에서는 JSF보다 JSP를 선호하는 경향이 있다. JSP와 함께 Spring MVC 프레임워크를 많이 사용한다. JSF와 Spring MVC는 중복되는 기능 영역이 있어 함께 사용하는 것이 그다지 바람직하지는 않다.**
> **웹 클라이언트가 웹 서버에 HTTP request를 보내면, 서블릿을 구현한 웹 서버는 HttpServletRequest 객체로 변환한다. 이 객체는 웹 컴포넌트로 전달되어 JavaBeans 컴포넌트나 데이터베이스와 상호작용하여
> 동적인 콘텐츠를 생성한다. 웹 컴포넌트는 HttpServletResponse 객체를 생성하고, 웹 서버는 이 객체를 Http response로 변환하여 웹 클라이언트에 전달한다.**
- 웹 컨테이너는 웹 컴포넌트에 요청 가져다주기, 보안, 동시성 등의 서비스를 제공하며 네이밍, 트랜잭션, 전자우편과 같은 API를 제공하여 웹 컴포넌트가 사용할 수 있게 한다.
- 데이터베이스의 데이터에 접근하는 기본적인 자바 기술은 JDBC이다. SQL을 사용하여 DB에 질의하고 데이터를 조작하는 API를 제공한다.
- Java EE 애플리케이션 서버에서는 JPA를 표준 퍼시스턴스 솔루션으로 정의하고 있다.
> Java Persistence API : 프로그램의 실행이 끝나거나 컴퓨터가 종료되어도 상태가 지속되는 것을 말하며, 일반적으로 데이터베이스에 데이터를 저장하는 것을 의미한다.

---

#### 1.2 웹 애플리케이션 아키텍처
- 웹 애플리케이션 아키텍처의 개념은 [ELUWING님의 게시글](https://nitro04.blogspot.com/2020/01/web-web-application-architecture.html)을 참고했다.
- 웹 애플리케이션의 가장 간단한 유형은 홈페이지이다. 웹 브라우저를 통해 웹 서버에 접속하면 웹 서버는 정적인 HTML 웹 페이지를 보여준다. 회원 등록이나 게시판 같은 동적인 웹 페이지는 DB에 접속하여 데이터를 입출력한다. 이러한 유형의 웹 애플리케이션은 웹 서버로 오픈 소스 Apache HTTP Server를 사용할 수 있다.
- 데이터베이스 액세스에는 JDBC가 사용된다. 이 책에서는 데이터베이스 오픈소스로 MySQL을 사용한다.
- 소규모 동적 기능을 포함하는 웹 애플리케이션은 웹 서버 대신 웹 애플리케이션 서버가 사용될 수 있다.
- 이 책에서는 동적인 기능을 제공하는 웹 애플리케이션 서버로 오픈소스 웹 컨테이너인 Apache Tomcat Server를 사용한다. (Java EE 애플리케이션 서버의 EJB 컨테이너는 사용하지 않는다.)
- Model 1 방식
  - JSP와 JDBC만을 사용하여 웹 애플리케이션을 개발하는 방식이다.
  - 보편적으로 많이 사용하며, 배우기 쉽고 빠르게 적응 가능하다.
  - 그러나 JSP에 프레젠테이션 로직과 비즈니스 로직이 혼합되어 있어 복잡해진다. Java Bean에 비즈니스 로직을 구현할 수도 있지만, JSP와 자바 빈 사이의 결합성 때문에 JSP가 복잡해지는 것은 피할 수 없다. 따라서 개발자와 웹 디자이너의 작업 분리가 어려우며, 유지보수가 어려워진다.
- Model 2 방식
  - MVC 패턴을 웹 개발에 적용해 구현하는 방식이다. 
  - 모델은 데이터를 관리하고, 뷰는 모델의 정보를 웹에 표시하고 사용자로부터 정보를 입력받는다. 컨트롤러는 비즈니스 로직을 구현하고 모델과 뷰를 통제한다.<br>
  ![](https://github.com/kimsojung1121/TIL/blob/master/Book/All-in-One-JAVA/img/model2.jpg)
  > 위 그림에서 JavaBean이 모델, JSP가 뷰, 서블릿이 컨트롤러의 역할을 한다.
  - Spring MVC는 이러한 모델 2 방식을 지원하는 프레임워크이다.
- 규모가 큰 웹 애플리케이션이라면 서버를 웹 서버와 애플리케이션 서버로 분리하는 것이 좋다. 웹 서버에서는 정적인 웹 페이지 처리를 전담하고, 동적인 웹 페이지는 애플리케이션 서버가 담당한다.
- 업무 로직이 복잡하거나 다른 조직의 애플리케이션 시스템과 연동해야 된다면 프레젠테이션 로직 담당 서버, 비즈니스 로직과 데이터 엑세스 및 외부 시스템과의 연동 로직을 담당하는 서버로 분리하는 것이 좋다.

---

### 1.3 주문관리 예제 시스템