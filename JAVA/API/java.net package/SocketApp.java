package xyz.itwill.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Socket : TCP 기반의 네트워크 프로그램에서 클라이언트를 구현하기 위한 클래스(Socket 통신?)
// => 서버에 접속하여 값을 전달하거나 전달받을 수 있는 인스턴스를 생성하기 위한 클래스
public class SocketApp {
	public static void main(String[] args) {
		try {
			//Socket(String host, int port) : Server 컴퓨터의 이름(또는 IP 주소)과 활성화된 Port 번호를 전달받아 인스턴스를 생성하는 생성자
			// => Socket 생성 - 서버(Server) 접속
			// => UnknownHostException과 IOException 발생
			Socket socket=new Socket("www.daum.net", 80);
			
			//Socket.toString() : Socket 인스턴스에 저장된 소켓정보를 문자열로 변환하여 반환하는 메소드
			System.out.println("socket = "+socket);
			
			//Socket.getInetAddress() : 접속된 원격 컴퓨터의 네트워크 정보(InetAddress 인스턴스)를 반환하는 메소드
			System.out.println("Remote IP Address = "+socket.getInetAddress().getHostAddress());
			
			//Socket.getPort() : 접속된 원격 컴퓨터의 Port 번호를 반환하는 메소드
			System.out.println("Remote Port Number = "+socket.getPort());
			
			//Socket.getLocalAddress() : 접속된 로컬 컴퓨터의 네트워크 정보(InetAddress 인스턴스)를 반환하는 메소드
			System.out.println("Local IP Address = "+socket.getLocalAddress().getHostAddress());
			
			//Socket.getLocalPort() : 접속된 로컬 컴퓨터의 Port 번호를 반환하는 메소드
			System.out.println("Local Port Number = "+socket.getLocalPort());
			
			//Socket.close() : 접속을 제거하는 메소드 - 접속 종료
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[에러]서버 컴퓨터를 찾을 수 없습니다.");
		} catch (IOException e) {
			//서버 프로그램이 정상적으로 접속할 수 없는 경우 IOException 발생
			System.out.println("[에러]서버에 접속할 수 없습니다.");			
		}
	}//end of main
}//end of class
