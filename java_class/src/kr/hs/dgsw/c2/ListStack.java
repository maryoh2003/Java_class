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
		
		stack.push("최한수");
		stack.push("이원제");
		stack.push("김주엽");
		stack.push("이영은");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
