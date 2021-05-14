package xyz.itwill.thread;

public class MultiThreadTwo implements Runnable {

	@Override
	public void run() {
		//소문자 A부터 Z까지 출력
		for(char i='a';i<='z';i++) {
			System.out.print(i);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
