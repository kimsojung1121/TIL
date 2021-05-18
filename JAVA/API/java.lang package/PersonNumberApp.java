package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 주민등록번호를 입력받아 생년월일과 성별을 출력하는 프로그램을 작성하세요.
// => 주민번호는 14자리이며 7번째 자리에는 - 문자 존재
// => 비정상적인 주민등록번호가 입력된 경우 에러 메세지 출력 후 재입력되도록 처리
// ex) 주민등록번호 입력[ex.901225-1234567] >> 000101-4567890
//     [결과]생년월일 = 2000년 01월 01일, 성별 = 여자
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//주민등록번호 입력 >> 입력값 검증
		String number;
		while(true) {
			System.out.print("주민등록번호 입력[ex.901225-1234567] >> ");
			//입력된 문자열의 앞뒤 공백을 제거하고 변수에 저장
			number=scanner.nextLine().trim();
			//if(number.length()==14 && number.charAt(6)=='-') break;
			if(number.length()==14 && number.indexOf("-")==6) break;
			System.out.println("[에러]형식에 맞는 주민등록번호를 입력해 주세요.");
		}
		
		scanner.close();
		
		//주민등록번호의 8번째 위치에 문자열 하나를 분리하여 저장
		String separation=number.substring(7, 8);
		//System.out.println("separation = "+separation);
		
		//주민등록번호에서 생년월일을 분리하여 저장
		String birthday="";
		if(separation.equals("1") || separation.equals("2")) {
			birthday+="19";
		} else if(separation.equals("3") || separation.equals("4")) {
			birthday+="20";
		}
		
		birthday+=number.substring(0, 2)+"년 ";
		birthday+=number.substring(2, 4)+"월 ";
		birthday+=number.substring(4, 6)+"일";
		
		//주민등록번호에서 성별을 비교하여 저장
		String gender="";
		if(separation.equals("1") || separation.equals("3")) {
			gender="남자";
		} else if(separation.equals("2") || separation.equals("4")) {
			gender="여자";
		}
		
		System.out.println("[결과]생년월일 =  "+birthday+", 성별 = "+gender);
	}
}
