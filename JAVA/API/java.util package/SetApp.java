package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set 인터페이스를 상속받는 자료구조 클래스 - HashSet, LinkedHashSet, TreeSet 등
// => 저장 순서가 없으며 동일한 값이 저장된 인스턴스가 존재하지 않는 자료구조 클래스
public class SetApp {
	public static void main(String[] args) {
		//제네릭을 사용하지 않을 경우 기본적으로 모든 인스턴스를 Object 타입으로 저장 - 비권장
		// => 모든 클래스의 인스턴스를 Set 인스턴스에 저장 가능
		// => 저장된 인스턴스를 반환받아 사용할 경우 반드시 명시적 객체 형변환 후 사용
//		HashSet set=new HashSet<E>();
		
		//제네릭 타입에 자료형을 전달하여 Set 인스턴스 생성 - 권장
		// => 제네릭 타입으로 전달된 자료형의 인스턴스만을 Set 인스턴스에 저장 가능
		// => 저장된 인스턴스를 명시적 객체 형변환 없이 반환받아 사용
//		HashSet<String> set=new HashSet<String>();
		
		//참조변수는 인터페이스(부모)를 이용하여 생성하는 것을 권장
		// => 인터페이스를 상속받은 모든 자식 클래스의 인스턴스 저장
		// => 클래스 간의 결합도를 낮추어 유지보수의 효율성 증가
		Set<String> set=new HashSet<String>();
		
		//Set.add(E element) : Set 인스턴스에 요소(Element)를 추가하는 메소드
		set.add("홍길동");
//		set.add(100);//제네릭 타입으로 전달된 자료형의 인스턴스가 아닌 경우 에러 발생
		set.add("임꺽정");
		set.add("전우치");
		set.add("일지매");
		
		//Set.toString() : Set 인스턴스에 저장된 모든 요소를 문자열로 변환하여 반환하는 메소드
//		System.out.println("set.toString() = "+set.toString());
		System.out.println("set = "+set);
		System.out.println("===========================================================");
		//Set 인스턴스에는 동일한 값의 요소가 중복 저장 불가
		set.add("홍길동");
		System.out.println("set = "+set);
		System.out.println("===========================================================");
		//Set.remove(E element) : Set 인스턴스에 저장된 요소를 제거하는 메소드
		// => 요소(인스턴스)의 값을 비교하여 제거
		set.remove("임꺽정");
		System.out.println("set = "+set);
		System.out.println("===========================================================");
		//Set.size() : Set 인스턴스에 저장된 요소의 개수를 반환하는 메소드
		System.out.println("set.size() = "+set.size());
		System.out.println("===========================================================");
		//Set.iterator() : Set 인스턴스에 저장된 요소를 반복 처리하기 위한 Iterator 인스턴스를 반환하는 메소드
		//Iterator : 자료구조 인스턴스에 대한 반복 처리 기능을 제공되는 인터페이스 - 반복지시자
		Iterator<String> iterator=set.iterator();
		
		//Iterator.hasNext() : Iterator 인스턴스로 처리 가능한 요소의 존재 유무를 반환하는 메소드
		// => false : 처리 요소 미존재, true : 처리 요소 존재
		while(iterator.hasNext()) {
			//Iterator.next() : Iterator 인스턴스가 처리 가능한 현재 요소를 반환하는 메소드
			// => 현재 요소를 반환하고 다음 요소로 이동 처리
			String str=iterator.next();
			System.out.println(str+" ");
		}
		System.out.println();
		System.out.println("===========================================================");

		//변형된 for 구문은 내부적으로 Iterator 인스턴스를 사용하여 반복 처리
		for(String name:set) {
			System.out.print(name+" ");
		}
		System.out.println();
		System.out.println("===========================================================");
	}
}
