package xyz.itwill.util;

//����� �߻�ȭ�Ͽ� ǥ���ص� �ʵ��� �ڷ����� ���� ���� ���� Ŭ������ �����Ͽ� ���
// => �ʵ��� �ڷ����� Object Ŭ������ ���� : ��� Ŭ������ ������ �ν��Ͻ� ���尡��
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
