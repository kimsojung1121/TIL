package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//ObjectOutputStream : OutputStream 인스턴스를 전달받아 원하는 자료형 또는 인스턴스를
		//원시 데이타로 변환하여 전달하는 기능을 제공하는 출력 스트림을 생성하기 위한 확장 클래스
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object obj) : 객체(인스턴스)를 출력 스트림으로 전달하는 메소드
		out.writeObject("홍길동"); //String 인스턴스 전달
		out.writeObject(new Date()); //Date 인스턴스 전달
		out.writeObject(Arrays.asList("임꺽정","전우치","일지매")); //ArrayList 인스턴스 전달
		
		out.close();		
		System.out.println("c://data//object.txt 파일에 다양한 객체들을 저장하였습니다.");
	}//end of main
}//end of class
