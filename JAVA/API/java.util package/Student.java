package xyz.itwill.util;

//인스턴스의 필드값을 비교하기 위해서는 Comparable<T> 인터페이스를 상속받아 클래스를 작성
// => Comparable 인터페이스의 제네릭에는 비교하고자 하는 인스턴스의 클래스 전달
// => compareTo(T o) 메소드 오버라이드 선언

//학생정보(학번, 이름)를 저장하기 위한 클래스 - VO(Value Object) 클래스
public class Student implements Comparable<Student> {
	private int num;
	private String name;

//생성자
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

//setter, getter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//필드값 반환 메소드 - toString() 오버라이드
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학번 = "+num+", 이름 = "+name;
	}

	//인스턴스의 필드값을 비교한 결과값을 반환하는 메소드
	// => this의 필드값과 매개변수의 필드값을 빼기 연산한 결과값(양수, 0, 음수) 반환
	//Collections.sort() 메소드 내부에서 호출되어 정렬의 기준 제공
	// => 반환값이 양수인 경우 List 인스턴스의 요소를 서로 바꾸어 저장
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
//		return this.num-o.num;//학번에 대한 오름차순 정렬
//		return o.num-this.num;//학번에 대한 내림차순 정렬
//		return this.name.compareTo(o.name);//이름에 대한 오름차순 정렬
		return o.name.compareTo(this.name);//이름에 대한 내림차순 정렬
	}
		

}
