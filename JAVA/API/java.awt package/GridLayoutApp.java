package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

//GridLayout : 컴퍼넌트를 행과 열을 이용하여 배치하는 배치 관리자 클래스
// => 행을 우선으로 컴퍼넌트 배치
public class GridLayoutApp extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GridLayoutApp(String title) {
		super(title);
		
		//프레임의 배치 관리자를 GridLayout으로 변경
		// => GridLayout 인스턴스는 행과 열을 설정하는 생성자로 인스턴스 생성
		setLayout(new GridLayout(3, 2));//3행 2열
		
		Button button1=new Button("버튼-1");
		Button button2=new Button("버튼-2");
		Button button3=new Button("버튼-3");
		Button button4=new Button("버튼-4");
		Button button5=new Button("버튼-5");
		Button button6=new Button("버튼-6");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);

		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutApp("GridLayoutApp");
	}//end of main
}//end of class
