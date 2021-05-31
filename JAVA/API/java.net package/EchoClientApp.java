package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


//키보드로 메세지를 입력받아 서버에 접속하여 접속 서버에 전달하는 클라이언트 프로그램
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		try {
			//서버 접속
			Socket socket=new Socket("192.168.200.198", 4000);
			
			//소켓 출력 스트림을 반환받아 문자열을 전달할 수 있도록 확장
			/*
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
			out.write(message);
			out.flush();
			*/
			
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			out.println(message);
			out.flush();
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}//end of main
}//end of class
