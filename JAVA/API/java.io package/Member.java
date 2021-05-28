package xyz.itwill.io;

import java.io.Serializable;

//회원정보(아이디, 이름, 전화번호)를 저장하기 위한 클래스
// => 객체 단위로 입력 또는 출력 처리되는 클래스는 반드시 객체 직렬화 클래스로 선언
//객체 직렬화(Object Serialization) : 인스턴스를 byte 배열(원시 데이타 모임)로 변환하여 입력 또는 출력하는 기능을 제공

//객체 직렬화 클래스로 선언하는 방법
//1. java.io.Serializable 인터페이스를 상속받아 선언
// => 인스턴스의 모든 필드값을 byte 배열로 변환하여 입력 또는 출력하는 기능 제공
//2. java.io.Externalizable 인터페이스를 상속받아 선언
// => 인터페이스의 추상 메소드를 오버라이드 선언하여 입력 또는 출력에 대한 필드값 변환 처리
// => 인스턴스의 특정 필드값을 byte 배열로 변환하여 입력 또는 출력하는 기능 제공

//객체 직렬화 클래스는 클래스를 구분하기 위해 고유값을 부여하는 필드(serialVersionUID)를 선언하는 것을 권장
// => 이클립스에서는 serialVersionUID 필드값을 자동으로 생성하는 기능 제공
public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3306639107947980039L;
	
//필드
	private String id;
	private String name;
	private String phone;
	
//생성자	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

//setter, getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//toString() 오버라이딩
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "아이디 = "+id+", 이름 = "+name+", 전화번호 = "+phone;
	}
}
