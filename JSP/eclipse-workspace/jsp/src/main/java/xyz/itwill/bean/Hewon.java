package xyz.itwill.bean;

//ȸ�������� �����ϱ� ���� Ŭ���� - JavaBean Ŭ����, VO Ŭ����, DTO Ŭ����
//JavaBean Ŭ���� : �����α׷�(JSP ����)���� ���ް��� ������ ������ Ŭ����
//JavaBean Ŭ������ �ۼ���Ģ
// => ���ް��� �̸�(�Է��±��� name �Ӽ���)�� ������ �̸����� �ʵ� ����
// => public ���������ڿ� �Ű������� ���� ������ �ۼ�
// => �ʵ尪�� ��ȯ�ϴ� �޼ҵ�(Getter)�� �ʵ尪�� �����ϴ� �޼ҵ�(Setter) �ۼ� 
public class Hewon {
	private String name; 
	private String phone; 
	private String address; 
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	//�ʵ���� �̿��Ͽ� Getter �޼ҵ�� Setter �޼ҵ� �ۼ�
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
