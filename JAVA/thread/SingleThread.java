package xyz.itwill.thread;

public class SingleThread {
	public void display() {
		System.out.println("SigleThread Ŭ������ display() �޼ҵ� ����");
		
		System.out.println("["+Thread.currentThread().getName()+"] "
				+ "�����忡 ���� display() �޼ҵ��� ��� ����");
		
		System.out.println("SigleThread Ŭ������ display() �޼ҵ� ����");
	}
}//end of class