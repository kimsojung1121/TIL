package xyz.itwill.awt;

import java.awt.Frame;

//GUI ���α׷��� Frame Ŭ������ ��ӹ޾� �ۼ��ϴ� ����
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;

	//�����ڸ� �̿��Ͽ� �����ӿ� ���� ������ �۾�
	public FrameTwoApp(String title) {
		//super Ű���带 �̿��Ͽ� Frame Ŭ������ ������ ȣ�� - ������ ���� ����
		super(title);
		
		//Frame �ν��Ͻ�(this >> super)�� �޼ҵ带 ȣ���Ͽ� �����ӿ� ���� ������ �۾�
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//Frame Ŭ������ ��ӹ��� �ڽ� Ŭ������ �ν��Ͻ� ����
		// => Frame �ν��Ͻ� ���� - ������ ����
		new FrameTwoApp("������");//�������� ��� ����
	}
}
