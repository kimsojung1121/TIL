package xyz.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataInputStream : InputStream �ν��Ͻ��� ���޹޾� ���� ����Ÿ�� ���ϴ� �ڷ����� ������
		//��ȯ�Ͽ� �б� ���� ����� �����ϴ� �Է� ��Ʈ���� �����ϱ� ���� Ȯ�� Ŭ����
		DataInputStream in=new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		//�ݵ�� ���Ͽ� ����� ������� ���� �о� ��� (������� �������� ���� ��, EOFException Ȥ�� �����Ⱚ ����)
		// => ���Ͽ� ����� ���� �б� ���� �޼ҵ� ȣ��� EOFException �߻�
		// => EOFException : �Է� �޼ҵ� ȣ��� ���� Ŀ���� EOF ��ġ�� ������ �� �߻��Ǵ� ����
		
		//DataInputStream.readInt() : �Է� ��Ʈ���� ���� ����Ÿ�� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : �Է� ��Ʈ���� ���� ����Ÿ�� �������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		boolean value2=in.readBoolean();
		
		//DataInputStream.readUTF() : �Է� ��Ʈ���� ���� ����Ÿ�� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		String value3=in.readUTF();
		
		System.out.println("value1 = "+value1);
		System.out.println("value2 = "+value2);
		System.out.println("value3 = "+value3);
		
		in.close();
		
	}//end of main
}//end of class
