package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//���Ͽ� ����� ���� ���� ����Ÿ�� �Է¹޾� ����Ϳ� �����Ͽ� ����ϴ� ���α׷�
public class FileByteLoadApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream : ���Ͽ� ����� ���� ���� ����Ÿ�� �д� �Է� ��Ʈ���� �����ϱ� ���� Ŭ����
		FileInputStream in=null;
		try {
			//FileInputStream(String name) : ���ϰ�θ� ���޹޾� ���� �Է� ��Ʈ���� �����ϴ� ������
			// => ���޹��� ���ϰ�ο� ������ ���� ��� FileNotFoundExcetion �߻� - ����ó��(�ʼ�) 
			in=new FileInputStream("c:/data/byte.txt");
			
			System.out.println("[�޼���]c:\\data\\byte.txt ���Ͽ� ����� �����Դϴ�.");
			int readByte;
			while(true) {
				//���� �Է� ��Ʈ���� �̿��Ͽ� ���� ���尪�� ���� ����Ÿ�� �о� ��ȯ�޾� ������ ����
				readByte=in.read();
				//������ ���������� EOF(End Of File)�� �ݵ�� ����
				if(readByte==-1) break;
				System.out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[����]��� ������ ã�� �� �����ϴ�.");
		} finally {
			//FileInputStream.close() : ���� �Է� ��Ʈ���� �����ϴ� �޼ҵ�
			//���� �Է� ��Ʈ���� finally �������� �����ϴ� ���� ����
			// => ���� �߻� ������ ������� ���� �Է� ��Ʈ�� ����
			//if ������ �̿��Ͽ� NullPointerException �߻� ����
			if(in!=null) in.close();
		}
	}//end of main
}//end of class
