package xyz.itwill.dto;

/*
MYUSER ���̺� : ȸ�������� �����ϱ� ���� ���̺�
// => ���̵�(USER_ID), �̸�(USER_NAME)
create table myuser(user_id varchar2(20) primary key, user_name varchar2(30)); 

SQL ����� ��ҹ��ڸ� �������� �ʾ� �ĺ��ڸ� ������ �� ������ũ ǥ���(Snake Case) �̿� 
 => ������ũ ǥ��� : _ ��ȣ�� ����Ͽ� �ܾ�� �ܾ �����Ͽ� ǥ��
 
�̸�        ��?       ����           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(20) 
USER_NAME          VARCHAR2(30)   
*/

//Java �ڷ���(Class, Interface, Enum)�� �Ľ�Į ǥ���(Pascal Case) �̿�
// => �Ľ�Į ǥ��� : �ĺ��ڸ� �����ϴ� ��� �ܾ��� ù���ڸ� �빮�ڷ� ǥ��
public class MyUser {
	//�ڹٴ� ��ҹ��ڸ� �����ϹǷ� Java �ĺ��ڸ� ������ �� ī�� ǥ���(Camel Case) �̿�
	// => ī�� ǥ��� : �ĺ��ڸ� �����ϴ� �ܾ� �� ù��° �ܾ ������ ������ �ܾ��� ù���ڸ� �빮�ڷ� ǥ��
	private String userId;
	private String userName;
	
	public MyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
