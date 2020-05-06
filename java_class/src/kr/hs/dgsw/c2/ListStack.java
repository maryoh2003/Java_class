package kr.hs.dgsw.c2;

import java.util.ArrayList;

public class ListStack {
	
	private ArrayList<String> list = new ArrayList<String>();
	
	public void push(String value) {
		list.add(value);
	}
	
	public String pop() {
		return list.remove(list.size() -1);
	}

	public static void main(String[] args) {
		
		ListStack stack = new ListStack();
		
		stack.push("���Ѽ�");
		stack.push("�̿���");
		stack.push("���ֿ�");
		stack.push("�̿���");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
