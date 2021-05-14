package xyz.itwill.thread;

public class PriorityApp {
	public static void main(String[] args) {
		PriorityOne one=new PriorityOne();
		PriorityTwo two=new PriorityTwo();
		
		one.setPriority(Thread.MIN_PRIORITY);
		two.setPriority(Thread.MAX_PRIORITY);
		
		one.start();
		two.start();
	}
}
