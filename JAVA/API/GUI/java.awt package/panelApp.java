package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

//panel : ���۳�Ʈ�� ��ġ�ϱ� ���� �����̳� Ŭ����
// => �ٸ� �����̳ʿ� ��ġ�Ͽ� ���۵Ǵ� �������� �����̳�
public class panelApp extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public panelApp(String title) {
		super(title);
		
		Button red=new Button("������");
		Button green=new Button("�ʷϻ�");
		Button blue=new Button("�Ķ���");
		
		//�г��� �⺻ ��ġ �����ڴ� FlowLayout
		Panel panel=new Panel();
		
		//�гο� ���۳�Ʈ ��ġ
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		//TextArea : �ؽ�Ʈ�� ���� �� �Է��ϰų� ����ϱ� ���� ���۳�Ʈ
		TextArea textArea=new TextArea();
		
		//TextField : �ؽ�Ʈ�� �� �� �Է��ϰų� ����ϱ� ���� ���۳�Ʈ
		TextField textField=new TextField();
		
		//�������� �⺻ ��ġ �����ڴ� BorderLayout
		//�����ӿ� ���۳�Ʈ(�����̳�)�� ��ġ
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		
		//Component.setFont(Font f) : ���۳�Ʈ�� ���� ���� �Ӽ��� �����ϴ� �޼ҵ�
		//Font : ���� ���� �Ӽ��� �����ϱ� ���� Ŭ����
		// => Font(String name, int style, int size) : name(�۲�), style(��Ÿ��), size(ũ��)
		// => �����̳��� ������ ���� �Ӽ��� �����ϸ� ���ӵ� ���۳�Ʈ�� ������ ���� �Ӽ��� ����
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		textArea.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
		textField.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 16));
		
		//Component.setForegrount(Color c) : ���۳�Ʈ�� ���ڻ��� �����ϴ� �޼ҵ�
		//Color : ��������(RED:0~255,GREEN:0~255,BLUE:0~255)�� �����ϱ� ���� Ŭ����
		red.setForeground(new Color(255, 0, 0));
		green.setForeground(new Color(0, 255, 0));
		blue.setForeground(new Color(0, 0, 255));
		
		//Component.setBackground(Color c) : ���۳�Ʈ�� ������ �����ϴ� �޼ҵ�
		// => Color Ŭ�������� ��ǥ���� ���� ����ʵ�� ����
		// => �����̳��� ������ ������ ��� ���ӵ� ���۳�Ʈ�� ������ �̺���
		panel.setBackground(Color.GRAY);
				
		//Component.setEnabled(boolean b) : ���۳�Ʈ�� Ȱ�� ���θ� �����ϱ� ���� �޼ҵ�
		// => false : ���۳�Ʈ ��Ȱ��, true : ���۳�Ʈ Ȱ��(�⺻)
		red.setEnabled(false);
				
		//TextComponent.setEditable(boolean b) : �ؽ�Ʈ ���۳�Ʈ�� �ؽ�Ʈ �Է� ��� ��� ���θ� �����ϱ� ���� �޼ҵ�
		// => false : �Է� ��� ��Ȱ��, true : �Է� ��� Ȱ��(�⺻)
		//textArea.setEditable(false);
				
		//Component.setFocusable(boolean b) : ���۳�Ʈ�� �Է� ���� ��ġ ���θ� �����ϱ� ���� �޼ҵ�
		// => false : �Է� ���� ��ġ �Ұ���, true : �Է� ���� ��ġ ����(�⺻)
		textArea.setFocusable(false);
		
		
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new panelApp("Panel");
	}
}
