package xyz.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//ActionEvent�� �߻��Ǵ� ���
//1. Button ���۳�Ʈ�� ���� ���
//2. MenuItem ���۳�Ʈ�� ������ ���
//3. TextFeild ���۳�Ʈ���� ���͸� �Է��� ���

public class EventSourceGetApp extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MenuItem init, exit;
	Button red, green, blue, black;
	TextArea area;
	TextField field;
	
	public EventSourceGetApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		
		//MenuBar �����
		MenuBar bar=new MenuBar();
		Menu menu=new Menu("����");
		init=new MenuItem("ȭ�� �ʱ�ȭ", new MenuShortcut(KeyEvent.VK_I));
		exit=new MenuItem("���α׷� ����", new MenuShortcut(KeyEvent.VK_E));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setMenuBar(bar);
		
		red=new Button("������");
		green=new Button("�ʷϻ�");
		blue=new Button("�Ķ���");
		black=new Button("������");
		
		Panel panel=new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new TextArea();
		field=new TextField();
		
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		black.setEnabled(false);
		area.setFocusable(false);
		panel.setBackground(Color.GRAY);
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		field.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
/* Menu, Button, TextField�� ������ �ۼ��ϴ� ���� ������ �ǽ��� ����
 * �ϳ��� Ŭ�������� ó���Ѵ�
 */
		init.addActionListener(new ActionEventHandler());
		exit.addActionListener(new ActionEventHandler());
		red.addActionListener(new ActionEventHandler());
		green.addActionListener(new ActionEventHandler());
		blue.addActionListener(new ActionEventHandler());
		black.addActionListener(new ActionEventHandler());
		field.addActionListener(new ActionEventHandler());
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceGetApp("EventSource");
	}
	
	//��� ���۳�Ʈ���� �߻��� ActionEvent�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯 Ŭ����
	public class ActionEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//EventObject.getSource() = �̺�Ʈ�� �߻��� ���۳�Ʈ�� ��ȯ�ϴ� �޼ҵ�
			// => �̺�Ʈ �ҽ��� Object Ÿ������ ��ȯ
			Object eventSource=e.getSource();
			
			//�̺�Ʈ�� �߻��� ���۳�Ʈ Ŭ������ �����Ͽ� ó��
			if(eventSource instanceof MenuItem) {
				//�̺�Ʈ �ҽ��� ���۳�Ʈ �ν��Ͻ��� �����Ͽ� ó��
				if(eventSource==init) {
					//Component.setText(String text) : ���۳�Ʈ�� ���ڿ��� �����ϴ� �޼ҵ�
					area.setText(""); //���۳�Ʈ�� �ؽ�Ʈ �ʱ�ȭ
				} else if(eventSource==exit) {
					System.exit(0);
				}
			} else if(eventSource instanceof Button) {
				red.setEnabled(true);
				green.setEnabled(true);
				blue.setEnabled(true);
				black.setEnabled(true);
				
				if(eventSource==red) {
					red.setEnabled(false);
					area.setForeground(Color.RED);
				} else if(eventSource==green) {
					green.setEnabled(false);
					area.setForeground(Color.GREEN);
				} else if(eventSource==blue) {
					blue.setEnabled(false);
					area.setForeground(Color.BLUE);
				} else if(eventSource==black) {
					black.setEnabled(false);
					area.setForeground(Color.BLACK);
				}
			} else if(eventSource instanceof TextField) {
				//Component.getText() : ���۳�Ʈ�� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
				// => TextField ���۳�Ʈ������ Ű����� �Է��� ���ڿ��� ��ȯ
				String text=field.getText();
				
				if(!text.equals("")) {//��ȯ���� ���ڿ��� �ִ� ���
					//TextArea.append(String s) : ���޹��� ���ڿ��� TextArea ���۳�Ʈ��
					//�߰��Ͽ� ����ϴ� �޼ҵ�
					area.append("[ȫ�浿]"+text+"\n");
					field.setText("");
				}
			}
			
		}
	}//end of class
}//end of class
