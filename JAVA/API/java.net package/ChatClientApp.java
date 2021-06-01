package xyz.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//채팅 클라이언트 프로그램 - Swing
// => 서버에서 보내온 메세지를 전달받아 컴퍼넌트 출력 - 반복 처리
// => 컴퍼넌트로 메세지를 입력받아 서버에 전달 - 이벤트 핸들러 메소드
public class ChatClientApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField field;//입력 컴퍼넌트
	private JTextArea area;//출력 컴퍼넌트
	
	//서버의 소켓과 연결될 소켓정보를 저장하기 위한 필드
	private Socket socket;
	
	//서버에서 보내온 메세지를 전달받을 입력 스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	//서버에게 메세지를 전달할 출력 스트림을 저장하기 위한 필드
	private PrintWriter out;
	
	//대화명을 저장하기 위한 필드
	private String aliasName;
	
	public ChatClientApp(String title) {
		super(title);
		
		field=new JTextField();
		area=new JTextArea();
		
		JScrollPane pane=new JScrollPane(area);
		
		getContentPane().add(pane, BorderLayout.CENTER);
		getContentPane().add(field, BorderLayout.SOUTH);
		
		field.setFont(new Font("굴림", Font.BOLD, 20));
		area.setFont(new Font("굴림", Font.BOLD, 20));
		area.setFocusable(false);
		
		field.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 400, 500);
		setVisible(true);
		
		try {
			//socket=new Socket("192.168.13.31", 6000);
			socket=new Socket("www.itwill.xyz", 6000);
			
			//소켓의 입력 스트림을 제공받아 문자열로 읽을 수 있는 스트림으로 확장하여 필드에 저장
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//소켓의 출력 스트림을 제공받아 문자열로 전달 할 수 있는 스트림으로 확장하여 필드에 저장
			out=new PrintWriter(socket.getOutputStream(),true);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버에 접속할 수 없습니다."
					,"접속오류",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//대화명을 입력받아 필드에 저장 - 정상적인 대화명이 입력되도록 반복 처리
		while(true) {
			//입력 다이얼로그를 사용하여 대화명을 입력받아 저장
			aliasName=JOptionPane.showInputDialog(this, "대화명을 입력해 주세요."
					,"대화명 입력", JOptionPane.QUESTION_MESSAGE);
			
			//정상적인 대화명이 입력된 경우 반복문 종료
			if(aliasName!=null && !aliasName.equals("")) break;
			
			JOptionPane.showMessageDialog(this, "대화명을 반드시 입력해 주세요."
					,"입력오류",JOptionPane.ERROR_MESSAGE);
		}
		
		//입력받은 대화명을 서버에 전달
		out.println(aliasName);
		
		//서버에서 보내온 메세지를 전달받아 JTextArea 컴퍼넌트에 출력 - 반복 처리
		while(true) {
			try {
				area.append(in.readLine()+"\n");
				
				//JTextArea 컴퍼넌트의 스크롤을 맨 아래로 이동 
				area.setCaretPosition(area.getText().length());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "서버와의 연결이 끊어졌습니다."
						,"접속오류",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("채팅 프로그램");
	}

	//이벤트 핸들러 메소드
	// => JTextField 컴퍼넌트로 입력된 메세지를 얻어와 서버에 전달하는 기능 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		//JTextField 컴퍼넌트의 입력된 메세지를 반환받아 저장
		String message=field.getText();
		
		if(!message.equals("")) {//입력 메세지가 존재할 경우
			out.println(message);//서버에 메세지 전달
			field.setText("");//JTextField 컴퍼넌트 초기화
		}
	}
}







