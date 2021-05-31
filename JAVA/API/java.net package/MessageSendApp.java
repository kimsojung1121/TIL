package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//Ű����� �޼����� �Է¹޾� ���� ��ǻ�Ϳ��� �����ϴ� UDP ����� ��Ʈ��ũ ���α׷�
// => DatagramSocket Ŭ������ DatagramPacket Ŭ������ ��Ʈ��ũ ���α׷� �ۼ�
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���� �޼��� �Է� >> ");
		String message=in.readLine();
		
		//DatagramSocket : �ٸ� ��ǻ�Ϳ� ����Ǳ� ���� ����� �����ϴ� Ŭ����
		// => DatagramSocket() �����ڷ� ����Ÿ�� �����ϱ� ���� ���� ����
		DatagramSocket socket=new DatagramSocket();
		
		//�����ϰ��� �ϴ� ��ǻ���� ��Ʈ��ũ ������ ����� InetAddress �ν��Ͻ��� ��ȯ�޾� ����
		InetAddress address=InetAddress.getByName("192.168.200.198");
		
		//String.getBytes() : String �ν��Ͻ��� ����� ���ڿ��� byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		byte[] data=message.getBytes(); //��ü ������ ������ ���� �Ұ���
		
		//DatagramPacket : ��Ŷ������ �����ϱ� ���� Ŭ����
		// => ��Ŷ(Packet) : ��Ʈ��ũ���� ����Ÿ�� �����ϱ� ���� ����
		//DatagramPacket(byte[] data, int length, InetAddress address, int port)
		// => �ٸ� ��ǻ�ͷ� ���� ������ ������ DatagramPacket �ν��Ͻ��� �����ϴ� ������
		// => buf : ���ް�, length : ��Ŷũ��, address : ���� ��ǻ���� ��Ʈ��ũ ����, port : ���� ��ǻ���� ��Ʈ ��ȣ
		DatagramPacket packet=new DatagramPacket(data, data.length, address, 5000);
		
		//DatagramSocket.send(DatagramPacket packet) : ���� ��ǻ�Ϳ��� ��Ŷ�� �����ϴ� �޼ҵ�
		socket.send(packet);
		
		//DatagramSocket.close(0 : ������ �����ϴ� �޼ҵ� - ���� ����)
		socket.close();
		
		System.out.println("[���]���� ��ǻ�Ϳ� �޼����� ���½��ϴ�.");
		
	}//end of main
}//end of class
