package xyz.itwill.exception;

//���� ȸ�������� �ߺ��� ��� �߻��Ǵ� ���� Ŭ����
// => ���� Ŭ������ �ݵ�� Exception Ŭ������ ��ӹ޾� �ۼ� 
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message) {
		super(message);
	}
}
