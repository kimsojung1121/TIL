package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//java.awt.event 패키지에 선언되 클래스 또는 인터페이스를 상속받아 이벤트 처리 클래스 작성
// => java.awt.event : 이벤트와 이벤트 처리 관련 자료형이 선언된 패키지

//이벤트 프로그램 작성 방법
//1. 컴퍼넌트 또는 컨테이너 관련 클래스를 이용하여 디자인 클래스 작성
// => Frame 클래스를 상속받아 작성
// => 컴퍼넌트 또는 컨테이너에서는 다양한 이벤트 발생 - 이벤트 소스(Event Source)
//2. 이벤트 소스에서 발생된 이벤트를 처리하기 위한 이벤트 핸들러 클래스 작성
// => 컴퍼넌트에서 발생된 이벤트를 처리하기 위한 기능을 제공하는 클래스
// => XXXEvent를 처리하기 위한 XXXListener 인터페이스를 상속받아 클래스 작성
// => Listener 인터페이스 : 이벤트를 처리하기 위한 추상메소드가 선언된 인터페이스
// => 추상 메소드를 오버라이드 선언하여 이벤트 처리 명령을 작성
//3. 이벤트 소스에서 이벤트가 발생될 경우 이벤트 핸들러 클래스가 동작되도록 이벤트 등록
// => Component.addXXXListener(Listener l) : 컴퍼넌트에서 이벤트가 발생될 경우 이벤트 핸들러
//클래스로 생성된 인스턴스를 전달받아 이벤트 처리되도록 등록하는 메소드
// => 이벤트 핸들러 메소드는 자동 호출되어 이벤트 처리

//디자인 클래스와 이벤트 해들러 클래스를 따로 선언한 경우
// => 이벤트 핸들러 메소드에서 디자인 클래스의 컴퍼넌트 또는 컨테이너 제어 불가능
public class EventHandlerApp extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventHandlerApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		//Button 컴퍼넌트를 사용자가 누른 경우 ActionEvent 발생
		// => XXXEvent : 이벤트 정보를 저장하기 위한 클래스
		Button button=new Button("프로그램 종료");
		add(button);
		
		//시스템(OS :운영체제)이 컴퍼넌트(컨테이너)의 이벤트를 감시하고 이벤트가 발생된 경우
		//이벤트 핸들러 클래스로 인스턴스를 생성하여 이벤트 핸들러 메소드 호출하여 이벤트 처리
		button.addActionListener(new ActionEventHandler());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandlerApp("EventHandle");
	}//end of main

}//end of class

//이벤트 핸들러 클래스는 Listener 인터페이스를 상속받아 작성
// => ActionEvent를 처리하기 위해서는 ActionListener 인터페이스를 상속받아 작성
class ActionEventHandler implements ActionListener {
	//ActionEvent가 발생된 경우 자동 호출되는 이벤트 핸들러 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트 처리 명령 작성
		System.exit(0);
		
	}
	
}