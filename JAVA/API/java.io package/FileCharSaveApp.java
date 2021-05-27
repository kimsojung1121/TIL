package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드 입력값을 인코딩 처리된 문자 데이타로 입력받아 파일에 전달하여 저장하는 프로그램
// => EOF(End Of File : 입력 종료 - Ctrl+Z) 신호를 전달하면 프로그램 종료
public class FileCharSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[종료:Ctrl+Z]");
		
		//키보드 입력값을 인코딩 처리된 문자 데이타로 읽기 위한 입력 스트림 생성 - 확장
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter : 파일에 인코딩 처리된 문자 데이타를 전달하여 저장하는 출력 스트림을 생성하기 위한 클래스
		//FileWriter(String name) : 파일경로를 전달받아 파일 출력 스트림을 생성하는 생성자
//		FileWriter out=new FileWriter("c:/data/char.txt");
		FileWriter out=new FileWriter("c:/data/char.txt", true);
		
		int readByte;
		while(true) {
			readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		out.close();
		System.out.println("[메세지]c:\\data\\char.txt 파일에 키보드 입력값이 저장되었습니다.");
	}//end of main
}//end of class
