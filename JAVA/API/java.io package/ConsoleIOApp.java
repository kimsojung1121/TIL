package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

// Ű����� �̸��� �¾ �⵵�� �Է¹޾� �̸��� ���̸� ����ϴ� ���α׷�
public class ConsoleIOApp {
	public static void main(String[] args) throws IOException {
		// JAVA���� �����Ǵ� Ű���� �Է� ��Ʈ���� �뷮�� ���� ����Ÿ�� �Է� ���� �� �ִ� 
		// ����� �����ϴ� ��Ʈ������ ��뷮 �Է� ��Ʈ������ Ȯ���Ͽ� ����
		// System.in : JAVA���� �����Ǵ� Ű���� �Է� ��Ʈ������ ���� ����Ÿ�� ��ȯ�ϴ� ��� ���� �ϴ� ��Ʈ�� 
		// InputStreamReader : InputStream �ν��Ͻ��� ���޹޾� �Է� ��Ʈ���� Ȯ���Ͽ�
		// ����Ÿ �ϳ��� ��ȯ�ϴ� ��� �����ϴ� ��Ʈ��
		// BufferedReader : Reader �ν��Ͻ��� ���޹޾� �Է� ��Ʈ���� Ȯ���Ͽ� �緮�� ���� 
		// ����Ÿ(���ڿ�)�� ��ȯ�ϴ� ��� �����ϴ� ��Ʈ��
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// System.out :  Java���� �����Ǵ� ����� ��� ��Ʈ������ ���� ����Ÿ �ϳ��� ��ȯ�ϴ� ����� �����ϴ� ��Ʈ�� 
		// PrintStream Ŭ������ �̿��Ͽ� ������ ��� ��Ʈ��
		// print() �Ǵ� println() �޼ҵ带 �̿��Ͽ� ��� ���� ���� ����Ÿ�� ��ȯ�Ͽ� ����
		System.out.print("�̸� �Է� >> ");
		
		// BufferedReader.readLine() : �Է� ��Ʈ���� �����ϴ� ��� �Է°��� �̤��ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� 
		String name = in.readLine();
		
		System.out.print("�¾ �⵵ �Է� >> ");
		
		// Ű���� �Է°��� ���ڿ��� ��ȯ�޾� ���������� ��ȯ�Ͽ� ����
		int Birthyear = Integer.parseInt(in.readLine());
		
		int age = Calendar.getInstance().get(Calendar.YEAR)-Birthyear +1;
		
		System.out.println("[���]"+name+"���� ���̴� " + age+"���Դϴ�.");
	}
}
