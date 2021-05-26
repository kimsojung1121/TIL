package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//날짜와 시간을 출력하는 GUI 프로그램
public class DigitalClockApp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//날짜와 시간을 출력하기 위한 컴퍼넌트
	private JLabel clockLabel;
	
	//스레드를 일시 중지하거나 다시 실행하기 위한 컴퍼넌트
	private JButton startBtn, stopBtn;
	
	//날짜와 시간정보를 변경하는 스레드의 실행 상태를 저장하기 위한 필드
	// => false : 스레드 중지 상태, true: 스레드 동작 상태(기본)
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		isRun=true;
	
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림", Font.BOLD, 30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		startBtn=new JButton("다시 실행");
		stopBtn=new JButton("일시 중지");
		JPanel panel=new JPanel();
		panel.add(startBtn);
		panel.add(stopBtn);
		startBtn.setFont(new Font("굴림", Font.BOLD, 20));
		stopBtn.setFont(new Font("굴림", Font.BOLD, 20));
		startBtn.setEnabled(false);
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		//새로운 스레드를 생성하여 run() 메소드의 명령 실행
		new ClockThread().start();
		
		//버튼을 누른 경우 이벤트 핸들러 클래스의 메소드가 호출되도록 이벤트 핸들러 등록
		startBtn.addActionListener(new ButtonEventHandler());
		stopBtn.addActionListener(new ButtonEventHandler());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 600, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("DigitalClock");
	}
	
	//시스템의 현재 날짜와 시간 정보를 얻어와 컴퍼넌트를 변경하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 mm월 dd일 hh시 mm분 ss초");
			
			while(true) {
				if(isRun) {
//					Date now=new Date();
//					String clock=dateFormat.format(now);
					clockLabel.setText(dateFormat.format(new Date()));
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//버튼을 누른 경우 동작될 이벤트 핸들러 클래스
	public class ButtonEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object eventSource=e.getSource();
			
			if(eventSource==startBtn) {
				isRun=true;
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			}else if(eventSource==stopBtn) {
				isRun=false;
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
			}
		}
		
	}
}
