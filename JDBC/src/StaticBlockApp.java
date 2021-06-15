package xyz.itwill.jdbc;

public class StaticBlockApp {
	public static void main(String[] args) {
		/*
		//ClassLoader ���α׷��� ���� Ŭ����(Class ����)�� �о� �޸𸮿� ���� - �ڵ�(1��)
		//new �����ڰ� �޸𸮿� ����� Ŭ����(Clazz)�� �����ڸ� ȣ���Ͽ� �ν��Ͻ� ����
		// => ������ �ν��Ͻ��� ���������� ����
		StaticBlock sb=new StaticBlock();
		
		//���������� ����� �ν��Ͻ��� �޼ҵ� ȣ�� - ��� ����
		sb.display();
		*/
		
		
		
		
		/*
		//Class : Ŭ���� ������ �����ϱ� ���� Ŭ����
		
		//Class.forName(String className) : ���ڿ��� ǥ���� ��Ű���� ������ Ŭ������ ���޹޾�
		//ClassLoader ���α׷��� �̿��Ͽ� Ŭ������ �о� �޸𸮿� �����ϴ� �޼ҵ�
		// => �޸𸮿� ����� Ŭ���� ����(Class �ν��Ͻ� - Clazz) ��ȯ
		// => ClassNotFoundException �߻� - ����ó��
		
		//Class.newInstance() : �޸𸮿� ����� Ŭ����(Clazz)�� �⺻ �����ڸ� �̿��Ͽ� �ν��Ͻ��� �����ϴ� �޼ҵ�
		// => InstantiationException, IllegalAccessException �߻�
		// => Object Ÿ���� �ν��Ͻ��� ��ȯ : ����� ��ü ����ȯ
		//���÷���(Reflection) : Ŭ������ ���� �޸𸮿� �����Ͽ� �ν��Ͻ��� �����ϴ� ���
		try {
			StaticBlock sb=(StaticBlock)Class.forName("xyz.itwill.jdbc.StaticBlock").newInstance();
			sb.display();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[����]Ŭ������ ã�� �� �����ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[����]���� ���α׷��� ������ �߻��Ͽ����ϴ�.");
		}
		*/
		
		
		try {
			//������������ �ν��Ͻ��� �����Ǿ� �޼ҵ� ȣ��
			Class.forName("xyz.itwill.jdbc.StaticBlock");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[����]Ŭ������ ã�� �� �����ϴ�.");
		}
	}//end of main
}//end of class
