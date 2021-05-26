package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

//마우스 버튼을 클릭하면 클릭한 위치의 좌표값을 프레임에 문자열로 출력하는 프로그램
public class PaintApp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//마우스 버튼을 클릭한 위치의 좌표값을 저장하기 위한 필드
	private int x, y;
	
	
	public PaintApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//프레임에서 발생되는 MouseEvent를 처리하기 위한 이벤트 핸들러 등록
		// => MouseAdapter 클래스를 상속받은 Anonyoous Inner Class로 이벤트 핸들러 등록
		addMouseListener(new MouseAdapter() {
			//마우스 버튼을 누른 경우 호출되는 이벤트 핸들러 메소드를 오버라이드 선언
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//MouseEvent.getX() : 마우스 이벤트가 발생된 X 좌표값을 반환하는 메소드
				x=e.getX();

				//MouseEvent.getY() : 마우스 이벤트가 발생된 Y 좌표값을 반환하는 메소드
				y=e.getY();
				
				
				//Window.repaint() : paint() 메소드를 호출하는 메소드
				// => paint() 메소드를 직접 호출할 수 없을 때 사용하는 메소드
//				paint(getGraphics());
				repaint();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
	
	//JWindow.paint(Graphics g) : 컨테이너(JFrame, JWindow, JDialog 등)를 출력하는 메소드
	//paint() 메소드는 컨테이너 관련 이벤트가 발생될 경우 자동 호출
	// => 프로그램이 실행되어 컨테이너가 보여질 경우
	// => 프로그램이 아이콘에서 해제되어 컨테이너가 보여질 경우
	// => 컨테이너의 크기가 변경될 경우
	//Graphics : 컨테이너에 그림을 그리기 위한 기능을 제공하는 클래스
	// => paint() 메소드가 호출될 때 매개변수에 Graphics 인스턴스가 자동으로 저장
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		System.out.println("["+Thread.currentThread().getName()+"] 이름의 스레드에 의해 paint() 메소드의 명령 실행");
		
		//부모 클래스의 숨겨진 메소드 호출 - 컨테이너 초기화
		super.paint(g);
		
		/*
		g.setColor(Color.RED);
		g.drawRect(20, 40, 50, 50);
		g.fillRect(20, 100, 100, 50);
		
		g.setColor(Color.GREEN);
		g.drawOval(125, 175, 50, 50);
		g.fillOval(100, 250, 100, 50);
		
		g.setColor(Color.BLUE);
		g.drawLine(100, 320, 200, 320);
		g.drawString("홍길동", 100, 350);
		*/
		
		g.drawString("["+x+","+y+"]", x, y);
	}
}
