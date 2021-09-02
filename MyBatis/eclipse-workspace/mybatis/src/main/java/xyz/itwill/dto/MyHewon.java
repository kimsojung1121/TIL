package xyz.itwill.dto;

/*
MYHEWON ���̺� : ȸ�������� �����ϱ� ���� ���̺�
 => ���̵�(HEWON_ID),�̸�(HEWON_NAME),��ȭ��ȣ(HEWON_PHONE),�̸���(HEWON_EMAIL),��������(HEWON_STATE)
 => �������� : 1(���̵�),2(���̵�&�̸�),3(���̵�&�̸�&��ȭ��ȣ),4(���̵�&�̸�&��ȭ��ȣ&�̸���)
create table myhewon(hewon_id varchar2(20) primary key,hewon_name varchar2(30)
    ,hewon_phone varchar2(20),hewon_email varchar2(50),hewon_state number(1));
    
�̸�          ��?       ����           
----------- -------- ------------ 
HEWON_ID    NOT NULL VARCHAR2(20) 
HEWON_NAME           VARCHAR2(30) 
HEWON_PHONE          VARCHAR2(20) 
HEWON_EMAIL          VARCHAR2(50) 
HEWON_STATE          NUMBER(1)        
*/
public class MyHewon {
	private String id;
	private String name="�̰���";
	private String phone="�̰���";
	private String email="�̰���";
	private int state;
	
	public MyHewon() {
		// TODO Auto-generated constructor stub
	}

	public MyHewon(String id, String name, String phone, String email, int state) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}












