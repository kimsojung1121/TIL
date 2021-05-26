package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int JFRAME_WIDTH=616;
	private static final int JFRAME_HEIGHT=461;
	
	private static final int PENGUIN_SIZE=60;

	//배경 이미지를 저장하기 위한 필드
	//Image : 이미지 정보를 저장하기 위한 클래스
	private Image backgroundImage;
	
	//펭귄 이미지를 저장하기 위한 필드 - 배열
	private Image[] penguins;
	
	//펭귄 이미지를 선택하기 위한 필드 - 배열 첨자
	private int penguinNo;
	
	//펭귄 이미지가 출력된 좌표값을 저장하기 위한 필드
	private int penguinX, penguinY;
	
	public PenguinMoveApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//ImageIcon : 이미지 파일의 정보를 저장하기 위한 클래스
		// => ImageIcon(URL location) : 이미지 파일의 경로를 전달받아 ImageIcon 인스턴스를 생성하는 생성자
		//URL : 리소스 파일(그림 파일, 음향 파일, 동영상 파일 등) 경로를 저장하기 위한 클래스
		//Object.getClass() : 메모리에 저장된 현재 클래스 정보를 Class 인스턴스(Clazz)로 반환하는 메소드
		//Class.getResource(String name) : 클래스를 기준으로 리소스 파일을 읽어 URL 인스턴스로 반환하는 메소드 
		//ImageIcon.getImage() : 이미지 파일의 이미지 정보(Image 인스턴스)를 반환하는 메소드
		backgroundImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
//		penguinNo=0;
		
		penguinX=JFRAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFRAME_HEIGHT-PENGUIN_SIZE;
		
		//프레임에서 키보드 관련 이벤트가 발생될 경우 처리될 이벤트 핸들러 등록
		addKeyListener(new PenguinMoveHandle());
		
		setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("PenguinMove");
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		super.paint(g);
		
//		Graphics.drawImage(Image image, int x, int y, int width, int height, ImageObserver)
		g.drawImage(backgroundImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
		
	}
	
	//키보드 관련 이벤트를 처리하기 위한 이벤트 핸들러 클래스
	public class PenguinMoveHandle implements KeyListener {
		
		//키보드를 눌렀다 띄었을 때 호출되는 메소드
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		//키보드를 눌렀을 때 호출되는 메소드
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//KeyEvent.getKeyCode() : 이벤트를 발생시킨 키보드의 고유값을 반환하는 메소드
			int keyCode=e.getKeyCode();
			//KeyEvent.getKeyCode() : 이벤트를 발생시킨 키보드의 문자값을 반환하는 메소드
//			int keyChar=e.getKeyChar();
			
//			System.out.println("keyCode = "+keyCode+", keyChar = "+keyChar);
			
			//이벤트가 발생된 키보드를 구분하여 이벤트 처리
			switch(keyCode) {
			//왼쪽 방향키를 누른 경우
			case KeyEvent.VK_LEFT: 
				penguinX-=10;
				if(penguinX<=0) {
					penguinX=0;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			//오른쪽 방향키를 누른 경우
			case KeyEvent.VK_RIGHT: 
				penguinX+=10;
				if(penguinX>=JFRAME_WIDTH-PENGUIN_SIZE) {
					penguinX=JFRAME_WIDTH-PENGUIN_SIZE;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			}
		}

		//키보드를 띄었을 때 호출되는 메소드
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
