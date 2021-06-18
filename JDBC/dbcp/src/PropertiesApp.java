package xyz.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties ���� : ���α׷� ���࿡ �ʿ��� ���� �����ϱ� ���� �ؽ�Ʈ ����
// => ���α׷��� �������� �ʰ� Properties ������ ������ �����Ͽ� ���α׷� ���� ��� ���� ����
// => ���α׷��� �������� ȿ���� ����
// => Properties ���Ͽ��� �����Ǵ� ���� ������ ���ڿ�(String)���θ� ����
// => Properties ���Ͽ����� ������, ����, �Ϻ� Ư�����ڸ� ������ ���ڴ� �����ڵ�� ǥ��

//user.properties ���Ͽ� ���� �����Ǵ� ���� ����ϴ� ���α׷�
public class PropertiesApp {
	public static void main(String[] args) throws IOException {
		//Properties ������ �б� ���� ���� �Է� ��Ʈ�� ����
		
		//FileInputStream Ŭ������ �̿��Ͽ� �Է� ��Ʈ�� ���� - ���� ��� ���� ���� �߻��� �� ����(��Ȯ�Ǽ�)
//		FileInputStream in=new FileInputStream("src/xyz/itwill/dbcp/user.properties");
		
		//ClassLoader ���α׷��� �̿��� �Է� ��Ʈ�� ����
		//Ŭ������.class : �޸𸮿� ����� Ŭ����(Class �ν��Ͻ� - Clazz)�� ���� ǥ���ϴ� ���
		//Class.getClassLoader() : Ŭ������ �о� �޸𸮿� �����ϴ� ����� �����ϴ� ClassLoader �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//ClassLoader.getResourceAsStream(String resource) : ���ҽ� ������ ��θ� ���޹޾� ������ �б� ���� 
		//�Է� ��Ʈ���� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		InputStream in=PropertiesApp.class.getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties");
		
		//Properties Ŭ������ �ν��Ͻ� ����
		// => Properties Ŭ������ Map �������̽��� ��ӹ��� �ݷ��� Ŭ����
		// => Properties �ν��Ͻ����� Key�� Value�� �ϳ��� ��(Entry)���� ó���Ͽ� ����
		Properties properties=new Properties();
		
		//Properties.load(InputStream in) : Properties ���Ͽ� ����� ��� Key�� Value�� ���� 
		//Properties �ν��Ͻ��� ��Ʈ��(Key:String, Value:String)�� �߰��Ͽ� �����ϴ� �޼ҵ�
		properties.load(in);
		
		//Properties �ν��Ͻ��� ����� ��(Value)�� �ĺ���(Key)�� �̿��Ͽ� ��ȯ�޾� ����
		//Properties.get(String key) : Properties �ν��Ͻ��� ����� ��Ʈ������ �ĺ���(Key)��
		//�̿��Ͽ� ��(Value)�� ��ȯ�ϴ� �޼ҵ�
		// => ��ȯ���� Object Ÿ������ ��ȯ�ǹǷ� �ݵ�� ����� ��ü ����ȯ�Ͽ� ����
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("���̵� = "+id);
		System.out.println("��й�ȣ = "+password);
		System.out.println("�̸� = "+name);
		
	}//end of main
}//end of class
