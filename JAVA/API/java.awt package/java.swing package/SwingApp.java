package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

//javax.swing ��Ű���� ���۳�Ʈ �Ǵ� �����̳� Ŭ������ J�� ���� 
//�������� [�ݱ�] ��ư�� ���� ��� ���۵Ǵ� ���� �ɼ� ����
//�������� �����̳ʸ� �����޾� ������ ó�� - ���۳�Ʈ ��ġ, ��ġ ������ ����, ���� ����
public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JMenuItem init, exit;
	JButton red, green, blue, black;
	JTextArea area;
	JTextField field;
	
	public SwingApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("����(F)");
		//AbstractButton.setMnemonic(char mnemonic) : �޴��� Ű����� ���õǵ��� �����ϴ� �޼ҵ�
		// => [Alt]+[����]�� �޴� ���� : �󺧸� ���ڰ� ������ ��� _ ǥ��
		menu.setMnemonic('F');
		//JMenuItem ���۳�Ʈ�� Mnemonic ����� �����ڷ� ���� ����
		init=new JMenuItem("ȭ�� �ʱ�ȭ(I)",'I');
		exit=new JMenuItem("���α׷� ����(E)",'E');
		//JMenuItem.setAccelerator(KeyStroke keyStroke) : JMenuItem ���۳�Ʈ�� ����Ű�� �����ϴ� �޼ҵ�
		//KeyStroke : ���Ű�� ���ڸ� �����ϱ� ���� Ŭ����
		//KeyStroke.getKeyStroke(int keyCode, int modifiers) : ���Ű�� ���ڰ� �����
		//KeyStroke �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		red=new JButton("������");
		green=new JButton("�ʷϻ�");
		blue=new JButton("�Ķ���");
		black=new JButton("������");
		
		JPanel panel=new JPanel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new JTextArea();
		//JTextArea ���۳�Ʈ�� ��ũ�� �߻��� ���� JScrollPane �����̳ʿ� ��ġ
		JScrollPane pane=new JScrollPane(area);
		field=new JTextField();
		
		//JFrame.getContentPane() : �������� Container �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => �����ӿ� ���� ���������� �ʰ� �������� �����̳ʸ� �̿��Ͽ� ������ ó��
		Container container=getContentPane();
		
		container.add(panel, BorderLayout.NORTH);
		container.add(pane, BorderLayout.CENTER);
		container.add(field, BorderLayout.SOUTH);
		
		black.setEnabled(false);
		area.setFocusable(false);
		panel.setBackground(Color.GRAY);
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		red.setFont(new Font("����", Font.BOLD, 14));
		green.setFont(new Font("����", Font.BOLD, 14));
		blue.setFont(new Font("����", Font.BOLD, 14));
		area.setFont(new Font("����", Font.BOLD, 16));
		field.setFont(new Font("��ü", Font.BOLD, 16));
		
		//�̺�Ʈ �ڵ鷯 ���
		init.addActionListener(new ActionEventHandler());
		exit.addActionListener(new ActionEventHandler());
		red.addActionListener(new ActionEventHandler());
		green.addActionListener(new ActionEventHandler());
		blue.addActionListener(new ActionEventHandler());
		black.addActionListener(new ActionEventHandler());
		field.addActionListener(new ActionEventHandler());
		
		//JFrame.setDefaultCloseOperation(int operation) : �������� [�ݱ�] ��ư�� ���� ���
		//���۵Ǵ� ��ɿ� ���� ���� �ɼ��� �����ϴ� �޼ҵ�
		//[�ݱ�] ��ư�� ���� ��� ���۵Ǵ� ��ɿ� ���� ���� �ɼ� - ��� ���
		// => WindowConstants.DO_NOTHING_ON_CLOSE : �ƹ��� ���۵� �߻����� �ʵ��� ����
		// => WindowConstants.HIDE_ON_CLOSE : �������� ���⵵�� ����(�⺻)
		// => WindowConstants.DISPOSE_ON_CLOSE : �޸� ���� �� ���α׷��� ����ǵ��� ����
		// => WindowConstants.EXIT_ON_CLOSE : ������ ���α׷��� ����ǵ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}
	
	public class ActionEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource instanceof JMenuItem) {
				if(eventSource==init) {
					area.setText("");
				} else if(eventSource==exit) {
					System.exit(0);
				}
			} else if(eventSource instanceof JButton) {
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
			} else if(eventSource instanceof JTextField) {
				String text=field.getText();
				
				if(!text.equals("")) {
					area.append("[ȫ�浿]"+text+"\n");
					field.setText("");
				}
			}
		}
	}
}
