package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 나눈 몫을 출력하는 프로그램 작성
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
		// TODO Auto-generated constructor stub
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("첫번재 정수 입력 >> ");
		//Scanner.nextInt() : 입력값을 정수값으로 변환하여 반환하는 메소드
		// => 입력값이 정수값으로 변환되지 못할 경우 InputMismatchException
		int num1=scanner.nextInt();
		
		System.out.println("두번재 정수 입력 >> ");
		int num2=scanner.nextInt();
		
		//0으로 나눈 경우 ArithmeticException 발생
		System.out.println("[결과]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try{
			new CalcApp(); //생성자를 불러와 인스턴스 생성 >> 생성자의 명령 실행
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("[에러]정수만 입력 가능합니다.");
		}catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		}catch (Exception e) {
			//Exception : 모든 예외 클래스의 부모 클래스
			// => 모든 예외를 전달받아 예외 처리
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
		*/
		try{
			new CalcApp(); //생성자를 불러와 인스턴스 생성 >> 생성자의 명령 실행
		}catch (InputMismatchException | ArithmeticException e) {
			// JDK 7 이상에서는 예외 클래스를 | 연산자로 연결하여 예외 처리 가능
			System.out.println("[에러]형식에 맞게 값을 입력해 주세요.");
		}catch (Exception e) {
			//Exception : 모든 예외 클래스의 부모 클래스
			// => 모든 예외를 전달받아 예외 처리
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
		
	}
}
