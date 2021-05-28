package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//ȸ������(Member �ν��Ͻ�)�� ���Ͽ� �����Ͽ� �����ϴ� ���α׷�
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/member.txt"));
		
		
		//writeObject() �޼ҵ� ȣ��� NotSerializableException �߻�
		//NotSerializableException : ��ü ����ȭ ������� ���� Ŭ������ �ν��Ͻ��� ��� ��Ʈ������ ������ ��� �߻��Ǵ� ����
		// => �ν��Ͻ��� Ŭ������ ��ü ����ȭ Ŭ������ �����ϸ� ���� �̹߻�
		out.writeObject(new Member("aaa", "ȫ�浿", "010-1234-5678"));
		out.writeObject(new Member("bbb", "�Ӳ���", "010-5678-1234"));
		out.writeObject(new Member("ccc", "����ġ", "010-1474-2583"));
		
		out.close();
		
		System.out.println("c:\\data\\member.txt ���Ͽ� ȸ�������� �����Ͽ����ϴ�.");
		
	}//end of main
}//end of class
