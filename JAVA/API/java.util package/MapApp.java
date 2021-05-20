package xyz.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map �������̽��� ��ӹ޴� �ڷᱸ�� Ŭ���� : HanMap, Hashtable, Properties ��
// => �̸�(Key)�� ��(Value:�ν��Ͻ�)�� �ϳ��� ��(��Ʈ��:Entry)���� ��� �����ϴ� �ڷᱸ�� Ŭ����
// => Ű�� �̿��Ͽ� ���� ������ �˻��ϱ� ���� ���
public class MapApp {
	public static void main(String[] args) {
		//Map �������̽��� ��ӹ��� �ڷᱸ�� Ŭ������ Ű�� ���� ���׸� Ÿ�Կ� �ڷ��� ����
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		//Map.put(K key, V value) : Map �ν��Ͻ��� ��Ʈ���� �߰��ϴ� �޼ҵ�
		// => Ű�� ���������� Set �������̽� Ÿ������ ����Ǹ� ���� Collection �������̽� Ÿ������ ����
		// => Ű�� �ߺ����� ������ �������� ����
		map.put(1000, "ȫ�浿");//����ڽ�
		map.put(2000, "�Ӳ���");
		map.put(3000, "����ġ");
		map.put(4000, "������");
		map.put(5000, "����");
		
		//Map.toString() : Map �ν��Ͻ��� ����� ��� ��Ʈ���� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
//		System.out.println("map.toString() = "+map.toString());
		System.out.println("map = "+map);
		System.out.println("=========================================================");
		//Map.put() �޼ҵ� ȣ��� ���޵� ��Ʈ���� Ű�� �ߺ��� ��� ��Ʈ���� ���� ����
		map.put(2000, "�Ӱ���");
		System.out.println("map = "+map);
		System.out.println("=========================================================");
		//Map.remove(K key) : Map �ν��Ͻ��� ����� ��Ʈ�� �� ���޹��� Ű�� ���� ��Ʈ���� �����ϴ� �޼ҵ�
		map.remove(4000);
		System.out.println("map = "+map);
		System.out.println("=========================================================");
		//Map.get(K key) : Map �ν��Ͻ��� ����� ��Ʈ�� �� ���޹��� Ű�� ���� ��Ʈ���� ���� ��ȯ�ϴ� �޼ҵ�
		String name=map.get(1000);
		System.out.println("name = "+name);
		System.out.println("=========================================================");
		
		//�ϰ�ó��(Map�� �ϰ�ó���� �������� ���� ����, get���� ���� ��ȯ�ϴ� ���� ����)
		//Map.values() : Map �ν��Ͻ��� ����� ��� ��Ʈ���� ���� Collection �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		Iterator<String> iteratorValue=map.values().iterator();
		while(iteratorValue.hasNext()) {
			System.out.print(iteratorValue.next()+" ");
		}
		System.out.println();
		System.out.println("=========================================================");
		//Map.keySet() : Map �ν��Ͻ��� ����� ��� ��Ʈ���� Ű�� Set �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		Iterator<Integer> iteratorKey=map.keySet().iterator();
		while(iteratorKey.hasNext()) {
			Integer key=iteratorKey.next();
			System.out.print(key+" = "+map.get(key));
		}
		System.out.println();
		System.out.println("=========================================================");
		for(String value:map.values()) {
			System.out.print(value+" ");
		}
		System.out.println();
		System.out.println("=========================================================");
		for(Integer key:map.keySet()) {
			System.out.println(key+" = "+map.get(key));
		}
		System.out.println("=========================================================");
	}
}
