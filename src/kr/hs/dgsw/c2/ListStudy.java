package kr.hs.dgsw.c2;

import java.util.ArrayList;
import java.util.Comparator;

public class ListStudy {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		String[] array = new String[10];
		
		array[0] = "�絿��";
		array[1] = "�ǿ��";
		array[2] = "������";
		
		System.out.println("0: " + array[0]);
		System.out.println("1: " + array[1]);
		System.out.println("2: " + array[2]);
		
		System.out.println("�迭�� ũ��: "+ array.length);
		
		list.add("�絿��");
		list.add("�ǿ��");
		list.add("������");
		
		System.out.println("0: "+ list.get(0));
		System.out.println("1: "+ list.get(1));
		System.out.println("2: "+ list.get(2));
		
		System.out.println("����Ʈ�� ũ��: "+list.size());
		
		System.out.println("���翩��: "+ list.contains("�輺��"));
		System.out.println("�ε���: "+ list.indexOf("������")); //�������� ������ �ε����� -1�� ���
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		System.out.println("���� ��");
		for(String item : list) {
			System.out.println(item);
		}
		
	}

}
