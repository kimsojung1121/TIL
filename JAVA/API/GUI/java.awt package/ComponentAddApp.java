package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;

	public ComponentAddApp(String title) {
		super(title);
		
		//Button : ��ư�� ������ ���۳�Ʈ Ŭ���� - ��ư�� ����
		Button button=new Button("��ư");
		
		//Container.add(Component c) : ���۳�Ʈ�� �����̳ʿ� ��ġ�ϴ� �޼ҵ�
		add(button);
		
		setBounds(600, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("���۳�Ʈ");
	}
}
