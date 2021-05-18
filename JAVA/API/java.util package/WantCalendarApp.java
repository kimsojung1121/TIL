
package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//Ű����� ��� ���� �Է¹޾� �ش� ����� ���� �޷��� ����ϴ� ���α׷��� �ۼ��ϼ���. 
public class WantCalendarApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("�� �Է� >> ");
		int year=Integer.parseInt(scanner.nextLine());
		
		System.out.print("�� �Է� >> ");
		int month=Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		//�ý����� ���� ��¥�� �ð� ���� ������ ����� Calendar �ν��Ͻ��� ��ȯ�޾� ����
		Calendar calendar=Calendar.getInstance();//2021-05-18
		
		//Calendar �ν��Ͻ��� ����� ��¥ ���� ������ Ű����� �Է��� ����� ���� 1�Ϸ� ����
		// => ���� 1�Ϸ� �����ϴ� ������ 1�Ͽ� ���� ������ �����ޱ� ���� ���� 
		//Calendar.set(int year, int month, int date) : Calendar �ν��Ͻ��� �����
		//��¥�� �ð� ���� ���� �� ������� �����ϴ� �޼ҵ�
		calendar.set(year, month-1, 1);//�� : 0~11
		
		//Calendar �ν��Ͻ��� ����� ��¥�� �ð� ���� ���� �� ����(��:1~��:7)�� ��ȯ�޾� ����
		int week=calendar.get(Calendar.DAY_OF_WEEK);

		//�ش� ����� ���� �޷� ���
		System.out.println();
		System.out.println("============================");
		System.out.println("          "+year+"�� "+month+"��");
		System.out.println("============================");
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("============================");
		
		//1�Ͽ� ���� ���������� ���� ���
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//1���� ���� ������ ������ ���
		// => ������� ��¥ ��� �� ���ο� �ٷ� �ٲپ� ���
		//Calendar.getActualMaximum(int field) : Calendar �ν��Ͻ��� ����� ��¥�� �ð�
		//���� ���� �� ���޵� ����� �ִ밪�� ��ȯ�ϴ� �޼ҵ�
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			if(i<=9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;//���� ����
			
			if(week%7==1) {//������ ������ �Ͽ����� ���
				System.out.println();
			}
		}
	}
}
