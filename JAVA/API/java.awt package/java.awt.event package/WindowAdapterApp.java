package xyz.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame �����̳ʿ����� �⺻������ WindowEvent �߻�
// => WindowAdapter Ŭ������ ��ӹ��� �̺�Ʈ �ڵ鷯 Ŭ������ �ۼ��Ͽ� �̺�Ʈ ó��
//XXXAdapter : �̺�Ʈ�� ó���ϱ� ���� ����� �����ϴ� Ŭ����
// => Listener �������̽��� �߻� �޼ҵ尡 2�� �̻��� ��� Adapter Ŭ���� ����
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowEventHandler());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("WindowEvent");
	}
	
	//Adapter Ŭ������ ��ӹ��� �̺�Ʈ �ڵ鷯 Ŭ����
	// => �ʿ��� �̺�Ʈ �ڵ鷯 �޼ҵ常 �������̽� �����Ͽ� �̺�Ʈ ó��
	public class WindowEventHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
