package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ObjectInputStreamApp {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//ObjectInputStream : InputStream 인스턴스를 전달받아 원시 데이타를 원하는 자료형 또는 인스턴스로
		//변환하여 반환하는 기능을 제공하는 입력 스트림을 생성하기 위한 확장 클래스
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/object.txt"));
		
		//ObjectInputStream.readObject() : 입력 스트림의 원시 데이타를 객체(인스턴스)로  변환하여 반환하는 메소드
		// => readObject() 메소드는 인스턴스를 Object 타입으로 반환하므로 반드시 명시적 객체 형변환
		// => 반환되는 인스턴스에 대한 클래스가 없는 경우 ClassNotFountException 발생
		String string=(String)in.readObject();
		Date date=(Date)in.readObject();
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)in.readObject();
		
		//인스턴스의 toString() 메소드 자동 호출
		System.out.println("string = "+string);
		System.out.println("date = "+date);
		System.out.println("list = "+list);
		
		in.close();
		
	}//end of main
}//emd of class
