package xyz.itwill.util;

import java.util.Scanner;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

//����ǥ����(Regular Expression) : Meta ����, Escape ���� ���� �̿��Ͽ� ������ ��Ģ�� ���ڿ��� ǥ���ϴ� ���
/*
^���� : ����(��)�� ���۵��� �ǹ�
����$ : ����(��)�� ������� �ǹ�
. : ������ ���� �ϳ��� �ǹ�(\ ���� ǥ�� �Ұ���)
[����1����2����3] : ������ ���ڵ� �� �ϳ��� �ǹ�
[^����1����2����3] : ������ ���ڵ��� �ƴ� ���ڵ� �� �ϳ��� �ǹ�
[����1-����2] : ����1���� ����2 ������ ���� �� �ϳ��� �ǹ�
[���ڿ�|���ڿ�|���ڿ�|] : ������ ���ڿ��� �� �ϳ��� �ǹ�
���ڿ�+ : ���ڿ��� 1�� �̻� �ݺ����� �ǹ�
���ڿ�* : ���ڿ��� 0�� �̻� �ݺ����� �ǹ�
���ڿ�? : ���ڿ��� 0�� �Ǵ� 1�� �������� �ǹ�
���ڿ�{����} : ���ڿ��� ���ڸ�ŭ �ݺ����� �ǹ�
���ڿ�{����1,����2} : ���ڿ��� ����1���� ����2��ŭ �ݺ����� �ǹ�
(?!)���ڿ� : ���ڿ����� ��ҹ��ڸ� �������� ������ �ǹ�
(?=)���ڿ� : ���ڿ��� �ݵ�� �����ϰ� ������ �ǹ�
(?!���ڿ�) : ���ڿ��� �ݵ�� �����ϰ� ���� ������ �ǹ�

\s : ������ �����ϴ� ���ڿ��� �ǹ�
\S : ������ �������� �ʴ� ���ڿ��� �ǹ�
\w : ������, ����, Ư������(_)�� ���ڷθ� ������ ���ڿ��� �ǹ�
\W : ������, ����, Ư������(_)�� ���ڸ� ������ ���ڵ�� ������ ���ڿ��� �ǹ�
\d : ���� ������ ���ڷθ� ������ ���ڿ��� �ǹ�
\D : ���� ������ ���ڸ� ������ ���ڵ�� ������ ���ڿ��� �ǹ�
\��Ÿ���� : ��Ÿ���ڸ� �Ϲݹ��ڷ� ǥ��
*/
//Ű����� �Էµ� ���ڿ��� ���� ���� ���α׷��� �ۼ��ϼ���.
// => ���Ŀ� ���� ���� ���ڿ��� �Է��� ��� ���α׷� ���� - ��ȿ�� �˻�
public class ValidationApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

/*		
		System.out.print("���̵� �Է� >> ");
		String id=scanner.nextLine();
		
		//�Է°� ���翡 ���� ���� - ������ �Ǵ� �޼ҵ带 �̿��� ��ȿ�� �˻�
		if(id==null || id.equals("")) {
			System.out.println("[����]���̵� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//�Է°� ���Ŀ� ���� ���� - ���� ǥ������ �̿��� ��ȿ�� �˻�
		//���̵� �Է±�Ģ - �����ڷ� ���۵Ǹ� ������,����,Ư������(_)�� �������� 6~20 ������ ���ڷ� ǥ��
		//java.util.regex.Pattern : ���� ǥ������ �����ϱ� ���� Ŭ����
		//Pattern.matches(String regex, CharSequence input) : ���� ǥ���İ� �Է°���
		//���޹޾� �Է°��� ���� ��Ģ�� ���Ͽ� ����� ��ȯ�ϴ� �޼ҵ� 
		// => false : ����ġ, true : ��ġ
//		if(!Pattern.matches("^[a-zA-Z][a-zA-Z0-9_] {5,19}$", id)) {
//			System.out.println("[����]�Է��� ���̵�� ���Ŀ� ���� �ʽ��ϴ�.");
//			System.exit(0);
//		}
		

		//Pattern.compile(String regex) : ���� ǥ������ ���޹޾� Pattern �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		Pattern idPattern=Pattern.compile("^[a-zA-Z]\\w{5,19}$");
		
		//java.util.regex.Matcher : ����ǥ���İ� �� ���ڿ��� �����ϱ� ���� Ŭ����
		// => ���� ǥ���İ� ���ڿ��� ���ϴ� ��� �� ���� �Ǵ� ���� ó���ϴ� ��� ���� - ���а� ����ǥ���� Ȱ�� ����
		//Pattern.matcher(CharSequence input) : Pattern �ν��Ͻ��� ����� ���� ǥ���Ŀ�
		//�� ���ڿ��� �����޾� ������ Matcher �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		Matcher idMatcher=idPattern.matcher(id);
		
		//Matcher.matches() : Matcher �ν��Ͻ��� ����� ���� ǥ���İ� ���ڿ��� ���� ��Ģ�� 
		//���Ͽ� ����� ��ȯ�ϴ� �޼ҵ�
		// => false : ����ġ, true : ��ġ
		if(!idMatcher.matches()) {
			System.out.println("[����]�Է��� ���̵�� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		
		System.out.println("[�޼���]���Ŀ� �´� ���̵� �ԷµǾ����ϴ�.");
		scanner.close();
*/
		
		
/*		
		System.out.print("��й�ȣ �Է� >> ");
		String password=scanner.nextLine();
		
		if(password==null || password.equals("")) {
			System.out.println("[����]��й�ȣ�� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//��й�ȣ ��Ģ - ������, ����, Ư�����ڸ� �ݵ�� 1�� �̻� �����Ͽ� 8~30 ������ ���ڷ� ǥ��
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]){8,30}$";
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[����]�Է��� ��й�ȣ�� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		System.out.println("[�޼���]���Ŀ� �´� ��й�ȣ�� �ԷµǾ����ϴ�.");
*/
		
		System.out.print("�̸��� �Է� >> ");
		String email=scanner.nextLine();
		
		if(email==null || email.equals("")) {
			System.out.println("[����]�̸����� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//�̸��� ��Ģ - [����ڸ�@�����θ�] ������ ���ڿ��� ǥ��
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[����]�Է��� �̸����� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		System.out.println("[�޼���]���Ŀ� �´� �̸����� �ԷµǾ����ϴ�.");
		
		scanner.close();
	}
}
