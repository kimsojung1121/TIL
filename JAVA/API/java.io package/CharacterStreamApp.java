package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Character Stream :  인코딩 처리된 문자 데이타로 전달하기 위한 입력 또는 출력 스트림
// Reader 클래스 또는  Writer 클래스를 상속 받은 모든 자식 클래스로 생성된 스트림 (인스턴스)

//키보드 입력값을 인코딩 처리된 입력받아 모니터에 전달하여 출력하는 프로그램
//EOF(End Of File): 입력 종료 - Ctrl + Z, 맥 : Cmd + D 신호를 전달하면 프로그램 종료
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지] 키보드를 눌러 값을 입력해 주세요.종료[Ctrl + Z]");
		
//		InputStreamReader : 인코딩 처리된 문자 데이타를 반환하기 위한 기능을 제공하는 클래스
		// => InputSteram 인스턴스을 전달받아야 입력 스트림 생성 가능 - 확장 스트림 
		InputStreamReader in = new InputStreamReader(System.in);
		
		// OutputStreamWriter : 인코딩 처리된 문자 데이타를 전달하기 위한 기능을 제공하는 클래스
		// OutputStreamWriter 인스턴스을 전달받아야 입력 스트림 생성 가능 - 확장 스트림 
//		OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		// PrintWriter : 인코딩 처리된 문자 데이타를 전달하기 위한 기능을 제공하는 클래스
		// => 모든 값을 문자열로 변환하여 전달하는 메소드가 추가된 클래스 
		PrintWriter out = new PrintWriter(System.out);
		
		int readByte;
		
		while(true){
			// Reader.read() : 입력 스트림에 존재하는 값을 인코딩 처리된 문자 데이타로 읽어 반환하는 메소드
			readByte = in.read();
			
			if(readByte == -1) break;
			
			// Writer.write(int b) : 출력 스트림에 인코딩 처리된 문자 데이타를 전달하는 메소드 
			// 문자 데이타를 일정 크기만큼 출력 버퍼에 모아서 한번에 출력 스트림에 전달 
			out.write(readByte);
			
			// Writer.flush() : 출력 버퍼에 저장된 문자 데이타를 출력 스트림으로 전달하는 메소드 
			out.flush();
		}
		System.out.println("[메세지] 프로그램을 종료합니다.");
	}
}
