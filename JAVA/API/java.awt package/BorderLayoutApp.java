package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//BorderLayout : ���۳�Ʈ�� ��,��,��,��,�߾����� �����Ͽ� ��ġ�ϴ� ��ġ ������ Ŭ����
// => add() �޼ҵ� ȣ��� ��ġ�� �����Ͽ� ���۳�Ʈ�� ��ġ
// => Frame, Window, Dialog ���� �����̳ʴ� BorderLayout�� �⺻ ��ġ �����ڷ� ����
public class BorderLayoutApp extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BorderLayoutApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//Frame�� ��ġ �����ڸ� BorderLayout���� ����
//		BorderLayout layout=new BorderLayout();
//		setLayout(layout);
		
		//Frame�� �⺻ ��ġ �����ڴ� BorderLayout�̹Ƿ� ��ġ ������ ������ ���ǹ�
//		setLayout(new BorderLayout());
		
		Button button1=new Button("��ư-1");
		Button button2=new Button("��ư-2");
		Button button3=new Button("��ư-3");
		Button button4=new Button("��ư-4");
		Button button5=new Button("��ư-5");
		
		//Container.add(Component c, Object constraints) : ���۳�Ʈ�� ���ϴ� �����̳� ��ġ��
		//��ġ�ϴ� �޼ҵ�
		// => ���۳�Ʈ��ġ ��ġ�� BorderLayout Ŭ������ ����ʵ� �̿�
		// => ���۳�Ʈ ��ġ ��ġ�� ������ ��� ������ �߾ӿ� ��ġ
		// => �߾ӿ��� �ݵ�� ���۳�Ʈ�� ��ġ�ؾ� ������ ��,��,��,�� ��ġ���� ���۳�Ʈ ��ġ ���� ����
		add(button1, BorderLayout.EAST);//this.add()
		add(button2, BorderLayout.WEST);
		add(button3, BorderLayout.SOUTH);
		add(button4, BorderLayout.NORTH);
		add(button5, BorderLayout.CENTER);
		
		setBounds(600, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayout");
	}

}
