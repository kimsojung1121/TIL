package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

//panel : 컴퍼넌트를 배치하기 위한 컨테이너 클래스
// => 다른 컨테이너에 배치하여 동작되는 종속적인 컨테이너
public class panelApp extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public panelApp(String title) {
		super(title);
		
		Button red=new Button("빨간색");
		Button green=new Button("초록색");
		Button blue=new Button("파란색");
		
		//패널의 기본 배치 관리자는 FlowLayout
		Panel panel=new Panel();
		
		//패널에 컴퍼넌트 배치
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		//TextArea : 텍스트를 여러 줄 입력하거나 출력하기 위한 컴퍼넌트
		TextArea textArea=new TextArea();
		
		//TextField : 텍스트를 한 줄 입력하거나 출력하기 위한 컴퍼넌트
		TextField textField=new TextField();
		
		//프레임의 기본 배치 관리자는 BorderLayout
		//프레임에 컴퍼넌트(컨테이너)를 배치
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		
		//Component.setFont(Font f) : 컴퍼넌트의 글자 관련 속성을 변경하는 메소드
		//Font : 글자 관련 속성을 저장하기 위한 클래스
		// => Font(String name, int style, int size) : name(글꼴), style(스타일), size(크기)
		// => 컨테이너의 디자인 관련 속성을 변경하면 종속된 컴퍼넌트의 디자인 관련 속성도 변경
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		textArea.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
		textField.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 16));
		
		//Component.setForegrount(Color c) : 컴퍼넌트의 글자색을 변경하는 메소드
		//Color : 색상정보(RED:0~255,GREEN:0~255,BLUE:0~255)를 저장하기 위한 클래스
		red.setForeground(new Color(255, 0, 0));
		green.setForeground(new Color(0, 255, 0));
		blue.setForeground(new Color(0, 0, 255));
		
		//Component.setBackground(Color c) : 컴퍼넌트의 배경색을 변경하는 메소드
		// => Color 클래스에는 대표적인 색을 상수필드로 제공
		// => 컨테이너의 배경색을 변경한 경우 종속된 컴퍼넌트의 배경색은 미변경
		panel.setBackground(Color.GRAY);
				
		//Component.setEnabled(boolean b) : 컴퍼넌트의 활성 여부를 설정하기 위한 메소드
		// => false : 컴퍼넌트 비활성, true : 컴퍼넌트 활성(기본)
		red.setEnabled(false);
				
		//TextComponent.setEditable(boolean b) : 텍스트 컴퍼넌트의 텍스트 입력 기능 사용 여부를 설정하기 위한 메소드
		// => false : 입력 기능 비활성, true : 입력 기능 활성(기본)
		//textArea.setEditable(false);
				
		//Component.setFocusable(boolean b) : 컴퍼넌트의 입력 촛점 위치 여부를 설정하기 위한 메소드
		// => false : 입력 촛점 위치 불가능, true : 입력 촛점 위치 가능(기본)
		textArea.setFocusable(false);
		
		
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new panelApp("Panel");
	}
}
