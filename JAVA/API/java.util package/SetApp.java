package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set �������̽��� ��ӹ޴� �ڷᱸ�� Ŭ���� - HashSet, LinkedHashSet, TreeSet ��
// => ���� ������ ������ ������ ���� ����� �ν��Ͻ��� �������� �ʴ� �ڷᱸ�� Ŭ����
public class SetApp {
	public static void main(String[] args) {
		//���׸��� ������� ���� ��� �⺻������ ��� �ν��Ͻ��� Object Ÿ������ ���� - �����
		// => ��� Ŭ������ �ν��Ͻ��� Set �ν��Ͻ��� ���� ����
		// => ����� �ν��Ͻ��� ��ȯ�޾� ����� ��� �ݵ�� ����� ��ü ����ȯ �� ���
//		HashSet set=new HashSet<E>();
		
		//���׸� Ÿ�Կ� �ڷ����� �����Ͽ� Set �ν��Ͻ� ���� - ����
		// => ���׸� Ÿ������ ���޵� �ڷ����� �ν��Ͻ����� Set �ν��Ͻ��� ���� ����
		// => ����� �ν��Ͻ��� ����� ��ü ����ȯ ���� ��ȯ�޾� ���
//		HashSet<String> set=new HashSet<String>();
		
		//���������� �������̽�(�θ�)�� �̿��Ͽ� �����ϴ� ���� ����
		// => �������̽��� ��ӹ��� ��� �ڽ� Ŭ������ �ν��Ͻ� ����
		// => Ŭ���� ���� ���յ��� ���߾� ���������� ȿ���� ����
		Set<String> set=new HashSet<String>();
		
		//Set.add(E element) : Set �ν��Ͻ��� ���(Element)�� �߰��ϴ� �޼ҵ�
		set.add("ȫ�浿");
//		set.add(100);//���׸� Ÿ������ ���޵� �ڷ����� �ν��Ͻ��� �ƴ� ��� ���� �߻�
		set.add("�Ӳ���");
		set.add("����ġ");
		set.add("������");
		
		//Set.toString() : Set �ν��Ͻ��� ����� ��� ��Ҹ� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
//		System.out.println("set.toString() = "+set.toString());
		System.out.println("set = "+set);
		System.out.println("===========================================================");
		//Set �ν��Ͻ����� ������ ���� ��Ұ� �ߺ� ���� �Ұ�
		set.add("ȫ�浿");
		System.out.println("set = "+set);
		System.out.println("===========================================================");
		//Set.remove(E element) : Set �ν��Ͻ��� ����� ��Ҹ� �����ϴ� �޼ҵ�
		// => ���(�ν��Ͻ�)�� ���� ���Ͽ� ����
		set.remove("�Ӳ���");
		System.out.println("set = "+set);
		System.out.println("===========================================================");
		//Set.size() : Set �ν��Ͻ��� ����� ����� ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println("set.size() = "+set.size());
		System.out.println("===========================================================");
		//Set.iterator() : Set �ν��Ͻ��� ����� ��Ҹ� �ݺ� ó���ϱ� ���� Iterator �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Iterator : �ڷᱸ�� �ν��Ͻ��� ���� �ݺ� ó�� ����� �����Ǵ� �������̽� - �ݺ�������
		Iterator<String> iterator=set.iterator();
		
		//Iterator.hasNext() : Iterator �ν��Ͻ��� ó�� ������ ����� ���� ������ ��ȯ�ϴ� �޼ҵ�
		// => false : ó�� ��� ������, true : ó�� ��� ����
		while(iterator.hasNext()) {
			//Iterator.next() : Iterator �ν��Ͻ��� ó�� ������ ���� ��Ҹ� ��ȯ�ϴ� �޼ҵ�
			// => ���� ��Ҹ� ��ȯ�ϰ� ���� ��ҷ� �̵� ó��
			String str=iterator.next();
			System.out.println(str+" ");
		}
		System.out.println();
		System.out.println("===========================================================");

		//������ for ������ ���������� Iterator �ν��Ͻ��� ����Ͽ� �ݺ� ó��
		for(String name:set) {
			System.out.print(name+" ");
		}
		System.out.println();
		System.out.println("===========================================================");
	}
}
