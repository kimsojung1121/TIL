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

//ActionEvent가 발생되는 경우
//1. Button 컴퍼넌트를 누른 경우
//2. MenuItem 컴퍼넌트를 선택한 경우
//3. TextFeild 컴퍼넌트에서 엔터를 입력한 경우

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
		
		
		//MenuBar 만들기
		MenuBar bar=new MenuBar();
		Menu menu=new Menu("파일");
		init=new MenuItem("화면 초기화", new MenuShortcut(KeyEvent.VK_I));
		exit=new MenuItem("프로그램 종료", new MenuShortcut(KeyEvent.VK_E));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setMenuBar(bar);
		
		red=new Button("빨간색");
		green=new Button("초록색");
		blue=new Button("파란색");
		black=new Button("검정색");
		
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
		
/* Menu, Button, TextField를 나눠서 작성하는 것이 좋지만 실습을 위해
 * 하나의 클래스에서 처리한다
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
	
	//모든 컴퍼넌트에서 발생된 ActionEvent를 처리하기 위한 이벤트 핸들러 클래스
	public class ActionEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//EventObject.getSource() = 이벤트가 발생된 컴퍼넌트를 반환하는 메소드
			// => 이벤트 소스를 Object 타입으로 반환
			Object eventSource=e.getSource();
			
			//이벤트가 발생된 컴퍼넌트 클래스로 구분하여 처리
			if(eventSource instanceof MenuItem) {
				//이벤트 소스를 컴퍼넌트 인스턴스로 구분하여 처리
				if(eventSource==init) {
					//Component.setText(String text) : 컴퍼넌트의 문자열을 변경하는 메소드
					area.setText(""); //컴퍼넌트의 텍스트 초기화
				} else if(eventSource==exit) {
					System.exit(0);
				}
			} else if(eventSource instanceof Button) {
				red.setEnabled(true);
				green.setEnabled(true);
				blue.setEnabled(true);
				black.setEnabled(true);
				
				//명시적 객체 형변환을 이용하여 Object 타입을 Button 타입으로 형변환
				// => Button 클래스의 메소드 호출
				((Button)eventSource).setEnabled(false);
				
				
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
			} else if(eventSource instanceof TextField) {
				//Component.getText() : 컴퍼넌트의 문자열을 반환하는 메소드
				// => TextField 컴퍼넌트에서는 키보드로 입력한 문자열을 반환
				String text=field.getText();
				
				if(!text.equals("")) {//반환받은 문자열이 있는 경우
					//TextArea.append(String s) : 전달받은 문자열을 TextArea 컴퍼넌트에
					//추가하여 출력하는 메소드
					area.append("[홍길동]"+text+"\n");
					field.setText("");
				}
			}
			
		}
	}//end of class
}//end of class
