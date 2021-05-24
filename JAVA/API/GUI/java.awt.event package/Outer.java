package xyz.itwill.event;

//�ܺ� Ŭ����(Outer Class) : ���� Ŭ������ ����� Ŭ����
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
		//���� Ŭ������ �ʵ� �Ǵ� �޼ҵ� ���� �Ұ���
		//System.out.println("innerNum = "+innerNum);
		
		//�ܺ� Ŭ������ �޼ҵ忡�� ���� Ŭ������ �ν��Ͻ� ���� ����
		Inner inner=new Inner();
		//���� Ŭ������ ������ �ν��Ͻ��� �̿��Ͽ� �ʵ� �Ǵ� �޼ҵ� ���� ����
		// => ���� �����ڿ� ��� ���� �ʵ� �Ǵ� �޼ҵ� ����
		inner.innerNum=200;
		inner.innerDisplay();
	}
	
	//���� Ŭ����(Inner Class) : Ŭ���� ���ο� ����� Ŭ����
	// => �ܺ� Ŭ���������� �ν��Ͻ��� �����Ͽ� ����� �� Ŭ����
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
		
		//���� Ŭ������ �޼ҵ忡���� �ܺ� Ŭ������ �ʵ� �Ǵ� �޼ҵ� ���� ����
		public void innerOuterDisplay() {
			outerNum=300;
			outerDisplay();
		}
	}
	
	//���� ���� Ŭ����(Nested Class) : Ŭ���� ���ο� ����� ���� Ŭ����
	// => ���� Ŭ������ �޼ҵ忡���� �ܺ� Ŭ������ �ʵ� �Ǵ� �޼ҵ� ���� �Ұ���
	// => ���� Ŭ������ �޼ҵ忡���� �ܺ� Ŭ������ ���� �ʵ� �Ǵ� ���� �޼ҵ� ���� ����
	// => �ܺ� Ŭ������ ������� �ν��Ͻ� �����Ͽ� ��� ������ Ŭ����
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








