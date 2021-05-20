package xyz.itwill.util;

import java.text.DecimalFormat;

//java.text.DecimalFormat : 
public class DecimalFormatApp {
	public static void main(String[] args) {
		//DecimalFormat(String pattern) : 10���� �������� ���� ���������� ���޹޾�
		//�ν��Ͻ��� �����ϱ� ���� ������
		// => ���Ϲ��� : #(����-����), 0(����-0), $(ȭ���ȣ) ��
//		DecimalFormat decimalFormat=new DecimalFormat("###,###,###,##0");
		DecimalFormat decimalFormat=new DecimalFormat("$###,###,###,##0");
		
		long money=10_000_000_000L;
		
		System.out.println("�ݾ� = "+money+"��");
		
		//decimalFormat.format(Number o) : ���޹��� ���ڰ��� decimalFormat �ν��Ͻ���
		//����� ���������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => ���޹��� ���ڰ��� ������ ���̸� �ʰ��ص� ���������� ��ȯ�Ǿ� ��ȯ
		System.out.println("�ݾ� = "+decimalFormat.format(money)+"��");
		
		//DecimalFormat.getInstance() : �⺻ ���������� ������ DecimalFormat �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�ݾ� = "+DecimalFormat.getInstance().format(money)+"��");

		//DecimalFormat.getCurrencyInstance() : �⺻ ���������� ������ DecimalFormat �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => ��ȯ�Ǵ� ���ڿ� �տ� �ý��ۿ��� ���Ǵ� ȭ������� �߰��Ǿ� ��ȯ
		System.out.println("�ݾ� = "+DecimalFormat.getCurrencyInstance().format(money));
	}
}
