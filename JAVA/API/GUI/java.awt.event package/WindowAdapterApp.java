package xyz.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame 컨테이너에서는 기본적으로 WindowEvent 발생
// => WindowAdapter 클래스를 상속받은 이벤트 핸들러 클래스를 작성하여 이벤트 처리
//XXXAdapter : 이벤트를 처리하기 위한 기능을 제공하는 클래스
// => Listener 인터페이스의 추상 메소드가 2개 이상인 경우 Adapter 클래스 제공
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowEventHandler());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("WindowEvent");
	}
	
	//Adapter 클래스를 상속받은 이벤트 핸들러 클래스
	// => 필요한 이벤트 핸들러 메소드만 오버라이스 선언하여 이벤트 처리
	public class WindowEventHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
