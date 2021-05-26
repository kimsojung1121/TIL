package xyz.itwill.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableApp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTableApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		String[] columNames= {"�й�","�̸�","��ȭ��ȣ"};
		
		String[][] rowData= {{"1000","ȫ�浿","010-1234-5678"},
				{"2000","�Ӳ���","010-1234-5678"},{"3000","����ġ","010-1234-5678"},
				{"4000","������","010-1234-5678"},{"5000","����","010-1234-5678"}
		};
		
		//DefaultTableModel : ���̺� ���� ������ �����ϱ� ���� Ŭ����
		// => ���̺��� �� �Ǵ� ��(�� : Cell)�� �޼ҵ带 ȣ���Ͽ� ���� ����
		DefaultTableModel tableModel=new DefaultTableModel(rowData, columNames);
		
		//JTable : ���� ��� ���� ������ ǥ �������� ����ϴ� ���۳�Ʈ
//		JTable table=new JTable(rowData, columNames);
		JTable table=new JTable(tableModel);
		
		JScrollPane pane=new JScrollPane(table);
		
		getContentPane().add(pane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableApp("JTable");
	}
}
