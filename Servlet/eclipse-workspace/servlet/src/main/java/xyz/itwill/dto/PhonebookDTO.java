package xyz.itwill.dto;

//DTO(Data Transfer Object) 클래스 : 테이블의 행정보를 저장하여 전달하기 위한 클래스


//PHONEBOOK	테이블의 행정보를 저장하기 위한 클래스
public class PhonebookDTO {
	
//필드
	private String phone;
	private String name;
	private String address;
	
//생성자	
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
