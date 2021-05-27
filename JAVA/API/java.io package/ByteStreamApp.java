package xyz.itwill.io;

import java.io.IOException;

// Byte Stream :  ���õ���Ÿ�� �����ϱ� ���� �Է� �Ǵ� ��� ��Ʈ��
// => InputStream Ŭ���� �Ǵ�  OutputStream Ŭ������ ��� ���� ��� �ڽ� Ŭ������ ������ ��Ʈ��(�ν��Ͻ�)

// Ű���� �Է°��� ���� ����Ÿ�� �Է¹޾� ����Ϳ� �����Ͽ� ����ϴ� ���α׷�
// EOF(End Of File : �Է� ���� - Ctrl + Z, �� : Cmd + D) ��ȣ�� �����ϸ� ���α׷� ����
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���] Ű���带 ���� ���� �Է��� �ּ���.����[Ctrl + Z]");
		
		// Ű���� �Է°��� ��ȯ�޾� �����ϱ� ���� ���� 
		int readByte;
		
		while(true) {
			// System.in :  Java���� �⺻������ �����Ǵ� Ű���� �Է� ��Ʈ�� 
			// => InputSteram Ŭ������ ��ӹ޾� �ڽ�Ŭ������ ������ ��Ʈ��
			// InputSteram.read() : �Է� ��Ʈ���� �����ϴ� Byte Ÿ���� ���� ���� ����Ÿ�� �о� ��ȯ�ϴ� �޼ҵ�
			// => �Է� ��Ʈ���� ���� ���� ��� ������ �Ͻ� ���� 
			// => Ű���带 ���� �Է� ��Ʈ���� ���� �����ϰ� ���͸� ���� ������ ����� 
			// ��� �Է� �Ǵ� ��� ��Ʈ���� �޼ҵ忡���� IOException �߻� - ���� ó��
			// => IOException : �Է� �Ǵ� ��� ��Ʈ���� ������ �ִ� ��� �߻��Ǵ� ���� 
			readByte = System.in.read();
			
			// �Է� ���� ��ȣ(Ctrl + Z : EOF >> -1)�� ���޵� ��� �ݺ��� ����
			if(readByte == -1) break;
			
			// System.out :  Java���� �⺻������ �����Ǵ� ����� ��� ��Ʈ��
			// OutputStream Ŭ������ ��ӹ��� �ڽ�Ŭ����(PrintStream)�� ������ ��Ʈ��
			// OutputStream.write(int b) : ���� ����Ÿ(1Byte)�� ��� ��Ʈ������ �����ϴ� �޼ҵ� 
			System.out.write(readByte);
		}
		System.out.println("[�޼���] ���α׷��� �����մϴ�.");
	}
}
