package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

//GridLayout : ���۳�Ʈ�� ��� ���� �̿��Ͽ� ��ġ�ϴ� ��ġ ������ Ŭ����
// => ���� �켱���� ���۳�Ʈ ��ġ
public class GridLayoutApp extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GridLayoutApp(String title) {
		super(title);
		
		//�������� ��ġ �����ڸ� GridLayout���� ����
		// => GridLayout �ν��Ͻ��� ��� ���� �����ϴ� �����ڷ� �ν��Ͻ� ����
		setLayout(new GridLayout(3, 2));//3�� 2��
		
		Button button1=new Button("��ư-1");
		Button button2=new Button("��ư-2");
		Button button3=new Button("��ư-3");
		Button button4=new Button("��ư-4");
		Button button5=new Button("��ư-5");
		Button button6=new Button("��ư-6");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);

		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutApp("GridLayoutApp");
	}//end of main
}//end of class
