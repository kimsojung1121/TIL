package xyz.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//ä�� Ŭ���̾�Ʈ ���α׷� - Swing
// => �������� ������ �޼����� ���޹޾� ���۳�Ʈ ��� - �ݺ� ó��
// => ���۳�Ʈ�� �޼����� �Է¹޾� ������ ���� - �̺�Ʈ �ڵ鷯 �޼ҵ�
public class ChatClientApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField field;//�Է� ���۳�Ʈ
	private JTextArea area;//��� ���۳�Ʈ
	
	//������ ���ϰ� ����� ���������� �����ϱ� ���� �ʵ�
	private Socket socket;
	
	//�������� ������ �޼����� ���޹��� �Է� ��Ʈ���� �����ϱ� ���� �ʵ�
	private BufferedReader in;
	
	//�������� �޼����� ������ ��� ��Ʈ���� �����ϱ� ���� �ʵ�
	private PrintWriter out;
	
	//��ȭ���� �����ϱ� ���� �ʵ�
	private String aliasName;
	
	public ChatClientApp(String title) {
		super(title);
		
		field=new JTextField();
		area=new JTextArea();
		
		JScrollPane pane=new JScrollPane(area);
		
		getContentPane().add(pane, BorderLayout.CENTER);
		getContentPane().add(field, BorderLayout.SOUTH);
		
		field.setFont(new Font("����", Font.BOLD, 20));
		area.setFont(new Font("����", Font.BOLD, 20));
		area.setFocusable(false);
		
		field.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 400, 500);
		setVisible(true);
		
		try {
			//socket=new Socket("192.168.13.31", 6000);
			socket=new Socket("www.itwill.xyz", 6000);
			
			//������ �Է� ��Ʈ���� �����޾� ���ڿ��� ���� �� �ִ� ��Ʈ������ Ȯ���Ͽ� �ʵ忡 ����
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//������ ��� ��Ʈ���� �����޾� ���ڿ��� ���� �� �� �ִ� ��Ʈ������ Ȯ���Ͽ� �ʵ忡 ����
			out=new PrintWriter(socket.getOutputStream(),true);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "������ ������ �� �����ϴ�."
					,"���ӿ���",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//��ȭ���� �Է¹޾� �ʵ忡 ���� - �������� ��ȭ���� �Էµǵ��� �ݺ� ó��
		while(true) {
			//�Է� ���̾�α׸� ����Ͽ� ��ȭ���� �Է¹޾� ����
			aliasName=JOptionPane.showInputDialog(this, "��ȭ���� �Է��� �ּ���."
					,"��ȭ�� �Է�", JOptionPane.QUESTION_MESSAGE);
			
			//�������� ��ȭ���� �Էµ� ��� �ݺ��� ����
			if(aliasName!=null && !aliasName.equals("")) break;
			
			JOptionPane.showMessageDialog(this, "��ȭ���� �ݵ�� �Է��� �ּ���."
					,"�Է¿���",JOptionPane.ERROR_MESSAGE);
		}
		
		//�Է¹��� ��ȭ���� ������ ����
		out.println(aliasName);
		
		//�������� ������ �޼����� ���޹޾� JTextArea ���۳�Ʈ�� ��� - �ݺ� ó��
		while(true) {
			try {
				area.append(in.readLine()+"\n");
				
				//JTextArea ���۳�Ʈ�� ��ũ���� �� �Ʒ��� �̵� 
				area.setCaretPosition(area.getText().length());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "�������� ������ ���������ϴ�."
						,"���ӿ���",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("ä�� ���α׷�");
	}

	//�̺�Ʈ �ڵ鷯 �޼ҵ�
	// => JTextField ���۳�Ʈ�� �Էµ� �޼����� ���� ������ �����ϴ� ��� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		//JTextField ���۳�Ʈ�� �Էµ� �޼����� ��ȯ�޾� ����
		String message=field.getText();
		
		if(!message.equals("")) {//�Է� �޼����� ������ ���
			out.println(message);//������ �޼��� ����
			field.setText("");//JTextField ���۳�Ʈ �ʱ�ȭ
		}
	}
}







