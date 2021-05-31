package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP ������ �����Ͽ� �������� ������ ��¥�� �ð������� �޾� ����ϴ� Ŭ���̾�Ʈ ���α׷�
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket �ν��Ͻ� ���� - ���� ����
			Socket socket=new Socket("192.168.200.198", 3000);
		
			//Socket.getInputStream() : Socket �ν��Ͻ��� �Է� ��Ʈ��(InputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
			// => ���ӵ� ���� ��ǻ�Ϳ��� ������ ���� ����Ÿ�� �ޱ� ���� �Է� ��Ʈ��
			InputStream in=socket.getInputStream();
			
			//Socket �ν��Ͻ��� �Է� ��Ʈ���� ���޹޾� ��ü�� ���� �� �ִ� �Է� ��Ʈ��(ObjectInputStream �ν��Ͻ�)�� Ȯ��
			ObjectInputStream stream=new ObjectInputStream(in);
			
			//������ ������ Date �ν��Ͻ��� ��ȯ�޾� ����
			Date date=(Date)stream.readObject();
			
			//Date �ν��Ͻ��� ���ϴ� ������ ���ڿ��� ��ȯ�Ͽ� ���
			System.out.println("[���]������ ������ ��¥�� �ð� = "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			
			//���� ����
			socket.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[����]������ ������ �� �����ϴ�.");
		}
	}//end of main
}//end of class
