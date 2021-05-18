package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List 인터페이스를 상속받는 자료구조 클래스 : ArrayLsit, Vector, LinkedList 등
// => 요소의 저장 순서가 존재하여 첨자를 이용하여 요소 처리
// => 동일한 값의 요소 중복 저장 가능

public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : List 인스턴스에 요소(Element)를 추가하는 메소드
		list.add("홍길동");
		list.add("임꺽정");
		list.add("전우치");
		list.add("일지매");
		
		//List.toString() : List 인스턴스에 저장된 모든 요소를 문자열로 변환하여 반환하는 메소드
//		System.out.println("list.toString() = "+list.toString());
		System.out.println("list = "+list);
		System.out.println("=================================================================");
		list.add("임꺽정");
		System.out.println("list = "+list);
		System.out.println("=================================================================");
		//List.size() : List 인스턴스에 저장된 요소의 개수를 반환하는 메소드
		System.out.println("list.size() = "+list.size());
		System.out.println("=================================================================");
		
		//List.get(int index) : List 인스턴스에 저장된 요소 중 첨자 위치의 요소를 반환하는 메소드
		System.out.println("list.get(2) = "+list.get(2));
		System.out.println("=================================================================");
		//List.add(int index, E element) : List 인스턴스의 원하는 위치에 요소를 삽입하는 메소드
		list.add(4, "장길산");
		System.out.println("list = "+list);
		System.out.println("=================================================================");
		//List.remove(E element) : List 인스턴스에 저장된 요소를 제거하는 메소드
		// => 요소(인스턴스)의 값을 비교하여 제거
		// => 같은 값이 저장된 요소가 여러 개인 경우 앞부분의 요소 하나만 제거
//		list.remove("임꺽정");
		//List.remove(int index) : List 인스턴스에 저장된 요소 중 원하는 위치의 요소를 제거하는 메소드
		list.remove(5);
		System.out.println("list = "+list);
		System.out.println("=================================================================");	
		//List.set(int index, E element) : List 인스턴스에 저장된 요소 중 원하는 위치의 요소를 변경하는 메소드
		list.set(1, "임걱정");
		System.out.println("list = "+list);
		System.out.println("=================================================================");	
		//List 인스턴스의 요소에 대한 첨자를 이용한 일괄처리
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("=================================================================");
		//반복지시자(Iterator)를 이용한 일괄처리
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("=================================================================");
		//변형된 for 구문을 이용한 일괄처리
		for(String name:list) {
			System.out.println(name+" ");
		}
		System.out.println();
		System.out.println("=================================================================");

		//Collections : List 인스터스에 대한 요소 처리 기능을 제공하는 클래스
		//Collections.sort(List list) : List 인스턴스를 전달받아 List 인스턴스의 요소를 정렬하는 메소드
		Collections.sort(list);
		System.out.println("list = "+list);
		//List.clear() : List 인스턴스에 저장된 모든 요소를 제거하여 초기화 처리하는 메소드
		list.clear();
		
		//List.isEmpty() : List 인스턴스에 요소가 하나도 없는 경우 true를 반환하는 메소드
		if(list.isEmpty()) {
			System.out.println("List 인스턴스에 저장된 요소가 하나도 없습니다.");
		}
		System.out.println("=================================================================");
		//Arrays.asList(E...element) : 0개 이상의 요소를 전달받아 List 인스턴스로 반환하는 메소드
		List<Integer> numList=Arrays.asList(10,20,30,40,50);
		System.out.println("numList = "+numList);
		System.out.println("=================================================================");
	}
}
