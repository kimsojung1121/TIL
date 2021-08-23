package xyz.itwill.mvc;

//��(View) ���� ������ �����ϱ� ���� Ŭ����
public class ActionForward {
	//�̵� ���� ���� ������ �����ϱ� ���� �ʵ�
	// => false : �����̷�Ʈ �̵�, true : ������ �̵�
	//�����̷�Ʈ �̵� : Ŭ���̾�Ʈ���� URL �ּ�(XXX.do)�� �����Ͽ� �ٽ� ��û�ϵ��� ���� ó��
	// => Ŭ���̾�Ʈ�� URL �ּ� ����
	//������ �̵� : ���� �����α׷����� �ٸ� �����α׷�(XXX.jsp)���� �����带 �̵��Ͽ� ���� ó��
	// => Ŭ���̾�Ʈ�� URL �ּ� �̺���
	private boolean forward;
	
	//�̵��� �����α׷��� �����ϱ� ���� �ʵ�
	// => �����̷�Ʈ �̵� : XXX.do, ������ �̵� : XXX.jsp
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
