package xyz.itwill.awt;

import java.awt.Frame;

//GUI 프로그램은 Frame 클래스를 상속받아 작성하는 권장
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;

	//생성자를 이용하여 프레임에 대한 디자인 작업
	public FrameTwoApp(String title) {
		//super 키워드를 이용하여 Frame 클래스의 생성자 호출 - 프레임 제목 설정
		super(title);
		
		//Frame 인스턴스(this >> super)의 메소드를 호출하여 프레임에 대한 디자인 작업
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//Frame 클래스를 상속받은 자식 클래스로 인스턴스 생성
		// => Frame 인스턴스 생성 - 프레임 생성
		new FrameTwoApp("프레임");//생성자의 명령 실행
	}
}
