package xyz.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//색상버튼을 누른 경우 캔버스의 배경색을 변경하는 프로그램
public class ActionCommandApp extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//이벤트 핸들러 메소드에서 사용할 컴퍼넌트 또는 컨테이너는 필드로 선언
	Button red, green, blue, white;
	Canvas canvas;
	
	public ActionCommandApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		red=new Button("빨간색");
		green=new Button("초록색");
		blue=new Button("파란색");
		white=new Button("하얀색");
		
		//이벤트 핸들러에서 쓸 예정이 아니면 지역변수로 선언
		Panel panel=new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		canvas=new Canvas();
		
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		panel.setBackground(Color.GRAY);
		
		white.setEnabled(false);
		
/*		
		red.addActionListener(new RedButtonEventHandler());
		green.addActionListener(new GreenButtonEventHandler());
		blue.addActionListener(new BlueButtonEventHandler());
		white.addActionListener(new WhiteButtonEventHandler());
*/
		
		
		red.addActionListener(new ColorButtonEventHandler());
		green.addActionListener(new ColorButtonEventHandler());
		blue.addActionListener(new ColorButtonEventHandler());
		white.addActionListener(new ColorButtonEventHandler());
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ActionCommandApp("ActionCommandApp");
	}

	
	
	
	/*	
	//모든 색상 버튼을 활성화 처리하는 메소드 - 초기화
	public void ininColorButton() {
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		white.setEnabled(true);
	}
	public class RedButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//코드의 중복성 최소화
			ininColorButton();
			red.setEnabled(false);
//			green.setEnabled(true);
//			blue.setEnabled(true);
//			white.setEnabled(true);
//			canvas.setBackground(Color.RED);
		}
	}
	
	public class GreenButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			ininColorButton();
//			red.setEnabled(true);
			green.setEnabled(false);
//			blue.setEnabled(true);
//			white.setEnabled(true);
			canvas.setBackground(Color.GREEN);
		}
	}
	
	public class BlueButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			ininColorButton();
//			red.setEnabled(true);
//			green.setEnabled(true);
			blue.setEnabled(false);
//			white.setEnabled(true);
			canvas.setBackground(Color.BLUE);
		}
	}
	
	public class WhiteButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			ininColorButton();
//			red.setEnabled(true);
//			green.setEnabled(true);
//			blue.setEnabled(true);
			white.setEnabled(false);
			canvas.setBackground(Color.WHITE);
		}
	}
*/
	
	
	
	public class ColorButtonEventHandler implements ActionListener {

		//이벤트 핸들러 메소드의 매개변수에는 이벤트 소스에 의해 생성된 XXXEvent 인스턴스가
		//자동으로 전달되어 저장
		// => 매개변수에 저장된 이벤트 정보를 이용하여 이벤트 소스 구분
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			red.setEnabled(true);
			green.setEnabled(true);
			blue.setEnabled(true);
			white.setEnabled(true);			
			
			//이벤트 소스를 구분하여 이벤트 처리
			//ActionEvent.getActionCommand() : ActionEvent를 발생시킨 이벤트 소스의
			//ActionCommand를 반환하는 메소드
			//ActionCommand : ActionEvent를 발생시킨 컴퍼넌트의 이름(문자열)
			// => Button 컴퍼넌트는 버튼 라벨명이 ActionCommand로 설정
			String actionComand=e.getActionCommand();
			
			if(actionComand.equals("빨간색")) {
				red.setEnabled(false);
				canvas.setBackground(Color.RED);
			} else if(actionComand.equals("초록색")) {
				green.setEnabled(false);
				canvas.setBackground(Color.GREEN);
				
			} else if(actionComand.equals("파란색")) {
				blue.setEnabled(false);
				canvas.setBackground(Color.BLUE);
				
			} else if(actionComand.equals("하얀색")) {
				white.setEnabled(false);
				canvas.setBackground(Color.WHITE);
			}
		}
		
	}
}
