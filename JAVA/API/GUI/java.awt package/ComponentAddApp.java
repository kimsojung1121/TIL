package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;

	public ComponentAddApp(String title) {
		super(title);
		
		//Button : 버튼을 구현한 컴퍼넌트 클래스 - 버튼라벨 설정
		Button button=new Button("버튼");
		
		//Container.add(Component c) : 컴퍼넌트를 컨테이너에 배치하는 메소드
		add(button);
		
		setBounds(600, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("컴퍼넌트");
	}
}
