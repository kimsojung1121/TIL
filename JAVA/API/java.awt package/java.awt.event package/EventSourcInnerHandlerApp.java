package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//������ Ŭ������ �ܺ� Ŭ������ �����ϰ� �̺�Ʈ �ڵ鷯 Ŭ������ ���� Ŭ������ ������ ���
// => �̺�Ʈ �ڵ鷯 �޼ҵ忡�� ������ Ŭ������ ���۳�Ʈ �Ǵ� �����̳� ���� ����
public class EventSourcInnerHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventSourcInnerHandlerApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button button=new Button("���α׷� ����");
		add(button);

		button.addActionListener(new ActionEventInnerHandler());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourcInnerHandlerApp("EventHandle");
	}

	public class ActionEventInnerHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
