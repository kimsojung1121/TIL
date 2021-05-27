package xyz.itwill.io;

import java.io.IOException;

// Byte Stream :  원시데이타로 전달하기 위한 입력 또는 출력 스트림
// => InputStream 클래스 또는  OutputStream 클래스를 상속 받은 모든 자식 클래스로 생성된 스트림(인스턴스)

// 키보드 입력값을 원시 데이타로 입력받아 모니터에 전달하여 출력하는 프로그램
// EOF(End Of File : 입력 종료 - Ctrl + Z, 맥 : Cmd + D) 신호를 전달하면 프로그램 종료
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지] 키보드를 눌러 값을 입력해 주세요.종료[Ctrl + Z]");
		
		// 키보드 입력값을 반환받아 저장하기 위한 변수 
		int readByte;
		
		while(true) {
			// System.in :  Java에서 기본적으로 제공되는 키보드 입력 스트림 
			// => InputSteram 클래스를 상속받아 자식클래스로 생성된 스트림
			// InputSteram.read() : 입력 스트림에 존재하는 Byte 타입의 값을 원시 데이타로 읽어 반환하는 메소드
			// => 입력 스트림에 값이 없는 경우 스레드 일시 중지 
			// => 키보드를 눌러 입력 스트림에 값을 전달하고 엔터를 눌러 스레드 재실행 
			// 모든 입력 또는 출력 스트림의 메소드에서는 IOException 발생 - 예외 처리
			// => IOException : 입력 또는 출력 스트림에 문제가 있는 경우 발생되는 예외 
			readByte = System.in.read();
			
			// 입력 종료 신호(Ctrl + Z : EOF >> -1)가 전달된 경우 반복문 종료
			if(readByte == -1) break;
			
			// System.out :  Java에서 기본적으로 제공되는 모니터 출력 스트림
			// OutputStream 클래스를 상속받은 자식클래스(PrintStream)로 생성된 스트림
			// OutputStream.write(int b) : 원시 데이타(1Byte)를 출력 스트림으로 전달하는 메소드 
			System.out.write(readByte);
		}
		System.out.println("[메세지] 프로그램을 종료합니다.");
	}
}
