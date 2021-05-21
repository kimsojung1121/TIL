package xyz.itwill.awt;

import java.awt.Frame;

//���۳�Ʈ(Component) : GUI ���α׷��� ������ ��Ҹ� ������ Ŭ����
// => Button, Label, Canvas, List, Checkbox, Choice, Scrollbar, TextField, TextArea ��
//�����̳�(Container) : ���۳�Ʈ�� ���� �� �ִ� ���۳�Ʈ
// => Frame, Window, Dialog, Panel, ScrollPane ��
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame : �޴��� �ִ� â�� ����� ���� �����̳�
		//Frame f=new Frame();//������ ���� ������ ����
		Frame f=new Frame("������");//������ �ִ� ������ ����
		
		//Frame.setTitle(String title) : �������� ������ �����ϴ� �޼ҵ�
		//f.setTitle("������");
		
		//Component.setSize(int width, int height) : ���۳�Ʈ�� ũ��(���� ����)�� �����ϴ� �޼ҵ�
		// => GUI ���α׷������� ��ġ �Ǵ� ũ�� ������ �ȼ� ���
		//�ȼ�(Pixel) : �ϳ��� ���� ����� �� �ִ� ��(Dot)
		//f.setSize(300, 400);
		
		//Component.setLocation(int x, int y) : ���۳�Ʈ�� �����ġ(x ��ǥ�� y��ǥ)�� �����ϴ� �޼ҵ�
		//f.setLocation(600, 100);
		
		//Component.setBounds(int x, int y, int width, int height) : ���۳�Ʈ��
		//�����ġ�� ũ�⸦ �����ϴ� �޼ҵ�
		f.setBounds(600, 100, 300, 400);
		
		//Frame.setResizable(boolean b) : �������� ũ�� ���� ���θ� �����ϴ� �޼ҵ�
		// => false : ũ�� ���� �Ұ���, true : ũ�� ���� ����(�⺻)
		f.setResizable(false);
		
		//Component.setVisible(boolean b) : ���۳�Ʈ�� ȭ�� ��� ���θ� �����ϴ� �޼ҵ�
		// => false : �����(�⺻), true : ���
		// => �����̳ʿ� ���� ������ �����̳ʿ� ������ ���۳�Ʈ�� ����
		f.setVisible(true);
	}
}
