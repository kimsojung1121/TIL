
package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 년과 월을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램을 작성하세요. 
public class WantCalendarApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("년 입력 >> ");
		int year=Integer.parseInt(scanner.nextLine());
		
		System.out.print("월 입력 >> ");
		int month=Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		//시스템의 현재 날짜와 시간 관련 정보가 저장된 Calendar 인스턴스를 반환받아 저장
		Calendar calendar=Calendar.getInstance();//2021-05-18
		
		//Calendar 인스턴스에 저장된 날짜 관련 정보를 키보드로 입력한 년월에 대한 1일로 변경
		// => 일을 1일로 변경하는 이유는 1일에 대한 요일을 제공받기 위해 변경 
		//Calendar.set(int year, int month, int date) : Calendar 인스턴스에 저장된
		//날짜와 시간 관련 정보 중 년월일을 변경하는 메소드
		calendar.set(year, month-1, 1);//월 : 0~11
		
		//Calendar 인스턴스에 저장된 날짜와 시간 관련 정보 중 요일(일:1~토:7)을 반환받아 저장
		int week=calendar.get(Calendar.DAY_OF_WEEK);

		//해당 년월에 대한 달력 출력
		System.out.println();
		System.out.println("============================");
		System.out.println("          "+year+"년 "+month+"월");
		System.out.println("============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");
		
		//1일에 대한 요일전까지 공백 출력
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//1부터 달의 마지막 날까지 출력
		// => 토요일의 날짜 출력 후 새로운 줄로 바꾸어 출력
		//Calendar.getActualMaximum(int field) : Calendar 인스턴스에 저장된 날짜와 시간
		//관련 정보 중 전달된 상수의 최대값을 반환하는 메소드
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			if(i<=9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;//요일 증가
			
			if(week%7==1) {//증가된 요일이 일요일인 경우
				System.out.println();
			}
		}
	}
}
