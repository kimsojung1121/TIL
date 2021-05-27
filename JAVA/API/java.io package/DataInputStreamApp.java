package xyz.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataInputStream : InputStream 인스턴스를 전달받아 원시 데이타를 원하는 자료형의 값으로
		//변환하여 읽기 위한 기능을 제공하는 입력 스트림을 생성하기 위한 확장 클래스
		DataInputStream in=new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		//반드시 파일에 저장된 순서대로 값을 읽어 사용 (순서대로 저장하지 않을 시, EOFException 혹은 쓰레기값 저장)
		// => 파일에 저장된 값을 읽기 위한 메소드 호출시 EOFException 발생
		// => EOFException : 입력 메소드 호출시 파일 커서가 EOF 위치에 존재할 때 발생되는 예외
		
		//DataInputStream.readInt() : 입력 스트림의 원시 데이타를 정수값으로 변환하여 반환하는 메소드
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : 입력 스트림의 원시 데이타를 논리값으로 변환하여 반환하는 메소드
		boolean value2=in.readBoolean();
		
		//DataInputStream.readUTF() : 입력 스트림의 원시 데이타를 문자열로 변환하여 반환하는 메소드
		String value3=in.readUTF();
		
		System.out.println("value1 = "+value1);
		System.out.println("value2 = "+value2);
		System.out.println("value3 = "+value3);
		
		in.close();
		
	}//end of main
}//end of class
