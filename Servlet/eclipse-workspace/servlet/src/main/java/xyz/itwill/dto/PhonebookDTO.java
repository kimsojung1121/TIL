package xyz.itwill.dto;

//DTO(Data Transfer Object) Ŭ���� : ���̺��� �������� �����Ͽ� �����ϱ� ���� Ŭ����


//PHONEBOOK	���̺��� �������� �����ϱ� ���� Ŭ����
public class PhonebookDTO {
	
//�ʵ�
	private String phone;
	private String name;
	private String address;
	
//������	
	public PhonebookDTO() {
		// TODO Auto-generated constructor stub
	}

	public PhonebookDTO(String phone, String name, String address) {
		super();
		this.phone = phone;
		this.name = name;
		this.address = address;
	}
	
//setter, getter
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
