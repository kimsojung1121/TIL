package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//회원정보(Member 인스턴스)를 파일에 전달하여 저장하는 프로그램
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/member.txt"));
		
		
		//writeObject() 메소드 호출시 NotSerializableException 발생
		//NotSerializableException : 객체 직렬화 선언되지 않은 클래스의 인스턴스를 출력 스트림으로 전달한 경우 발생되는 예외
		// => 인스턴스의 클래스를 객체 직렬화 클래스로 선언하면 예외 미발생
		out.writeObject(new Member("aaa", "홍길동", "010-1234-5678"));
		out.writeObject(new Member("bbb", "임꺽정", "010-5678-1234"));
		out.writeObject(new Member("ccc", "전우치", "010-1474-2583"));
		
		out.close();
		
		System.out.println("c:\\data\\member.txt 파일에 회원정보를 저장하였습니다.");
		
	}//end of main
}//end of class
