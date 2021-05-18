package xyz.itwill.util;

//제네릭(Generic) : 필드의 자료형(참조형) 대신 사용 가능한 식별자 - 미지정 자료형 
// => 자료형(참조형) 선언시 < > 기호 안에 제네릭 타입(식별자)을 선언
// => 제네릭 타입은 , 기호를 이용하여 나열 선언 가능
// => 제네릭 타입의 식별자는 대문자로 작성하는 것을 권장
public class Generic<T> {
	private T field;
	
	public Generic() {
		// TODO Auto-generated constructor stub
	}

	public Generic(T field) {
		super();
		this.field = field;
	}

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
	

}
