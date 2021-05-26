package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CalculatorApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel label;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bMulti, bDiv, bPlus, bMinus, bClear, bEquals;

	//������� �����ϱ� ���� �ʵ�
	private String operation="";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp frame = new CalculatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalculatorApp() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		
		b7 = new JButton("7");
		b7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b7);
		
		b8 = new JButton("8");
		b8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b8);
		
		b9 = new JButton("9");
		b9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b9);
		
		bMulti = new JButton("*");
		bMulti.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bMulti);
		
		b4 = new JButton("4");
		b4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b4);
		
		b5 = new JButton("5");
		b5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b5);
		
		b6 = new JButton("6");
		b6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b6);
		
		bDiv = new JButton("/");
		bDiv.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bDiv);
		
		b1 = new JButton("1");
		b1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b1);
		
		b2 = new JButton("2");
		b2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b2);
		
		b3 = new JButton("3");
		b3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b3);
		
		bPlus = new JButton("+");
		bPlus.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bPlus);
		
		b0 = new JButton("0");
		b0.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b0);
		
		bClear = new JButton("C");
		bClear.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bClear);
		
		bEquals = new JButton("=");
		bEquals.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bEquals);
		
		bMinus = new JButton("-");
		bMinus.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bMinus);
		
		label = new JLabel("0");
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		contentPane.add(label, BorderLayout.NORTH);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bMulti.addActionListener(this);
		bDiv.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bClear.addActionListener(this);
		bEquals.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� �߻��� ��ư�� ��ȯ���� ����
		// => getSource() �޼ҵ�� Object Ÿ���� �ν��Ͻ��� ��ȯ�ϹǷ� ����� ��ü ����ȯ�Ͽ� ����
		JButton eventButton=(JButton)e.getSource();
		
		//�̺�Ʈ�� �߻��� ��ư�� �����Ͽ� �̺�Ʈ ó��
		if(eventButton==bEquals) {//"=" ��ư�� ���� ���
			//�ʵ忡 ����� ����Ŀ��� �����ڸ� �˻��Ͽ� ��ġ��(index)�� ��ȯ�޾� ����
			String[] operatorArray={"*","/","+","-"};
			int index=-1;
			for(int i=0;i<operatorArray.length;i++) {
				index=operation.lastIndexOf(operatorArray[i]);
				if(index!=-1) break;
			}
			
			//����Ŀ��� �����ڸ� ã�� �� ���� ��� �̺�Ʈ �ڵ鷯 �޼ҵ� ����
			if(index<=0) return;
			
			try {
				//����Ŀ��� �����ڿ� �ǿ����ڸ� �и��Ͽ� ����
				int num1=Integer.parseInt(operation.substring(0, index));
				String oprtator=operation.substring(index, index+1);
				int num2=Integer.parseInt(operation.substring(index+1));
				
				//�����ڸ� ���Ͽ� ������� ������� ����
				int result=0;
				switch(oprtator) {
				case "*": result=num1*num2; break;
				case "/": result=num1/num2; break;
				case "+": result=num1+num2; break;
				case "-": result=num1-num2; break;
				}
				
				//��� ���۳�Ʈ�� ���ڿ��� ������� ��������� ����
				// => ������� ������� ���ڿ��� ��ȯ�ؾ߸� �޼ҵ� ȣ�� ����
				//label.setText(String.valueOf(result));
				label.setText(result+"");
				
				//����� ���� �ʵ� �ʱ�ȭ
				//operation="";
				//operation=result+"";//���� ������� ��������� ��� ���
			} catch (ArithmeticException exception) {
				operation="";
				label.setText("0���� ���� �� �����ϴ�.");
			} catch (NumberFormatException exception) {
				operation=""; 
				label.setText("0");
				//JOptionPane.showMessageDialog(Component parent,Object message
				//,String title,int messageType) : �޼��� ���̾�α׸� ����ϴ� �޼ҵ�
				JOptionPane.showMessageDialog(this, "�Էµ� ������� ���Ŀ� ���� �ʽ��ϴ�."
					,"����",JOptionPane.ERROR_MESSAGE);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(this, "���α׷��� ����ġ ���� ������ �߻� �Ǿ����ϴ�. ���α׷��� �����մϴ�."
						,"����",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} else if(eventButton==bClear) {//"C" ��ư�� ���� ���
			operation="";//����� ���� �ʵ� �ʱ�ȭ 
			label.setText("0");//��� ���۳�Ʈ �ʱ�ȭ
		} else {//����� ���� ��ư�� ���� ���
			//�̺�Ʈ �߻� ��ư�� �󺧸��� ��ȯ�޾� ����� ���� �ʵ忡 �߰�
			//JComponenet.getText() : Swing ���۳�Ʈ�� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
			operation+=eventButton.getText();
			
			//��� ���۳�Ʈ(JLabel)�� ���ڿ��� ����� ���� �ʵ尪���� ����
			//JComponenet.setText(String text) : Swing ���۳�Ʈ�� ���ڿ��� �����ϴ� �޼ҵ�
			label.setText(operation);
		}
	}
}








