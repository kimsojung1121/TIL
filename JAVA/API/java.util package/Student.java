package xyz.itwill.util;

//�ν��Ͻ��� �ʵ尪�� ���ϱ� ���ؼ��� Comparable<T> �������̽��� ��ӹ޾� Ŭ������ �ۼ�
// => Comparable �������̽��� ���׸����� ���ϰ��� �ϴ� �ν��Ͻ��� Ŭ���� ����
// => compareTo(T o) �޼ҵ� �������̵� ����

//�л�����(�й�, �̸�)�� �����ϱ� ���� Ŭ���� - VO(Value Object) Ŭ����
public class Student implements Comparable<Student> {
	private int num;
	private String name;

//������
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
	
//�ʵ尪 ��ȯ �޼ҵ� - toString() �������̵�
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�й� = "+num+", �̸� = "+name;
	}

	//�ν��Ͻ��� �ʵ尪�� ���� ������� ��ȯ�ϴ� �޼ҵ�
	// => this�� �ʵ尪�� �Ű������� �ʵ尪�� ���� ������ �����(���, 0, ����) ��ȯ
	//Collections.sort() �޼ҵ� ���ο��� ȣ��Ǿ� ������ ���� ����
	// => ��ȯ���� ����� ��� List �ν��Ͻ��� ��Ҹ� ���� �ٲپ� ����
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
//		return this.num-o.num;//�й��� ���� �������� ����
//		return o.num-this.num;//�й��� ���� �������� ����
//		return this.name.compareTo(o.name);//�̸��� ���� �������� ����
		return o.name.compareTo(this.name);//�̸��� ���� �������� ����
	}
		

}
