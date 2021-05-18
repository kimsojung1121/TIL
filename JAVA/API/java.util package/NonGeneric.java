package xyz.itwill.util;

//대상을 추상화하여 표현해도 필드의 자료형에 따라 여러 개의 클래스를 선언하여 사용
// => 필드의 자료형을 Object 클래스로 선언 : 모든 클래스로 생성된 인스턴스 저장가능
public class NonGeneric {
	private Object field;
	
	public NonGeneric() {
		// TODO Auto-generated constructor stub
	}

	public NonGeneric(Object field) {
		super();
		this.field = field;
	}

	public Object getField() {
		return field;
	}

	public void setField(Object field) {
		this.field = field;
	}
	
	
}
