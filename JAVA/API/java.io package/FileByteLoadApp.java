package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//파일에 저장된 값을 원시 데이타로 입력받아 모니터에 전달하여 출력하는 프로그램
public class FileByteLoadApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream : 파일에 저장된 값을 원시 데이타로 읽는 입력 스트림을 생성하기 위한 클래스
		FileInputStream in=null;
		try {
			//FileInputStream(String name) : 파일경로를 전달받아 파일 입력 스트림을 생성하는 생성자
			// => 전달받은 파일경로에 파일이 없는 경우 FileNotFoundExcetion 발생 - 예외처리(필수) 
			in=new FileInputStream("c:/data/byte.txt");
			
			System.out.println("[메세지]c:\\data\\byte.txt 파일에 저장된 내용입니다.");
			int readByte;
			while(true) {
				//파일 입력 스트림을 이용하여 파일 저장값을 원시 데이타로 읽어 반환받아 변수에 저장
				readByte=in.read();
				//파일의 마지막에는 EOF(End Of File)가 반드시 존재
				if(readByte==-1) break;
				System.out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[에러]대상 파일을 찾을 수 없습니다.");
		} finally {
			//FileInputStream.close() : 파일 입력 스트림을 제거하는 메소드
			//파일 입력 스트림은 finally 영역에서 제거하는 것을 권장
			// => 예외 발생 유무와 상관없이 파일 입력 스트림 제거
			//if 구문을 이용하여 NullPointerException 발생 방지
			if(in!=null) in.close();
		}
	}//end of main
}//end of class
