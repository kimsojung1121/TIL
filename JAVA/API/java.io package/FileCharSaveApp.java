package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//Ű���� �Է°��� ���ڵ� ó���� ���� ����Ÿ�� �Է¹޾� ���Ͽ� �����Ͽ� �����ϴ� ���α׷�
// => EOF(End Of File : �Է� ���� - Ctrl+Z) ��ȣ�� �����ϸ� ���α׷� ����
public class FileCharSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");
		
		//Ű���� �Է°��� ���ڵ� ó���� ���� ����Ÿ�� �б� ���� �Է� ��Ʈ�� ���� - Ȯ��
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter : ���Ͽ� ���ڵ� ó���� ���� ����Ÿ�� �����Ͽ� �����ϴ� ��� ��Ʈ���� �����ϱ� ���� Ŭ����
		//FileWriter(String name) : ���ϰ�θ� ���޹޾� ���� ��� ��Ʈ���� �����ϴ� ������
//		FileWriter out=new FileWriter("c:/data/char.txt");
		FileWriter out=new FileWriter("c:/data/char.txt", true);
		
		int readByte;
		while(true) {
			readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		out.close();
		System.out.println("[�޼���]c:\\data\\char.txt ���Ͽ� Ű���� �Է°��� ����Ǿ����ϴ�.");
	}//end of main
}//end of class
