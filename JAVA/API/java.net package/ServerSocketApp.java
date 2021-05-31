package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;

//ServerSocket : TCP ����� ��Ʈ��ũ ���α׷����� ������ �����ϱ� ���� Ŭ����
// => Ŭ���̾�Ʈ�� �����ϱ� ���� Ư�� Port�� Ȱ��ȭ�Ͽ� �ν��Ͻ� ����
// => Ŭ���̾�Ʈ�� ������ ���ӵ� �� ����� Ŭ���̾�Ʈ�� ����Ÿ ���� ����

//����(Server) : �ٸ� ��ǻ�Ͱ� ������ �� �ִ� ȯ���� �����ϴ� ��ǻ��(�ý���)
//Ŭ���̾�Ʈ(Client) : ������ �����ϴ� ��ǻ��(�ý���)

//ServerSocket Ŭ������ ��� ������ Port ��ȣ�� �˻��ϴ� ���α׷�
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=2000;i<=9000;i+=1000) {
			try {
				//ServerSocket(int port) : Ư�� Port ��ȣ�� ���޹޾� ServerSocket �ν��Ͻ��� �����ϴ� ������
				// => ���޵� Port ��ȣ�� �ٸ� ��Ʈ��ũ ���α׷����� ������� ��� IOException �߻�
				ServerSocket serverSocket=new ServerSocket(i);
				
				System.out.println("[�޼���]"+i+"�� Port�� ��� �����մϴ�.");
				
				//ServerSocket.close() : ���� ����� �����ϴ� �޼ҵ�
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("[����]"+i+"�� Port�� �̹� ��� ���Դϴ�.");				
			}
		}
	}//end of main
}//end of class
