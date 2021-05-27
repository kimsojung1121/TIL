package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Character Stream :  ���ڵ� ó���� ���� ����Ÿ�� �����ϱ� ���� �Է� �Ǵ� ��� ��Ʈ��
// Reader Ŭ���� �Ǵ�  Writer Ŭ������ ��� ���� ��� �ڽ� Ŭ������ ������ ��Ʈ�� (�ν��Ͻ�)

//Ű���� �Է°��� ���ڵ� ó���� �Է¹޾� ����Ϳ� �����Ͽ� ����ϴ� ���α׷�
//EOF(End Of File): �Է� ���� - Ctrl + Z, �� : Cmd + D ��ȣ�� �����ϸ� ���α׷� ����
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���] Ű���带 ���� ���� �Է��� �ּ���.����[Ctrl + Z]");
		
//		InputStreamReader : ���ڵ� ó���� ���� ����Ÿ�� ��ȯ�ϱ� ���� ����� �����ϴ� Ŭ����
		// => InputSteram �ν��Ͻ��� ���޹޾ƾ� �Է� ��Ʈ�� ���� ���� - Ȯ�� ��Ʈ�� 
		InputStreamReader in = new InputStreamReader(System.in);
		
		// OutputStreamWriter : ���ڵ� ó���� ���� ����Ÿ�� �����ϱ� ���� ����� �����ϴ� Ŭ����
		// OutputStreamWriter �ν��Ͻ��� ���޹޾ƾ� �Է� ��Ʈ�� ���� ���� - Ȯ�� ��Ʈ�� 
//		OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		// PrintWriter : ���ڵ� ó���� ���� ����Ÿ�� �����ϱ� ���� ����� �����ϴ� Ŭ����
		// => ��� ���� ���ڿ��� ��ȯ�Ͽ� �����ϴ� �޼ҵ尡 �߰��� Ŭ���� 
		PrintWriter out = new PrintWriter(System.out);
		
		int readByte;
		
		while(true){
			// Reader.read() : �Է� ��Ʈ���� �����ϴ� ���� ���ڵ� ó���� ���� ����Ÿ�� �о� ��ȯ�ϴ� �޼ҵ�
			readByte = in.read();
			
			if(readByte == -1) break;
			
			// Writer.write(int b) : ��� ��Ʈ���� ���ڵ� ó���� ���� ����Ÿ�� �����ϴ� �޼ҵ� 
			// ���� ����Ÿ�� ���� ũ�⸸ŭ ��� ���ۿ� ��Ƽ� �ѹ��� ��� ��Ʈ���� ���� 
			out.write(readByte);
			
			// Writer.flush() : ��� ���ۿ� ����� ���� ����Ÿ�� ��� ��Ʈ������ �����ϴ� �޼ҵ� 
			out.flush();
		}
		System.out.println("[�޼���] ���α׷��� �����մϴ�.");
	}
}
