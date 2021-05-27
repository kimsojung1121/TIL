package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

//File : ���� ����(���ϰ��, ���ϱ���, ����ũ�� ��)�� �����ϱ� ���� Ŭ����
// => ����(���丮)�� ���Ϸ� �νĵǾ� File Ŭ������ ǥ�� ����
//File �ν��Ͻ��� ���� �޼ҵ带 ���� ������ �� �ִ�
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File(String pathname) : �ý���(�ü��)�� ���ϰ�θ� ���޹޾� File �ν��Ͻ��� �����ϴ� ������
		//�ý��� ���ϰ��(System File path) : �ý��ۿ� �����ϴ� ���� ��ġ�� ǥ���ϱ� ���� ���
		// => ������ ǥ�����, ����� ǥ�����
		//������ : �ֻ��� ����(����̺�)�� �������� ������ ��ġ�� ǥ���ϴ� ���
		//����� : ���� ���� ���α׷��� �۾� ������ �������� ������ ��ġ�� ǥ���ϴ� ���
		// => ��Ŭ���������� ������Ʈ ������ �۾� ������ ó��
//		����κ��ٴ� �����η� ǥ���ϴ� ���� ����(����δ� ��Ȯ�Ǽ��� ����)
		//Windows �ü�������� ����(����̺�)�� ������ �����ϱ� ���� '\' ��ȣ ���
		// => Java������ '\' ��ȣ�� Escape ���ڸ� ǥ���ϴ� �뵵�� ���
		// => '\' ��ȣ�� ���ڷ� ǥ���ϱ� ���ؼ��� '\\' ���·� ǥ��
		File fileOne=new File("C:\\data");
		
		//File.exists() : File �ν��Ͻ��� ����� ���ϰ�ο� ������ �������� ���� ��� false�� ��ȯ�ϰ�
		//�����ϴ� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(fileOne.exists()) {
			System.out.println("c:\\data ������ �����մϴ�.");
		} else {
			//File.mkdir() : File �ν��Ͻ��� ����� ���ϰ�ο� ������ �����ϴ� �޼ҵ�
			fileOne.mkdir();
			System.out.println("c:\\data ������ �����Ͽ����ϴ�.");
		}
		System.out.println("=======================================================================");
//		File fileTwo=new File("c:\\data\\abc.txt");
		//Windows �ü���� ������ ������ �ü�������� ����(����̺�)�� ������ �����ϱ� ����
		// '/' ��ȣ ��� - ���� ��θ� ǥ���� �� '\' ��ȣ ��� '/' ��ȣ�� ����ϴ� ���� ����
		File fileTwo=new File("c:/data/abc.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\abc.txt ������ �����մϴ�.");
		} else {
			//File.createNewFile() : File �ν��Ͻ��� ����� ���ϰ�η� ������ �����ϴ� �޼ҵ�
			// => IOException �߻�
			fileTwo.createNewFile();
			System.out.println("c:\\data\\abc.txt ������ �����Ͽ����ϴ�.");
		}
		System.out.println("=======================================================================");
		
//		File fileThree=new File("c:/data/xyz.txt");
		//File(File parent, String child) ������ �Ǵ� File(String parent, String child) ������
		// => ���ϰ�θ� �θ�(���� ���)�� �ڽ�(���ϸ�)���� �����Ͽ� File �ν��Ͻ��� �����ϴ� ������
//		File fileThree=new File(fileOne,"xyz.txt");
		File fileThree=new File("c:/data","xyz.txt");
		
		if(fileThree.exists()) {
			fileThree.delete();
			System.out.println("c:\\data\\xyz.txt ������ �����Ͽ����ϴ�.");
		} else {
			System.out.println("c:\\data\\xyz.txt ������ �������� �ʽ��ϴ�.");			
		}
		System.out.println("=======================================================================");
	
		//���ϰ�θ� ����� ǥ��������� �����Ͽ� File �ν��Ͻ� ����
		// => ���� �۾� ������ �⺻������ ������Ʈ ������ ����
		// => [..] �������� ���� ������ ǥ���ϸ� [������(���ϸ�)] �������� ���� ���� �Ǵ� ���� ǥ��
		File fileFour=new File("src");
		
		if(fileFour.exists()) {
			//File.toString() : File �ν��Ͻ��� ����� ���ϰ�θ� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
//			System.out.println("���ϰ�� = "+fileFour.toString());			
			System.out.println("���ϰ�� = "+fileFour);		// ��� ��� : ���ϰ�� = src
			//File.getAbsolutepath() : File �ν��Ͻ��� ����� ���ϰ�θ� ������ ǥ������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			System.out.println("���ϰ�� = "+fileFour.getAbsolutePath());			
		} else {
			System.out.println("�۾� ������ src ���� ������ �������� �ʽ��ϴ�.");
		}
		System.out.println("=======================================================================");
		
//		File fileFive=new File("/"); //Mac �ֻ��� ���丮
		File fileFive=new File("c:/"); //Window �ֻ��� ���丮
		
		//File.isDirectory() : File �ν��Ͻ��� ����� ���ϰ�ΰ� ������ �ƴ� ��� false�� ��ȯ�ϰ� 
		//������ ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(fileFive.isDirectory()) {
			//File.listFiles() : File �ν��Ͻ��� ����� ���ϰ���� �ڽ� ���� ����� File �ν��Ͻ� �迭�� ��ȯ�ϴ� �޼ҵ�
			File[] subFiles=fileFive.listFiles();
			
			System.out.println(fileFive+" ������ �ڽ� ��� >> ");
			for(File file:subFiles) {
				//File.isFile() : File �ν��Ͻ��� ����� ���ϰ�ΰ� ������ �ƴ� ��� false�� ��ȯ�ϰ� 
				//������ ��� true�� ��ȯ�ϴ� �޼ҵ�
				if(file.isFile()) {
					System.out.println("���� = "+file);
				} else {
					System.out.println("���� = "+file);					
				}
			}
		}
		System.out.println("=======================================================================");
	}//end of main
}//end of class
