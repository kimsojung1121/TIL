package xyz.itwill.util;

//���׸�(Generic) : �ʵ��� �ڷ���(������) ��� ��� ������ �ĺ��� - ������ �ڷ��� 
// => �ڷ���(������) ����� < > ��ȣ �ȿ� ���׸� Ÿ��(�ĺ���)�� ����
// => ���׸� Ÿ���� , ��ȣ�� �̿��Ͽ� ���� ���� ����
// => ���׸� Ÿ���� �ĺ��ڴ� �빮�ڷ� �ۼ��ϴ� ���� ����
public class Generic<T> {
	private T field;
	
	public Generic() {
		// TODO Auto-generated constructor stub
	}

	public Generic(T field) {
		super();
		this.field = field;
	}

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
	

}
