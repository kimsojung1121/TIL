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
		
		String[] columNames= {"학번","이름","전화번호"};
		
		String[][] rowData= {{"1000","홍길동","010-1234-5678"},
				{"2000","임꺽정","010-1234-5678"},{"3000","전우치","010-1234-5678"},
				{"4000","일지매","010-1234-5678"},{"5000","장길산","010-1234-5678"}
		};
		
		//DefaultTableModel : 테이블 관련 정보를 저장하기 위한 클래스
		// => 테이블의 행 또는 열(셀 : Cell)을 메소드를 호출하여 조작 가능
		DefaultTableModel tableModel=new DefaultTableModel(rowData, columNames);
		
		//JTable : 값을 행과 열로 구성된 표 형식으로 출력하는 컴퍼넌트
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
