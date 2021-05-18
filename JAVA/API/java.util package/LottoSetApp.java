package xyz.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 범위의 중복되지 않는 정수난수 6개를 제공받아 오름차순 정렬하여 출력하는 프로그램을 작성하세요.
public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet=new HashSet<Integer>();
		Random random=new Random();
		
		while(true) {
			//1~45 범위의 정수난수를 제공받아 Set 인스턴스의 요소로 추가
			// => Set 인스턴스에는 동일한 값이 저장된 요소가 존재 불가능
			lottoSet.add(random.nextInt(45)+1);
			if(lottoSet.size()==6) break;
		}
		
		//Set.toArray(E[] a) : Set 인스턴스를 배열로 변환하여 반환하는 메소드
		Integer[] lotto=lottoSet.toArray(new Integer[0]);
		
		//Arrays.sort(Object[] a) : 배열을 전달받아 요소를 정렬하는 메소드
		Arrays.sort(lotto);
		
		//Arrays.toString(Object[] a) : 배열을 전달받아 모든 배열 요소값을 문자열로 변환하여 반환하는 메소드
		System.out.println("행운의 숫자 = "+Arrays.toString(lotto));
	}

}
