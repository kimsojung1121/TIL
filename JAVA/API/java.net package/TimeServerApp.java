package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속 클라이언트에게 서버 컴퓨터의 날짜와 시간 정보를 전달하는 서버 프로그램
// => NTP(Network Time Protocol) Server : 날짜와 시간정보를 제공하는 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket 인스턴스 생성 - 서버 동작
			ntpServer=new ServerSocket(3000);
			System.out.println("[메세지]NTP Server Running...");
			
			//서버 프로그램은 다수의 클라이언트 접속을 허용하기 위해 무한루프를 이용하여 처리
			while(true) {
				//ServerSocket.accept() : 클라이어트의 접속을 기다리는 메소드
				// => 클라이언트 접속 전까지 스레드 일시 중지
				// => 클라이언트가 접속되면 클라이언트의 소켓과 연결될 Socket 인스턴스를 생성하여 반환하고 스레드 실행
				// => 현재 접속중인 클라이언트의 수만큼 Socket 인스턴스 생성
				Socket socket=ntpServer.accept();
				
				/*
				//Socket.getOutputStream() : Socket 인스턴스의 출력스트림(OutputStream 인스턴스)를 반환하는 메소드
				// => 접속된 원격 컴퓨터에 원시 데이타를 전달하는 출력 스트림
				OutputStream out=socket.getOutputStream();
				
				//Socket 인스턴스의 출력 스트림을 전달받아 객체를 전달할 수 있는 출력 스트림(ObjectOutputStream 인스턴스)로 확장
				ObjectOutputStream stream=new ObjectOutputStream(out);
				
				//클라이언트에게 전달할 날짜와 시간정보가 저장된 Date 인스턴스 생성
				Date date=new Date();
				
				//시스템의 날짜와 시간정보가 저장된 Date 인스턴스를 출력 스트림으로 전달
				// => 클라이언트에게 Date 인스턴스 전달
				stream.writeObject(date);
				*/
				
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그(Log) 출력
				System.out.println("[로그]클라이언트["+socket.getInetAddress().getHostAddress()+"]에게 날짜와 시간정보를 제공하였습니다.");
				
				//소켓 제거 - 접속 종료
				socket.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[에러]서버에 네트워크 문제가 발생하였습니다.");
		}
	}//end of main
}//end of class
