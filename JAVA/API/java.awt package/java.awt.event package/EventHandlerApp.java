package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//java.awt.event ��Ű���� ����� Ŭ���� �Ǵ� �������̽��� ��ӹ޾� �̺�Ʈ ó�� Ŭ���� �ۼ�
// => java.awt.event : �̺�Ʈ�� �̺�Ʈ ó�� ���� �ڷ����� ����� ��Ű��

//�̺�Ʈ ���α׷� �ۼ� ���
//1. ���۳�Ʈ �Ǵ� �����̳� ���� Ŭ������ �̿��Ͽ� ������ Ŭ���� �ۼ�
// => Frame Ŭ������ ��ӹ޾� �ۼ�
// => ���۳�Ʈ �Ǵ� �����̳ʿ����� �پ��� �̺�Ʈ �߻� - �̺�Ʈ �ҽ�(Event Source)
//2. �̺�Ʈ �ҽ����� �߻��� �̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯 Ŭ���� �ۼ�
// => ���۳�Ʈ���� �߻��� �̺�Ʈ�� ó���ϱ� ���� ����� �����ϴ� Ŭ����
// => XXXEvent�� ó���ϱ� ���� XXXListener �������̽��� ��ӹ޾� Ŭ���� �ۼ�
// => Listener �������̽� : �̺�Ʈ�� ó���ϱ� ���� �߻�޼ҵ尡 ����� �������̽�
// => �߻� �޼ҵ带 �������̵� �����Ͽ� �̺�Ʈ ó�� ����� �ۼ�
//3. �̺�Ʈ �ҽ����� �̺�Ʈ�� �߻��� ��� �̺�Ʈ �ڵ鷯 Ŭ������ ���۵ǵ��� �̺�Ʈ ���
// => Component.addXXXListener(Listener l) : ���۳�Ʈ���� �̺�Ʈ�� �߻��� ��� �̺�Ʈ �ڵ鷯
//Ŭ������ ������ �ν��Ͻ��� ���޹޾� �̺�Ʈ ó���ǵ��� ����ϴ� �޼ҵ�
// => �̺�Ʈ �ڵ鷯 �޼ҵ�� �ڵ� ȣ��Ǿ� �̺�Ʈ ó��

//������ Ŭ������ �̺�Ʈ �ص鷯 Ŭ������ ���� ������ ���
// => �̺�Ʈ �ڵ鷯 �޼ҵ忡�� ������ Ŭ������ ���۳�Ʈ �Ǵ� �����̳� ���� �Ұ���
public class EventHandlerApp extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventHandlerApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		//Button ���۳�Ʈ�� ����ڰ� ���� ��� ActionEvent �߻�
		// => XXXEvent : �̺�Ʈ ������ �����ϱ� ���� Ŭ����
		Button button=new Button("���α׷� ����");
		add(button);
		
		//�ý���(OS :�ü��)�� ���۳�Ʈ(�����̳�)�� �̺�Ʈ�� �����ϰ� �̺�Ʈ�� �߻��� ���
		//�̺�Ʈ �ڵ鷯 Ŭ������ �ν��Ͻ��� �����Ͽ� �̺�Ʈ �ڵ鷯 �޼ҵ� ȣ���Ͽ� �̺�Ʈ ó��
		button.addActionListener(new ActionEventHandler());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandlerApp("EventHandle");
	}//end of main

}//end of class

//�̺�Ʈ �ڵ鷯 Ŭ������ Listener �������̽��� ��ӹ޾� �ۼ�
// => ActionEvent�� ó���ϱ� ���ؼ��� ActionListener �������̽��� ��ӹ޾� �ۼ�
class ActionEventHandler implements ActionListener {
	//ActionEvent�� �߻��� ��� �ڵ� ȣ��Ǵ� �̺�Ʈ �ڵ鷯 �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ ó�� ��� �ۼ�
		System.exit(0);
		
	}
	
}