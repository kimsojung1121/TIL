package xyz.itwill.thread;

//���α׷� ����� JVM�� main() �޼ҵ带 ȣ���ϱ� ���� �ڵ����� main ������ ����
// => main �����常 �̿��Ͽ� ���α׷� �ۼ� : ���� ������ ���α׷�
// => main() �޼ҵ尡 ����Ǹ� main �����尡 �ڵ� �Ҹ� - ���α׷� ����
public class SigleThreadApp {
	public static void main(String[] args) {
		System.out.println("SigleThreadApp Ŭ������ main() �޼ҵ� ����");	
		
		//Thread.currentThread() : ���� ����� �����ϴ� Thread �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Thread.getName() : Thread �ν��Ͻ��� �̸�(������)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("["+Thread.currentThread().getName()+"] "
				+ "�����忡 ���� main() �޼ҵ��� ��� ����");
		
		//�ν��Ͻ� �޼ҵ� ȣ���ϸ� �����尡 �̵��Ǿ� �޼ҵ��� ��� ����
		// => ȣ�� �޼ҵ尡 ���� �� ������ ����(return)
		new SingleThread().display();
		
		System.out.println("SigleThreadApp Ŭ������ main() �޼ҵ� ����");
	}//end of main
}//end of class