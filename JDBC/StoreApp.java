package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StoreApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTable storeTable, memberTable;
	JTextField sno_tf, sname_tf, sphone_tf;
	JTextField mno_tf, mname_tf, mphone_tf, mdate_tf, mpay_tf;
	JButton searchStore_btn, addStore_btn, updateStore_btn, deleteStore_btn;
	JButton searchMember_btn, addMember_btn, updateMember_btn, deleteMember_btn;
	
	public StoreApp() {
		setTitle("점포별 직원 관리 프로그램");
		setLayout(new GridLayout(0, 2));
		
		
		JPanel store_p=new JPanel();
		JPanel member_p=new JPanel();
		

		//store_p
		store_p.setLayout(new BorderLayout());
		
		
		JPanel searchStore_pnl = new JPanel();
		store_p.add(searchStore_pnl, BorderLayout.NORTH);
		
		JLabel sno_lbl = new JLabel("점포 번호");
		searchStore_pnl.add(sno_lbl);
		
		sno_tf = new JTextField();
		searchStore_pnl.add(sno_tf);
		sno_tf.setColumns(10);
		
		JLabel sname_lbl = new JLabel("점포 이름");
		searchStore_pnl.add(sname_lbl);
		
		sname_tf = new JTextField();
		searchStore_pnl.add(sname_tf);
		sname_tf.setColumns(10);
		
		searchStore_btn = new JButton("점포 검색");
		searchStore_pnl.add(searchStore_btn);
		
		
		
		storeTable = new JTable();
		storeTable.setBorder(new TitledBorder(new LineBorder(Color.gray,3),"점포 테이블"));
		store_p.add(storeTable, BorderLayout.CENTER);	
		
		
		JPanel updateStore_pnl = new JPanel();
		store_p.add(updateStore_pnl, BorderLayout.SOUTH);
		
		updateStore_pnl.add(addStore_btn = new JButton("점포 추가"));
		updateStore_pnl.add(updateStore_btn = new JButton("점포 수정"));
		updateStore_pnl.add(deleteStore_btn = new JButton("점포 삭제"));
		
		//member_p
		member_p.setLayout(new BorderLayout());
		
		
		JPanel searchMember_pnl = new JPanel();
		member_p.add(searchMember_pnl, BorderLayout.NORTH);
		
		JLabel mno_lbl = new JLabel("직원 번호");
		searchMember_pnl.add(mno_lbl);
		
		mno_tf = new JTextField();
		searchMember_pnl.add(mno_tf);
		mno_tf.setColumns(10);
		
		JLabel mname_lbl = new JLabel("직원 이름");
		searchMember_pnl.add(mname_lbl);
		
		sname_tf = new JTextField();
		searchMember_pnl.add(sname_tf);
		sname_tf.setColumns(10);
		
		searchMember_btn = new JButton("직원 검색");
		searchMember_pnl.add(searchMember_btn);
		
		
		
		memberTable = new JTable();
		memberTable.setBorder(new TitledBorder(new LineBorder(Color.gray,3),"직원 테이블"));
		member_p.add(memberTable, BorderLayout.CENTER);	
		
		
		JPanel updateMember_pnl = new JPanel();
		member_p.add(updateMember_pnl, BorderLayout.SOUTH);
		
		updateMember_pnl.add(addMember_btn = new JButton("직원 추가"));
		updateMember_pnl.add(updateMember_btn = new JButton("직원 수정"));
		updateMember_pnl.add(deleteMember_btn = new JButton("직원 삭제"));
		
		
		add(store_p);
		add(member_p);
		
		addStore_btn.addActionListener(new ActionEventHandler());
		addMember_btn.addActionListener(new ActionEventHandler());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new StoreApp();
	}
	
	public class ActionEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object eventSource=e.getSource();

			if(eventSource instanceof JButton) {
				if(eventSource==addStore_btn) {
					new addStoreDialog();
				} else if(eventSource==addMember_btn) {
					new addMemberDialog();
				}
			}
		}
		
	}
	
	
	public class addStoreDialog extends JFrame {
		private static final long serialVersionUID = 1L;
		public addStoreDialog() {
        
			setLayout(new GridLayout(3, 0));
			
			JPanel sno = new JPanel();
			sno.add(new JLabel("번호"));
			sno.add(sno_tf = new JTextField(10));

			JPanel sname = new JPanel();
			sname.add(new JLabel("이름"));
			sname.add(sname_tf = new JTextField(10));
			
			JPanel sphone = new JPanel();
			sphone.add(new JLabel("전화번호"));
			sphone.add(sphone_tf = new JTextField(10));
			
			add(sno);
			add(sname);
			add(sphone);
		
//	        setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(550, 250, 500, 600);
			setVisible(true);
		}
	}
	
	public class addMemberDialog extends JFrame {
		private static final long serialVersionUID = 1L;
		public addMemberDialog() {
        
			setLayout(new GridLayout(5, 0));
			
			JPanel mno = new JPanel();
			mno.add(new JLabel("번호"));
			mno.add(mno_tf = new JTextField(10));

			JPanel mname = new JPanel();
			mname.add(new JLabel("이름"));
			mname.add(mname_tf = new JTextField(10));
			
			JPanel mphone = new JPanel();
			mphone.add(new JLabel("전화번호"));
			mphone.add(mphone_tf = new JTextField(10));
			
			JPanel mdate = new JPanel();
			mdate.add(new JLabel("근무 시작일"));
			mdate.add(mdate_tf = new JTextField(10));
			
			JPanel mpay = new JPanel();
			mpay.add(new JLabel("전화번호"));
			mpay.add(mpay_tf = new JTextField(10));
			
			
			add(mno);
			add(mname);
			add(mphone);
			add(mdate);
			add(mpay);
		
//	        setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(550, 250, 500, 600);
			setVisible(true);
		}
	}
}
