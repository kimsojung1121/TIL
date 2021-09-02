package xyz.itwill.dto;

/*
MYUSER 테이블 : 회원정보를 저장하기 위한 테이블
// => 아이디(USER_ID), 이름(USER_NAME)
create table myuser(user_id varchar2(20) primary key, user_name varchar2(30)); 

SQL 명령은 대소문자를 구분하지 않아 식별자를 선언할 때 스네이크 표기법(Snake Case) 이용 
 => 스네이크 표기법 : _ 기호를 사용하여 단어와 단어를 구분하여 표현
 
이름        널?       유형           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(20) 
USER_NAME          VARCHAR2(30)   
*/

//Java 자료형(Class, Interface, Enum)은 파스칼 표기법(Pascal Case) 이용
// => 파스칼 표기법 : 식별자를 구성하는 모든 단어의 첫문자를 대문자로 표현
public class MyUser {
	//자바는 대소문자를 구분하므로 Java 식별자를 선언할 때 카멜 표기법(Camel Case) 이용
	// => 카멜 표기법 : 식별자를 구성하는 단어 중 첫번째 단어를 제외한 나머지 단어의 첫문자를 대문자로 표현
	private String userId;
	private String userName;
	
	public MyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
