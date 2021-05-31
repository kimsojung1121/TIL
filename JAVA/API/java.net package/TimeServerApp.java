package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//���� Ŭ���̾�Ʈ���� ���� ��ǻ���� ��¥�� �ð� ������ �����ϴ� ���� ���α׷�
// => NTP(Network Time Protocol) Server : ��¥�� �ð������� �����ϴ� ��ǻ��
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket �ν��Ͻ� ���� - ���� ����
			ntpServer=new ServerSocket(3000);
			System.out.println("[�޼���]NTP Server Running...");
			
			//���� ���α׷��� �ټ��� Ŭ���̾�Ʈ ������ ����ϱ� ���� ���ѷ����� �̿��Ͽ� ó��
			while(true) {
				//ServerSocket.accept() : Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
				// => Ŭ���̾�Ʈ ���� ������ ������ �Ͻ� ����
				// => Ŭ���̾�Ʈ�� ���ӵǸ� Ŭ���̾�Ʈ�� ���ϰ� ����� Socket �ν��Ͻ��� �����Ͽ� ��ȯ�ϰ� ������ ����
				// => ���� �������� Ŭ���̾�Ʈ�� ����ŭ Socket �ν��Ͻ� ����
				Socket socket=ntpServer.accept();
				
				/*
				//Socket.getOutputStream() : Socket �ν��Ͻ��� ��½�Ʈ��(OutputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
				// => ���ӵ� ���� ��ǻ�Ϳ� ���� ����Ÿ�� �����ϴ� ��� ��Ʈ��
				OutputStream out=socket.getOutputStream();
				
				//Socket �ν��Ͻ��� ��� ��Ʈ���� ���޹޾� ��ü�� ������ �� �ִ� ��� ��Ʈ��(ObjectOutputStream �ν��Ͻ�)�� Ȯ��
				ObjectOutputStream stream=new ObjectOutputStream(out);
				
				//Ŭ���̾�Ʈ���� ������ ��¥�� �ð������� ����� Date �ν��Ͻ� ����
				Date date=new Date();
				
				//�ý����� ��¥�� �ð������� ����� Date �ν��Ͻ��� ��� ��Ʈ������ ����
				// => Ŭ���̾�Ʈ���� Date �ν��Ͻ� ����
				stream.writeObject(date);
				*/
				
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//�α�(Log) ���
				System.out.println("[�α�]Ŭ���̾�Ʈ["+socket.getInetAddress().getHostAddress()+"]���� ��¥�� �ð������� �����Ͽ����ϴ�.");
				
				//���� ���� - ���� ����
				socket.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[����]������ ��Ʈ��ũ ������ �߻��Ͽ����ϴ�.");
		}
	}//end of main
}//end of class
