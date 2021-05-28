package xyz.itwill.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//���Ͽ� ����� ��� ȸ�������� �о� ȭ�鿡 ����ϴ� ���α׷�
public class MemberLoadApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/member.txt"));
		
		System.out.println("<<ȸ�����>>");
		while(true) {
			try {
				//readObject() �޼ҵ� ȣ��� ���� Ŀ���� EOF ��ġ�� ���� ��� EOFException �߻�
				Member member=(Member)in.readObject();
				System.out.println(member);//toString() �޼ҵ� ȣ��
			} catch(EOFException e) {
				break;
			}
		}//end of wile
		
		in.close();
	}//end of main
}//end of class