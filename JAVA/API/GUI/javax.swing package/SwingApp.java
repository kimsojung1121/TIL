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

//javax.swing 패키지의 컴퍼넌트 또는 컨테이너 클래스는 J로 시작 
//프레임의 [닫기] 버튼을 누른 경우 동작되는 종료 옵션 제공
//프레임의 컨테이너를 제공받아 디자인 처리 - 컴퍼넌트 배치, 배치 관리자 변경, 배경색 변경
public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JMenuItem init, exit;
	JButton red, green, blue, black;
	JTextArea area;
	JTextField field;
	
	public SwingApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("파일(F)");
		//AbstractButton.setMnemonic(char mnemonic) : 메뉴를 키보드로 선택되도록 변경하는 메소드
		// => [Alt]+[문자]로 메뉴 선택 : 라벨명에 문자가 존재할 경우 _ 표시
		menu.setMnemonic('F');
		//JMenuItem 컴퍼넌트는 Mnemonic 기능을 생성자로 제공 가능
		init=new JMenuItem("화면 초기화(I)",'I');
		exit=new JMenuItem("프로그램 종료(E)",'E');
		//JMenuItem.setAccelerator(KeyStroke keyStroke) : JMenuItem 컴퍼넌트의 단축키를 변경하는 메소드
		//KeyStroke : 기능키와 문자를 저장하기 위한 클래스
		//KeyStroke.getKeyStroke(int keyCode, int modifiers) : 기능키와 문자가 저장된
		//KeyStroke 인스턴스를 생성하여 반환하는 메소드
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		red=new JButton("빨간색");
		green=new JButton("초록색");
		blue=new JButton("파란색");
		black=new JButton("검정색");
		
		JPanel panel=new JPanel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new JTextArea();
		//JTextArea 컴퍼넌트의 스크롤 발생을 위해 JScrollPane 컨테이너에 배치
		JScrollPane pane=new JScrollPane(area);
		field=new JTextField();
		
		//JFrame.getContentPane() : 프레임의 Container 인스턴스를 반환하는 메소드
		// => 프레임에 직접 디자인하지 않고 프레임의 컨테이너를 이용하여 디자인 처리
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
		red.setFont(new Font("굴림", Font.BOLD, 14));
		green.setFont(new Font("굴림", Font.BOLD, 14));
		blue.setFont(new Font("굴림", Font.BOLD, 14));
		area.setFont(new Font("굴림", Font.BOLD, 16));
		field.setFont(new Font("굴체", Font.BOLD, 16));
		
		//이벤트 핸들러 등록
		init.addActionListener(new ActionEventHandler());
		exit.addActionListener(new ActionEventHandler());
		red.addActionListener(new ActionEventHandler());
		green.addActionListener(new ActionEventHandler());
		blue.addActionListener(new ActionEventHandler());
		black.addActionListener(new ActionEventHandler());
		field.addActionListener(new ActionEventHandler());
		
		//JFrame.setDefaultCloseOperation(int operation) : 프레임의 [닫기] 버튼을 누른 경우
		//동작되는 기능에 대한 종료 옵션을 변경하는 메소드
		//[닫기] 버튼을 누른 경우 동작되는 기능에 대한 종료 옵션 - 상수 사용
		// => WindowConstants.DO_NOTHING_ON_CLOSE : 아무런 동작도 발생되지 않도록 설정
		// => WindowConstants.HIDE_ON_CLOSE : 프레임을 숨기도록 설정(기본)
		// => WindowConstants.DISPOSE_ON_CLOSE : 메모리 정리 후 프로그램이 종료되도록 설정
		// => WindowConstants.EXIT_ON_CLOSE : 무조건 프로그램이 종료되도록 설정
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
				
				((JButton)eventSource).setEnabled(false);
				
				if(eventSource==red) {
					//red.setEnabled(false);
					area.setForeground(Color.RED);
				} else if(eventSource==green) {
					//green.setEnabled(false);
					area.setForeground(Color.GREEN);
				} else if(eventSource==blue) {
					//blue.setEnabled(false);
					area.setForeground(Color.BLUE);
				} else if(eventSource==black) {
					//black.setEnabled(false);
					area.setForeground(Color.BLACK);
				}
			} else if(eventSource instanceof JTextField) {
				String text=field.getText();
				
				if(!text.equals("")) {
					area.append("[홍길동]"+text+"\n");
					field.setText("");
				}
			}
		}
	}
}
