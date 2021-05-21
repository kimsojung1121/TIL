package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//������ Ŭ������ �̺�Ʈ �ڵ鷯 Ŭ������ �ϳ��� Ŭ������ ������ ���
// => �̺�Ʈ �ڵ鷯 �޼ҵ忡�� ������ Ŭ������ ���۳�Ʈ �Ǵ� �����̳� ���� ����
public class EventSourceHandlerApp extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventSourceHandlerApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button button=new Button("���α׷� ����");
		add(button);
		
		button.addActionListener(this);
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceHandlerApp("EventHandle");
	}//end of main

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}//end of class
