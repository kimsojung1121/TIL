package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//���� Ŭ���̾�Ʈ�� ������ �޼����� ���޹޾� ����ϴ� ���� ���α׷�
public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer=null;
		
		try {
			echoServer=new ServerSocket(4000);
			System.out.println("[�޼���]NTP Server Running...");
			
			while(true) {
				Socket socket=echoServer.accept();
				
				//������ �Է� ��Ʈ���� ��ȯ�޾� ���ڿ��� �Է¹��� �� �ֵ��� Ȯ��
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
				//Ŭ���̾�Ʈ�� ������ �޼����� �о� ȭ�鿡 ���
				// => Ŭ���̾�Ʈ���� �޼����� ������ ������ ������ �Ͻ� ����
				System.out.println("["+socket.getInetAddress().getHostAddress()+"]���� ������ �޼��� = "+in.readLine());
			
				socket.close();
			}
					
		} catch (IOException e) {
			System.out.println("[����]������ ��Ʈ��ũ ������ �߻��Ͽ����ϴ�.");
		}
	}//end of main
}//end of class
