package xyz.itwill.thread;

public class SingleThread {
	public void display() {
		System.out.println("SigleThread 클래스의 display() 메소드 시작");
		
		System.out.println("["+Thread.currentThread().getName()+"] "
				+ "스레드에 의해 display() 메소드의 명령 실행");
		
		System.out.println("SigleThread 클래스의 display() 메소드 시작");
	}
}//end of class