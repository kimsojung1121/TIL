package xyz.itwill.dto;

//MYCOMMENT ���̺�� MYUSER ���̺��� �˻������ �����ϱ� ���� Ŭ����
// => 1:1 ������ ���� �˻� ����� �����ϱ� ���� Ŭ����
// => POJO(Plan Old Java Object) ��� : ���� Ŭ������ �����Ͽ� ���꼺 ���� �� ���������� ȿ���� ����
public class MyCommentUser2 {
	//�˻����� �Խñ�����(MYCOMMENT ���̺�)�� �����ϱ� �ʵ� - ���� ����
	// => ���� ���谡 �����Ǳ� ���ؼ��� �ʵ忡 �ν��Ͻ� ���� - association ������Ʈ ���
	private MyComment1 comment;
	
	//�˻����� ȸ������(MYUSER ���̺�)�� �����ϱ� �ʵ� - ���� ����
	private MyUser user;
	
	public MyCommentUser2() {
		// TODO Auto-generated constructor stub
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
}
