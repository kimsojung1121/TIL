package xyz.itwill.event;

import xyz.itwill.event.Outer.Inner;
import xyz.itwill.event.Outer.Nested;

public class OuterApp {
	public static void main(String[] args) {
		Outer outer=new Outer(100);
		outer.outerDisplay();
		
		//���� Ŭ������ �ν��Ͻ� ���� �Ұ���
		//Inner inner=new Inner();
		System.out.println("==========================================");
		outer.outerInnerDisplay();
		System.out.println("==========================================");
		//�ܺ� Ŭ������ �ν��Ͻ��� �̿��Ͽ� ���� Ŭ������ �ν��Ͻ� ���� ����
		Inner inner=outer.new Inner();
		inner.innerOuterDisplay();
		System.out.println("==========================================");
		Nested nested=new Nested(400);
		nested.nestedDisplay();
		System.out.println("==========================================");
	}
}