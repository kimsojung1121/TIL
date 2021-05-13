package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//Ű����� ������ 2���� �Է¹޾� ���� ���� ����ϴ� ���α׷� �ۼ�
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
		// TODO Auto-generated constructor stub
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("ù���� ���� �Է� >> ");
		//Scanner.nextInt() : �Է°��� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => �Է°��� ���������� ��ȯ���� ���� ��� InputMismatchException
		int num1=scanner.nextInt();
		
		System.out.println("�ι��� ���� �Է� >> ");
		int num2=scanner.nextInt();
		
		//0���� ���� ��� ArithmeticException �߻�
		System.out.println("[���]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try{
			new CalcApp(); //�����ڸ� �ҷ��� �ν��Ͻ� ���� >> �������� ��� ����
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("[����]������ �Է� �����մϴ�.");
		}catch (ArithmeticException e) {
			System.out.println("[����]0���� ���� �� �����ϴ�.");
		}catch (Exception e) {
			//Exception : ��� ���� Ŭ������ �θ� Ŭ����
			// => ��� ���ܸ� ���޹޾� ���� ó��
			System.out.println("[����]���α׷��� ����ġ ���� ������ �߻��Ǿ����ϴ�.");
		}
		*/
		try{
			new CalcApp(); //�����ڸ� �ҷ��� �ν��Ͻ� ���� >> �������� ��� ����
		}catch (InputMismatchException | ArithmeticException e) {
			// JDK 7 �̻󿡼��� ���� Ŭ������ | �����ڷ� �����Ͽ� ���� ó�� ����
			System.out.println("[����]���Ŀ� �°� ���� �Է��� �ּ���.");
		}catch (Exception e) {
			//Exception : ��� ���� Ŭ������ �θ� Ŭ����
			// => ��� ���ܸ� ���޹޾� ���� ó��
			System.out.println("[����]���α׷��� ����ġ ���� ������ �߻��Ǿ����ϴ�.");
		}
		
	}
}
