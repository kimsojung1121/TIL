package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

//���Ͽ� ����� ���� ���ڵ� ó���� ���� ����Ÿ�� �Է¹޾� ����Ϳ� �����Ͽ� ����ϴ� ���α׷�
public class FileCharLoadApp {
	public static void main(String[] args) throws IOException {
		//FileReader : ���Ͽ� ����� ���� ���ڵ� ó���� ���� ����Ÿ�� �д� �Է� ��Ʈ���� �����ϱ� ���� Ŭ����
		// => ���޹��� ���ϰ�ο� ������ ���� ��� FileNotFoundExcetion �߻� - ����ó��(�ʼ�) 
		FileReader in=null;
		try {
			in=new FileReader("c:/data/char.txt");
			
			//������� ���ڵ� ó���� ���� ����Ÿ�� �����ϴ� ��� ��Ʈ�� ���� - Ȯ��
			OutputStreamWriter out=new OutputStreamWriter(System.out);
			System.out.println("[�޼���]c:\\data\\char.txt ���Ͽ� ����� �����Դϴ�.");

			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
				out.flush();
			}
		} catch(FileNotFoundException e) {
			System.out.println("[����]��� ������ ã�� �� �����ϴ�.");
		} finally {
			if(in!=null) in.close();
		}
	}//end of main
}//end of class
