package xyz.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame 컨테이너에서는 기본적으로 WindowEvent 발생
// => WindowListener 인터페이스를 상속받은 이벤트 핸들러 클래스를 작성하여 이벤트 처리
public class WindowListenerApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public WindowListenerApp(String title) {
		super(title);
		
		//Frame 인스턴스에서 발생되는 WindowEvent를 처리하기 위한 이벤트 핸들러 등록
		addWindowListener(new WindowEventHandler());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("WindowEvent");
	}

	//WindowListener 인터페이스는 7개의 이벤트 핸들러 메소드가 추상 메소드로 선언
	// => 자식 클래스에서는 모든 추상 메소드를 오버라이드 선언
	// => 불필요한 이벤트 핸들러 메소드도 오버라이드 선언
	public class WindowEventHandler implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
			//System.out.println("windowOpened() 메소드 호출");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			//System.out.println("windowClosing() 메소드 호출");
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			//System.out.println("windowClosed() 메소드 호출");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			//System.out.println("windowIconified() 메소드 호출");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			//System.out.println("windowDeiconified() 메소드 호출");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			//System.out.println("windowActivated() 메소드 호출");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			//System.out.println("windowDeactivated() 메소드 호출");
		}
	}
}