package xyz.itwill.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinGameApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int JFRAME_WIDTH=616;
	private static final int JFRAME_HEIGHT=461;
	private static final int PENGUIN_SIZE=60;
	
	private Image backgroundImage;
	private Image[] penguins;
	
	private int penguinNo;
	private int penguinX, penguinY;
	
	//펭귄 이미지의 이동 방향을 저장하기 위한 필드
	// => 0 : 멈춤(기본), 1 : 왼쪽 방향, 2 : 오른쪽 방향
	private int direction; 
	
	//게임 상태를 저장하기 위한 필드
	// => false : 게임 중지 상태, true : 게임 진행 상태(기본)
	private boolean isRun;

	//펭귄 상태를 저장하기 위한 필드
	// => false : 죽음 상태, true : 생존 상태(기본)
	private boolean isPenguinAlive;
	
	//돌멩이 이미지의 크기를 표현하기 위한 상수 
	private static final int STONE_SIZE=30;
	
	//돌멩이 이미지 정보를 저장하기 위한 필드
	private Image stoneImage;
	
	//다수의 돌멩이 정보(Stone)를 저장하기 위한 콜렉션 필드
	private Set<Stone> stoneSet;
	
	public PenguinGameApp(String title) {
		super(title);

		backgroundImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
		stoneImage=new ImageIcon(getClass().getResource("/images/stone.gif")).getImage();
	
		stoneSet=new HashSet<Stone>();
		
		init();
		
		addKeyListener(new KeyEventHandle());
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
	}
	
	//게임 실행 관련 초기화 작업 메소드 - 필드 초기화
	// => 게임 최초 실행 또는 재실행 할 경우 호출
	private void init() {
		penguinNo=0;
		penguinX=JFRAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFRAME_HEIGHT-PENGUIN_SIZE;
		
		direction=0;
		
		isRun=true;
		isPenguinAlive=true;
		
		new PenguinAnimationThread().start();
		new CreateStoneThread().start();
	}
	
	public static void main(String[] args) {
		new PenguinGameApp("PenguinGame");
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.setFont(new Font("굴림", Font.BOLD, 50));
		g.setColor(Color.RED);
		
		if(isPenguinAlive) {
			g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
			
			//콜렉션 필드에 저장된 모든 돌멩이를 반환받아 출력
			synchronized (stoneSet) {
				for(Stone stone:stoneSet) {	
					g.drawImage(stoneImage, stone.stoneX, stone.stoneY, STONE_SIZE, STONE_SIZE, this);
				}
			}

			if(!isRun) {
				g.drawString("일시 중지", 200, 200);
			}
		} else {
			g.drawString("GAME OVER", 150, 200);
			g.drawString("다시(F5)", 200, 300);
		}
	}
	
	//펭귄 이미지를 움직이는 기능을 제공하기 위한 스레드 클래스
	public class PenguinAnimationThread extends Thread {
		@Override
		public void run() {
			//반복문이 종료되면 스레드 소멸
			while(isPenguinAlive) {
				if(isRun) {
					switch (direction) {
					case 1: 
						penguinX-=5;
						if(penguinX<=0) {
							penguinX=0;
						}
						break;
				
					case 2: 
						penguinX+=5;
						if(penguinX>=JFRAME_WIDTH-PENGUIN_SIZE) {
							penguinX=JFRAME_WIDTH-PENGUIN_SIZE;
						}
						break;
					}
					penguinNo++;
					penguinNo%=3;
					repaint();		
				}
				
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public class KeyEventHandle extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode=e.getKeyCode();

			switch (keyCode) {
			case KeyEvent.VK_DOWN: 
				direction=0;
				break;
			
			case KeyEvent.VK_LEFT: 
				direction=1;
				break;
				
			case KeyEvent.VK_RIGHT: 
				direction=2;
				break;
				
			case KeyEvent.VK_P:
				//게임상태를 반대로 변경하여 저장하는 기능 - 토글(Toggle)
				isRun=!isRun;
				if(!isRun) repaint();
				break;
				
			case KeyEvent.VK_F5:
				if(!isPenguinAlive) init();//게임 재실행을 위한 초기화 작업 메소드 호출
				break;
			}
		}
	}
	
	//돌멩이 정보를 저장하기 위한 클래스
	// => 돌멩이 이미지를 움직이는 기능을 제공하기 위한 스레드 클래스
	public class Stone extends Thread {
		//돌멩이 출력 좌표값을 저장하기 위한 필드
		private int stoneX, stoneY;
		
		//돌멩이 상태 정보를 저장하기 위한 필드
		// => false : 소멸 상태, true : 존재 상태(기본)
		private boolean isStoneAlive;
		
		//돌멩이 낙하 속도를 저장하기 위한 필드
		private int stoneSpeed;
		
		public Stone() {
			stoneX=new Random().nextInt(JFRAME_WIDTH-STONE_SIZE);
			stoneY=0;
			isStoneAlive=true;
			stoneSpeed=30;
			
			//스레드 클래스로 인스턴스를 생성하면 자동으로 새로운 스레드를 만들어 run() 메소드의 명령 실행
			start();
		}
		
		@Override
		public void run() {
			//반복문이 종료되면 스레드 소멸
			while(isPenguinAlive && isStoneAlive) {
				if(isRun) {
					stoneY+=5;
					
					//돌멩이가 바닥에 떨어진 경우
					// => 콜렉션 필드에 저장된 돌멩이 정보 제거
					if(stoneY>=JFRAME_HEIGHT-STONE_SIZE) {
						isStoneAlive=false;
						synchronized (stoneSet) {
							stoneSet.remove(this);
						}
					}
				}
				
				try {
					Thread.sleep(stoneSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//돌멩이(Stone 인스턴스)를 생성하여 콜렉션 필드에 저장하는 스레드 클래스
	public class CreateStoneThread extends Thread {
		@Override
		public void run() {
			while(isPenguinAlive) {
				if(isRun) {
					synchronized (stoneSet) {
						stoneSet.add(new Stone());
					}
				}
			
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}













