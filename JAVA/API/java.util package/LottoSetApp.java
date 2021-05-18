package xyz.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 ������ �ߺ����� �ʴ� �������� 6���� �����޾� �������� �����Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���.
public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet=new HashSet<Integer>();
		Random random=new Random();
		
		while(true) {
			//1~45 ������ ���������� �����޾� Set �ν��Ͻ��� ��ҷ� �߰�
			// => Set �ν��Ͻ����� ������ ���� ����� ��Ұ� ���� �Ұ���
			lottoSet.add(random.nextInt(45)+1);
			if(lottoSet.size()==6) break;
		}
		
		//Set.toArray(E[] a) : Set �ν��Ͻ��� �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		Integer[] lotto=lottoSet.toArray(new Integer[0]);
		
		//Arrays.sort(Object[] a) : �迭�� ���޹޾� ��Ҹ� �����ϴ� �޼ҵ�
		Arrays.sort(lotto);
		
		//Arrays.toString(Object[] a) : �迭�� ���޹޾� ��� �迭 ��Ұ��� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("����� ���� = "+Arrays.toString(lotto));
	}

}
