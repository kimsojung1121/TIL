package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//ä�� ���� ���α׷� - ���� ������
// => Ŭ���̾�Ʈ�� ������ �޼����� ���޹޾� ���ӵ� ��� Ŭ���̾�Ʈ���� �����ϴ� ���
// => Ŭ���̾�Ʈ�� ����� ������ ���ο� �����带 �����Ͽ� ���������� ���۵ǵ��� ����
public class ChatServerApp {
	//���� Ŭ���̾�Ʈ�� ���ϰ� ����� ��� ���������� �����ϱ� ���� �ݷ��� �ʵ�
	private List<SocketThread> clientList; 
	
	public ChatServerApp() {
		ServerSocket chatServer=null;
		
		try {
			chatServer=new ServerSocket(6000);
			System.out.println("[�޼���]ä�� ���� ���� ��...");
			
			clientList=new ArrayList<SocketThread>();
			
			while(true) {
				try {
					Socket client=chatServer.accept();
					
					System.out.println("[���ӷα�]"+client.getInetAddress().getHostAddress()
							+"�� ��ǻ�Ϳ��� ���� �Ͽ����ϴ�.");
					
					//Ŭ���̾�Ʈ�� ���ϰ� ����� ���������� ������ SocketThread �ν��Ͻ� ����
					SocketThread socketThread=new SocketThread(client);
					
					//�ݷ��� �ʵ��� ��ҿ� ��������(SocketThread �ν��Ͻ�)�� �߰�
					clientList.add(socketThread);
					
					//SocketThread �ν��Ͻ��� ���ο� �����带 �����Ͽ� run() �޼ҵ��� ��� ����
					socketThread.start();
				} catch (IOException e) {
					System.out.println("[�����α�]Ŭ���̾�Ʈ�� ���� ���� ������ �߻� �Ǿ����ϴ�.");
				}
			}
		} catch (IOException e) {
			System.out.println("[�����α�]������ ���������� ���۵��� �ʽ��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new ChatServerApp();
	}
	
	//�޼����� ���޹޾� ���� �������� ��� Ŭ���̾�Ʈ���� �����ϴ� �޼ҵ�
	public void sendMessage(String message) {
		//�ݷ��� �ʵ忡 ����� SocketThread �ν��Ͻ��� �����޾� �ϰ� ó��
		for(SocketThread socketThread:clientList) {
			//Ŭ���̾�Ʈ�� ����� ��� ��Ʈ���� �̿��Ͽ� �޼��� ����
			socketThread.out.println(message);
		}
	}
	
	//Ŭ���̾�Ʈ�� ����� ������ �̿��Ͽ� ����� ����� �����ϱ� ���� Ŭ����
	// => �������� �Է°� ��� ����� �����ϱ� ���� ���ο� �����带 �����Ͽ� ���۵ǵ��� ����
	public class SocketThread extends Thread {
		//Ŭ���̾�Ʈ�� ���ϰ� ����� ���������� �����ϱ� ���� �ʵ�
		private Socket socket;
		
		//Ŭ���̾�Ʈ�� ������ �޼����� ���޹��� �Է� ��Ʈ���� �����ϱ� ���� �ʵ�
		private BufferedReader in;
		
		//Ŭ���̾�Ʈ���� �޼����� ������ ��� ��Ʈ���� �����ϱ� ���� �ʵ�
		private PrintWriter out;
		
		public SocketThread(Socket socket) {
			this.socket=socket;
		}
		
		//���ο� �����尡 �����ϱ� ���� ��� �ۼ�
		// => Ŭ���̾�Ʈ�� �޼����� ���޹޾� ��� ���� Ŭ���̾�Ʈ���� �����ϴ� ��� ����
		@Override
		public void run() {
			String aliasName="";//Ŭ���̾�Ʈ�� ��ȭ���� �����ϱ� ���� ����
			
			try {
				//������ �Է� ��Ʈ���� �����޾� ���ڿ��� ���� �� �ִ� ��Ʈ������ Ȯ���Ͽ� �ʵ忡 ����
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//������ ��� ��Ʈ���� �����޾� ���ڿ��� ���� �� �� �ִ� ��Ʈ������ Ȯ���Ͽ� �ʵ忡 ����
				//out=new PrintWriter(socket.getOutputStream());//��� ���� �̿�
				//PrintWriter(OutputStream out,boolean autoFlush)
				// => autoFlush �Ű������� true�� �����ϸ� ��� ���۸� ������� �ʰ� �����ϴ� ��� ����
				out=new PrintWriter(socket.getOutputStream(),true);
				
				//Ŭ���̾�Ʈ���� ������ ��ȭ���� ��ȯ�޾� ����
				aliasName=in.readLine();
				
				//���� ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �޼����� ����
				sendMessage("["+aliasName+"]���� ���� �Ͽ����ϴ�.");
								
				//Ŭ���̾�Ʈ���� ������ �޼����� ���޹޾� ���� �������� ��� Ŭ���̾�Ʈ���� ����
				// => Ŭ���̾�Ʈ�� ������ �����ϱ� ������ �ݺ� ó��
				// => Ŭ���̾�Ʈ�� ������ �����ϸ� �Է°� ��� ��Ʈ���� ���ŵǹǷ� IOException �߻�
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch (IOException e) {
				//Ŭ���̾�Ʈ�� ������ �����ϸ� ����� ��� �ۼ�
				// => �ݷ��� �ʵ忡�� ���ӵǾ��� Ŭ���̾�Ʈ�� ����� �������� ����
				// => ���� �������� ��� Ŭ���̾�Ʈ���� ���� �޼����� ����
				clientList.remove(this);
				sendMessage("["+aliasName+"]���� ���� �Ͽ����ϴ�.");
				
				System.out.println("[�����α�]"+socket.getInetAddress().getHostAddress()
						+"�� ��ǻ�Ϳ��� ������ ���� �Ͽ����ϴ�.");
			}
		}
	}
}












