package xyz.itwill.util;

//제네릭 타입의 필드가 선언된 클래스로 인스턴스를 생성하여 사용하는 프로그램
// => 제네릭 타입에 전달된 자료형의 인스턴스만 필드에 저장 가능
// => 필드값을 반환받을 때 명시적 객체 형변환 불필요
public class GenericApp {
	public static void main(String[] args) {
		//제네릭 타입을 사용한 자료형에는 제네릭 대신 표현될 자료형(참조형)을 전달해야만 사용 가능
		// => 제네릭 타입의 필드가 전달된 자료형의 필드로 변환
		Generic<Integer> generic1=new Generic<Integer>();
		
		//필드와 동일한 자료형의 인스턴스를 전달하여 필드에 저장
		// => 필드와 다른 자료형의 인스턴스를 전달할 경우 에러 발생
		// => 필드에 제한적인 인스턴스만 저장 가능
		generic1.setField(100);
//		generic1.setField(12.34);
				
		Integer returnObject1=generic1.getField();
		
		System.out.println("필드값 = "+returnObject1.intValue());
		System.out.println("=================================================================");
		Generic<Double> generic2=new Generic<Double>();
		
		generic2.setField(12.34);
		
		Double returnObject2=generic2.getField();
		
		System.out.println("필드값 = "+returnObject2.doubleValue());
		System.out.println("=================================================================");
		
		Generic<String> generic3=new Generic<String>();
		
		generic3.setField("홍길동");
		
		String returnObject3=generic3.getField();
		
		System.out.println("필드값 = "+returnObject3.trim());
		System.out.println("=================================================================");
		
	}
}
