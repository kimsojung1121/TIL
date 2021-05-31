package xyz.itwill.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Socket : TCP ����� ��Ʈ��ũ ���α׷����� Ŭ���̾�Ʈ�� �����ϱ� ���� Ŭ����(Socket ���?)
// => ������ �����Ͽ� ���� �����ϰų� ���޹��� �� �ִ� �ν��Ͻ��� �����ϱ� ���� Ŭ����
public class SocketApp {
	public static void main(String[] args) {
		try {
			//Socket(String host, int port) : Server ��ǻ���� �̸�(�Ǵ� IP �ּ�)�� Ȱ��ȭ�� Port ��ȣ�� ���޹޾� �ν��Ͻ��� �����ϴ� ������
			// => Socket ���� - ����(Server) ����
			// => UnknownHostException�� IOException �߻�
			Socket socket=new Socket("www.daum.net", 80);
			
			//Socket.toString() : Socket �ν��Ͻ��� ����� ���������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			System.out.println("socket = "+socket);
			
			//Socket.getInetAddress() : ���ӵ� ���� ��ǻ���� ��Ʈ��ũ ����(InetAddress �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Remote IP Address = "+socket.getInetAddress().getHostAddress());
			
			//Socket.getPort() : ���ӵ� ���� ��ǻ���� Port ��ȣ�� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Remote Port Number = "+socket.getPort());
			
			//Socket.getLocalAddress() : ���ӵ� ���� ��ǻ���� ��Ʈ��ũ ����(InetAddress �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Local IP Address = "+socket.getLocalAddress().getHostAddress());
			
			//Socket.getLocalPort() : ���ӵ� ���� ��ǻ���� Port ��ȣ�� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Local Port Number = "+socket.getLocalPort());
			
			//Socket.close() : ������ �����ϴ� �޼ҵ� - ���� ����
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[����]���� ��ǻ�͸� ã�� �� �����ϴ�.");
		} catch (IOException e) {
			//���� ���α׷��� ���������� ������ �� ���� ��� IOException �߻�
			System.out.println("[����]������ ������ �� �����ϴ�.");			
		}
	}//end of main
}//end of class
