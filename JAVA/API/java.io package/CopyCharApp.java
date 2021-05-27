package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//원본파일에 저장된 값을 인코딩 처리된 문자 데이타로 읽어 대상파일에 전달하여 저장하는 프로그램
// => 원본파일을 인코딩 처리하여 입력받은 후 대상파일로 전달하므로 정상적인 복사 불가능
// => 텍스트 파일만 복사 가능
public class CopyCharApp {
	public static void main(String[] args) throws IOException {
		//BufferedReader : Reader 인스턴스를 전달받아 대량의 인코딩 처리된 문자 데이타를 
		//얻어오는 기능을 제공하는 입력 스트림을 생성하기 위한 확장 클래스
		BufferedReader in=null;
		
		//BufferedWriter : Writer 인스턴스를 전달받아 대량의 인코딩 처리된 문자 데이타를 
		//전달하는 기능을 제공하는 출력 스트림을 생성하기 위한 확장 클래스
		BufferedWriter out=null;
		
		try {
//			in=new BufferedReader(new FileReader("c:/data/zoom.txt"));
//			out=new BufferedWriter(new FileWriter("c:/data/zoom_char.txt"));
			
			in=new BufferedReader(new FileReader("c:/data/zip.exe"));
			out=new BufferedWriter(new FileWriter("c:/data/zip_char.exe"));
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[메세지]파일을 성공적으로 복사하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본 파일을 찾을 수 없습니다.");
		} finally {
			if(in!=null) in.close();
			if(out!=null) out.close();
		}
	}//end of main
}//end of class
