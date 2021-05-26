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
	
	//��� �̹����� �̵� ������ �����ϱ� ���� �ʵ�
	// => 0 : ����(�⺻), 1 : ���� ����, 2 : ������ ����
	private int direction; 
	
	//���� ���¸� �����ϱ� ���� �ʵ�
	// => false : ���� ���� ����, true : ���� ���� ����(�⺻)
	private boolean isRun;

	//��� ���¸� �����ϱ� ���� �ʵ�
	// => false : ���� ����, true : ���� ����(�⺻)
	private boolean isPenguinAlive;
	
	//������ �̹����� ũ�⸦ ǥ���ϱ� ���� ��� 
	private static final int STONE_SIZE=30;
	
	//������ �̹��� ������ �����ϱ� ���� �ʵ�
	private Image stoneImage;
	
	//�ټ��� ������ ����(Stone)�� �����ϱ� ���� �ݷ��� �ʵ�
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
	
	//���� ���� ���� �ʱ�ȭ �۾� �޼ҵ� - �ʵ� �ʱ�ȭ
	// => ���� ���� ���� �Ǵ� ����� �� ��� ȣ��
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
		
		g.setFont(new Font("����", Font.BOLD, 50));
		g.setColor(Color.RED);
		
		if(isPenguinAlive) {
			g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
			
			//�ݷ��� �ʵ忡 ����� ��� �����̸� ��ȯ�޾� ���
			synchronized (stoneSet) {
				for(Stone stone:stoneSet) {	
					g.drawImage(stoneImage, stone.stoneX, stone.stoneY, STONE_SIZE, STONE_SIZE, this);
				}
			}

			if(!isRun) {
				g.drawString("�Ͻ� ����", 200, 200);
			}
		} else {
			g.drawString("GAME OVER", 150, 200);
			g.drawString("�ٽ�(F5)", 200, 300);
		}
	}
	
	//��� �̹����� �����̴� ����� �����ϱ� ���� ������ Ŭ����
	public class PenguinAnimationThread extends Thread {
		@Override
		public void run() {
			//�ݺ����� ����Ǹ� ������ �Ҹ�
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
				//���ӻ��¸� �ݴ�� �����Ͽ� �����ϴ� ��� - ���(Toggle)
				isRun=!isRun;
				if(!isRun) repaint();
				break;
				
			case KeyEvent.VK_F5:
				if(!isPenguinAlive) init();//���� ������� ���� �ʱ�ȭ �۾� �޼ҵ� ȣ��
				break;
			}
		}
	}
	
	//������ ������ �����ϱ� ���� Ŭ����
	// => ������ �̹����� �����̴� ����� �����ϱ� ���� ������ Ŭ����
	public class Stone extends Thread {
		//������ ��� ��ǥ���� �����ϱ� ���� �ʵ�
		private int stoneX, stoneY;
		
		//������ ���� ������ �����ϱ� ���� �ʵ�
		// => false : �Ҹ� ����, true : ���� ����(�⺻)
		private boolean isStoneAlive;
		
		//������ ���� �ӵ��� �����ϱ� ���� �ʵ�
		private int stoneSpeed;
		
		public Stone() {
			stoneX=new Random().nextInt(JFRAME_WIDTH-STONE_SIZE);
			stoneY=0;
			isStoneAlive=true;
			stoneSpeed=30;
			
			//������ Ŭ������ �ν��Ͻ��� �����ϸ� �ڵ����� ���ο� �����带 ����� run() �޼ҵ��� ��� ����
			start();
		}
		
		@Override
		public void run() {
			//�ݺ����� ����Ǹ� ������ �Ҹ�
			while(isPenguinAlive && isStoneAlive) {
				if(isRun) {
					stoneY+=5;
					
					//�����̰� �ٴڿ� ������ ���
					// => �ݷ��� �ʵ忡 ����� ������ ���� ����
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
	
	//������(Stone �ν��Ͻ�)�� �����Ͽ� �ݷ��� �ʵ忡 �����ϴ� ������ Ŭ����
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













