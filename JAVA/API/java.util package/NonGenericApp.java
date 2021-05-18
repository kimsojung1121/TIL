package xyz.itwill.util;

//Object Ÿ���� �ʵ尡 ����� Ŭ������ �ν��Ͻ��� �����Ͽ� ����ϴ� ���α׷�
// => Object Ÿ���� �ʵ忡�� ��� Ŭ������ �ν��Ͻ��� �����Ͽ� ���� ����
// => Object Ÿ���� �ʵ忡 ����� �ν��Ͻ��� ��ȯ�޾� ����� ��� �ݵ�� ����� ��ü ����ȯ �� ���
public class NonGenericApp {
	public static void main(String[] args) {
		NonGeneric nonGeneric1=new NonGeneric();
		
		//Integer �ν��Ͻ��� �����Ͽ� Object Ÿ���� �ʵ忡 ����		
//		nonGeneric1.setField(Integer.valueOf(100));
		nonGeneric1.setField(100);//����ڽ�
		
		//�ʵ尪�� ������ Object Ÿ���� �ν��Ͻ��� ��ȯ - Object �ν��Ͻ��� �޼ҵ常 ȣ�� ����
		// => ����� ��ü ����ȯ�� �̿��Ͽ� �ڽ� �ν��Ͻ��� ��ȯ - �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
		Integer returnObject1=(Integer)nonGeneric1.getField();
		System.out.println("�ʵ尪 = "+returnObject1);//�����ڽ�
		
		//����� ��ü ����ȯ�� �߸��� ��� ClassCastException �߻�
//		Double doubleValue=(Double)nonGeneric1.getField();
		System.out.println("======================================================================");
		
		NonGeneric nonGeneric2=new NonGeneric();
		
		//Double �ν��Ͻ��� �Ű�����(Object)�� �����Ͽ� Object Ÿ���� �ʵ忡 ����
		nonGeneric2.setField(12.34);
		
		//instanceof �����ڸ� �̿��Ͽ� ����� ��ü ����ȯ ���� ����
		if(nonGeneric2.getField() instanceof Double) {
			Double returnObject2=(Double)nonGeneric2.getField();
			System.out.println("�ʵ尪 = "+returnObject2.doubleValue());
		}
		System.out.println("======================================================================");
		
		NonGeneric nonGeneric3=new NonGeneric();
		
		//String �ν��Ͻ��� �Ű�����(Object)�� �����Ͽ� Object Ÿ���� �ʵ忡 ����
		nonGeneric3.setField("ȫ�浿");
		
		String returnObject3=(String)nonGeneric3.getField();
		
		System.out.println("�ʵ尪 = "+nonGeneric3.getField());
		System.out.println("�ʵ尪 = "+returnObject3.toString());
		
	}
}
