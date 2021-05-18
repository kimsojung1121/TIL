package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List �������̽��� ��ӹ޴� �ڷᱸ�� Ŭ���� : ArrayLsit, Vector, LinkedList ��
// => ����� ���� ������ �����Ͽ� ÷�ڸ� �̿��Ͽ� ��� ó��
// => ������ ���� ��� �ߺ� ���� ����

public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : List �ν��Ͻ��� ���(Element)�� �߰��ϴ� �޼ҵ�
		list.add("ȫ�浿");
		list.add("�Ӳ���");
		list.add("����ġ");
		list.add("������");
		
		//List.toString() : List �ν��Ͻ��� ����� ��� ��Ҹ� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
//		System.out.println("list.toString() = "+list.toString());
		System.out.println("list = "+list);
		System.out.println("=================================================================");
		list.add("�Ӳ���");
		System.out.println("list = "+list);
		System.out.println("=================================================================");
		//List.size() : List �ν��Ͻ��� ����� ����� ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println("list.size() = "+list.size());
		System.out.println("=================================================================");
		
		//List.get(int index) : List �ν��Ͻ��� ����� ��� �� ÷�� ��ġ�� ��Ҹ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("list.get(2) = "+list.get(2));
		System.out.println("=================================================================");
		//List.add(int index, E element) : List �ν��Ͻ��� ���ϴ� ��ġ�� ��Ҹ� �����ϴ� �޼ҵ�
		list.add(4, "����");
		System.out.println("list = "+list);
		System.out.println("=================================================================");
		//List.remove(E element) : List �ν��Ͻ��� ����� ��Ҹ� �����ϴ� �޼ҵ�
		// => ���(�ν��Ͻ�)�� ���� ���Ͽ� ����
		// => ���� ���� ����� ��Ұ� ���� ���� ��� �պκ��� ��� �ϳ��� ����
//		list.remove("�Ӳ���");
		//List.remove(int index) : List �ν��Ͻ��� ����� ��� �� ���ϴ� ��ġ�� ��Ҹ� �����ϴ� �޼ҵ�
		list.remove(5);
		System.out.println("list = "+list);
		System.out.println("=================================================================");	
		//List.set(int index, E element) : List �ν��Ͻ��� ����� ��� �� ���ϴ� ��ġ�� ��Ҹ� �����ϴ� �޼ҵ�
		list.set(1, "�Ӱ���");
		System.out.println("list = "+list);
		System.out.println("=================================================================");	
		//List �ν��Ͻ��� ��ҿ� ���� ÷�ڸ� �̿��� �ϰ�ó��
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("=================================================================");
		//�ݺ�������(Iterator)�� �̿��� �ϰ�ó��
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("=================================================================");
		//������ for ������ �̿��� �ϰ�ó��
		for(String name:list) {
			System.out.println(name+" ");
		}
		System.out.println();
		System.out.println("=================================================================");

		//Collections : List �ν��ͽ��� ���� ��� ó�� ����� �����ϴ� Ŭ����
		//Collections.sort(List list) : List �ν��Ͻ��� ���޹޾� List �ν��Ͻ��� ��Ҹ� �����ϴ� �޼ҵ�
		Collections.sort(list);
		System.out.println("list = "+list);
		//List.clear() : List �ν��Ͻ��� ����� ��� ��Ҹ� �����Ͽ� �ʱ�ȭ ó���ϴ� �޼ҵ�
		list.clear();
		
		//List.isEmpty() : List �ν��Ͻ��� ��Ұ� �ϳ��� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(list.isEmpty()) {
			System.out.println("List �ν��Ͻ��� ����� ��Ұ� �ϳ��� �����ϴ�.");
		}
		System.out.println("=================================================================");
		//Arrays.asList(E...element) : 0�� �̻��� ��Ҹ� ���޹޾� List �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		List<Integer> numList=Arrays.asList(10,20,30,40,50);
		System.out.println("numList = "+numList);
		System.out.println("=================================================================");
	}
}
