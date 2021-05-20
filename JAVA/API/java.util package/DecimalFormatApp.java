package xyz.itwill.util;

import java.text.DecimalFormat;

//java.text.DecimalFormat : 
public class DecimalFormatApp {
	public static void main(String[] args) {
		//DecimalFormat(String pattern) : 10진수 정수값에 대한 패턴정보를 전달받아
		//인스턴스를 생성하기 위한 생성자
		// => 패턴문자 : #(숫자-공백), 0(숫자-0), $(화폐기호) 등
//		DecimalFormat decimalFormat=new DecimalFormat("###,###,###,##0");
		DecimalFormat decimalFormat=new DecimalFormat("$###,###,###,##0");
		
		long money=10_000_000_000L;
		
		System.out.println("금액 = "+money+"원");
		
		//decimalFormat.format(Number o) : 전달받은 숫자값을 decimalFormat 인스턴스에
		//저장된 패턴정보의 문자열로 변환하여 반환하는 메소드
		// => 전달받은 숫자값이 패턴의 길이를 초과해도 정상적으로 변환되어 반환
		System.out.println("금액 = "+decimalFormat.format(money)+"원");
		
		//DecimalFormat.getInstance() : 기본 패턴정보를 저장한 DecimalFormat 인스턴스를 반환하는 메소드
		System.out.println("금액 = "+DecimalFormat.getInstance().format(money)+"원");

		//DecimalFormat.getCurrencyInstance() : 기본 패턴정보를 저장한 DecimalFormat 인스턴스를 반환하는 메소드
		// => 변환되는 문자열 앞에 시스템에서 사용되는 화폐단위가 추가되어 변환
		System.out.println("금액 = "+DecimalFormat.getCurrencyInstance().format(money));
	}
}
