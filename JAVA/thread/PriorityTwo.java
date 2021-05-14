package xyz.itwill.thread;

public class PriorityTwo extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("B");
		}
	}
}
