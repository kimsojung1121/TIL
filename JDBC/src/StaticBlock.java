package xyz.itwill.jdbc;

public class StaticBlock {
/*��������(Static Block) : ClassLoader ���α׷��� ���� Ŭ������ �޸𸮿� ����� ��, 
  �ڵ����� ����� ����� �ۼ��ϴ� ���� - ���������� ����� ���α׷����� �� ���� ���� */
	static {		
		System.out.println("### StaticBlock Ŭ������ ���������� �ۼ��� ��� ���� ###");
		
		StaticBlock sb=new StaticBlock();
		sb.display();
	}
	
//������
	public StaticBlock() {
		// TODO Auto-generated constructor stub
		System.out.println("### StaticBlock Ŭ������ ������ ȣ�� - �ν��Ͻ� ���� ###");
	}
	
//display()	
	public void display() {
		System.out.println("### StaticBlock Ŭ������ display() �޼ҵ� ȣ�� ###");		
	}
}
