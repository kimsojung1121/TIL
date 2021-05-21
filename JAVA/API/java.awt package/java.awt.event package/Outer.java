package xyz.itwill.event;

//외부 클래스(Outer Class) : 내부 클래스가 선언된 클래스
public class Outer {
	private int outerNum;
	
	public Outer() {
		// TODO Auto-generated constructor stub
	}

	public Outer(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay() {
		System.out.println("outerNum = "+outerNum);
	}
	
	public void outerInnerDisplay() {
		//내부 클래스의 필드 또는 메소드 접근 불가능
		//System.out.println("innerNum = "+innerNum);
		
		//외부 클래스의 메소드에서 내부 클래스로 인스턴스 생성 가능
		Inner inner=new Inner();
		//내부 클래스로 생성된 인스턴스를 이용하여 필드 또는 메소드 접근 가능
		// => 접근 지정자에 상관 없이 필드 또는 메소드 접근
		inner.innerNum=200;
		inner.innerDisplay();
	}
	
	//내부 클래스(Inner Class) : 클래스 내부에 선언된 클래스
	// => 외부 클래스에서만 인스턴스를 생성하여 사용할 수 클래스
	public class Inner {
		private int innerNum;
		
		public Inner() {
			// TODO Auto-generated constructor stub
		}

		public Inner(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}
		
		public void innerDisplay() {
			System.out.println("innerNum = "+innerNum);
		}
		
		//내부 클래스의 메소드에서는 외부 클래스의 필드 또는 메소드 접근 가능
		public void innerOuterDisplay() {
			outerNum=300;
			outerDisplay();
		}
	}
	
	//내부 정적 클래스(Nested Class) : 클래스 내부에 선언된 정적 클래스
	// => 정적 클래스의 메소드에서는 외부 클래스의 필드 또는 메소드 접근 불가능
	// => 정적 클래스의 메소드에서는 외부 클래스의 정적 필드 또는 정적 메소드 접근 가능
	// => 외부 클래스와 상관없이 인스턴스 생성하여 사용 가능한 클래스
	public static class Nested {
		private int nestedNum;
		
		public Nested() {
			// TODO Auto-generated constructor stub
		}

		public Nested(int nestedNum) {
			super();
			this.nestedNum = nestedNum;
		}

		public int getNestedNum() {
			return nestedNum;
		}

		public void setNestedNum(int nestedNum) {
			this.nestedNum = nestedNum;
		}
		
		public void nestedDisplay() {
			System.out.println("nestedNum = "+nestedNum);
			//System.out.println("outerNum = "+outerNum);
		}
	}
}








