package xyz.itwill.util;

//���׸� Ÿ���� �ʵ尡 ����� Ŭ������ �ν��Ͻ��� �����Ͽ� ����ϴ� ���α׷�
// => ���׸� Ÿ�Կ� ���޵� �ڷ����� �ν��Ͻ��� �ʵ忡 ���� ����
// => �ʵ尪�� ��ȯ���� �� ����� ��ü ����ȯ ���ʿ�
public class GenericApp {
	public static void main(String[] args) {
		//���׸� Ÿ���� ����� �ڷ������� ���׸� ��� ǥ���� �ڷ���(������)�� �����ؾ߸� ��� ����
		// => ���׸� Ÿ���� �ʵ尡 ���޵� �ڷ����� �ʵ�� ��ȯ
		Generic<Integer> generic1=new Generic<Integer>();
		
		//�ʵ�� ������ �ڷ����� �ν��Ͻ��� �����Ͽ� �ʵ忡 ����
		// => �ʵ�� �ٸ� �ڷ����� �ν��Ͻ��� ������ ��� ���� �߻�
		// => �ʵ忡 �������� �ν��Ͻ��� ���� ����
		generic1.setField(100);
//		generic1.setField(12.34);
				
		Integer returnObject1=generic1.getField();
		
		System.out.println("�ʵ尪 = "+returnObject1.intValue());
		System.out.println("=================================================================");
		Generic<Double> generic2=new Generic<Double>();
		
		generic2.setField(12.34);
		
		Double returnObject2=generic2.getField();
		
		System.out.println("�ʵ尪 = "+returnObject2.doubleValue());
		System.out.println("=================================================================");
		
		Generic<String> generic3=new Generic<String>();
		
		generic3.setField("ȫ�浿");
		
		String returnObject3=generic3.getField();
		
		System.out.println("�ʵ尪 = "+returnObject3.trim());
		System.out.println("=================================================================");
		
	}
}
