package xyz.itwill.event;

import xyz.itwill.event.Outer.Inner;
import xyz.itwill.event.Outer.Nested;

public class OuterApp {
	public static void main(String[] args) {
		Outer outer=new Outer(100);
		outer.outerDisplay();
		
		//내부 클래스로 인스턴스 생성 불가능
		//Inner inner=new Inner();
		System.out.println("==========================================");
		outer.outerInnerDisplay();
		System.out.println("==========================================");
		//외부 클래스의 인스턴스를 이용하여 내부 클래스의 인스턴스 생성 가능
		Inner inner=outer.new Inner();
		inner.innerOuterDisplay();
		System.out.println("==========================================");
		Nested nested=new Nested(400);
		nested.nestedDisplay();
		System.out.println("==========================================");
	}
}