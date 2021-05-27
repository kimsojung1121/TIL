package xyz.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataOutputStream : OutputStream 인스턴스를 전달받아 원하는 자료형의 값을
		//원시 데이타로 전달하는 기능을 제공하는 출력 스트림을 생성하기 위한 확장 클래스
		DataOutputStream out=new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int value) : 정수값을 출력 스트림으로 전달하는 메소드
		out.writeInt(100);
		
		//DataOutputStream.writeBoolean(boolean value) : 논리값을 출력 스트림으로 전달하는 메소드
		out.writeBoolean(true);
		
		//DataOutputStream.writeUTF(String value) : 문자열을 출력 스트림으로 전달하는 메소드
		out.writeUTF("홍길동");
		
		out.close();
		
		System.out.println("c://data//data.txt 파일에 다양한 자료형의 값들을 저장하였습니다.");
	}//end of main
}//end of class
