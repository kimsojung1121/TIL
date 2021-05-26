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

	//��� �̹����� �����ϱ� ���� �ʵ�
	//Image : �̹��� ������ �����ϱ� ���� Ŭ����
	private Image backgroundImage;
	
	//��� �̹����� �����ϱ� ���� �ʵ� - �迭
	private Image[] penguins;
	
	//��� �̹����� �����ϱ� ���� �ʵ� - �迭 ÷��
	private int penguinNo;
	
	//��� �̹����� ��µ� ��ǥ���� �����ϱ� ���� �ʵ�
	private int penguinX, penguinY;
	
	public PenguinMoveApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//ImageIcon : �̹��� ������ ������ �����ϱ� ���� Ŭ����
		// => ImageIcon(URL location) : �̹��� ������ ��θ� ���޹޾� ImageIcon �ν��Ͻ��� �����ϴ� ������
		//URL : ���ҽ� ����(�׸� ����, ���� ����, ������ ���� ��) ��θ� �����ϱ� ���� Ŭ����
		//Object.getClass() : �޸𸮿� ����� ���� Ŭ���� ������ Class �ν��Ͻ�(Clazz)�� ��ȯ�ϴ� �޼ҵ�
		//Class.getResource(String name) : Ŭ������ �������� ���ҽ� ������ �о� URL �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
		//ImageIcon.getImage() : �̹��� ������ �̹��� ����(Image �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		backgroundImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
//		penguinNo=0;
		
		penguinX=JFRAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFRAME_HEIGHT-PENGUIN_SIZE;
		
		//�����ӿ��� Ű���� ���� �̺�Ʈ�� �߻��� ��� ó���� �̺�Ʈ �ڵ鷯 ���
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
	
	//Ű���� ���� �̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯 Ŭ����
	public class PenguinMoveHandle implements KeyListener {
		
		//Ű���带 ������ ����� �� ȣ��Ǵ� �޼ҵ�
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		//Ű���带 ������ �� ȣ��Ǵ� �޼ҵ�
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//KeyEvent.getKeyCode() : �̺�Ʈ�� �߻���Ų Ű������ �������� ��ȯ�ϴ� �޼ҵ�
			int keyCode=e.getKeyCode();
			//KeyEvent.getKeyCode() : �̺�Ʈ�� �߻���Ų Ű������ ���ڰ��� ��ȯ�ϴ� �޼ҵ�
//			int keyChar=e.getKeyChar();
			
//			System.out.println("keyCode = "+keyCode+", keyChar = "+keyChar);
			
			//�̺�Ʈ�� �߻��� Ű���带 �����Ͽ� �̺�Ʈ ó��
			switch(keyCode) {
			//���� ����Ű�� ���� ���
			case KeyEvent.VK_LEFT: 
				penguinX-=10;
				if(penguinX<=0) {
					penguinX=0;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			//������ ����Ű�� ���� ���
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

		//Ű���带 ����� �� ȣ��Ǵ� �޼ҵ�
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
