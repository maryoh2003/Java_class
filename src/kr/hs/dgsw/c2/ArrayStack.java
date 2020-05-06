package kr.hs.dgsw.c2;

public class ArrayStack {
	
	private String[] array = new String[100];
	
	private int index = 0;
	
	public void push(String value) {
		array[index] = value;
		index++;
	}
	
	public String pop() {
		index--;
		return array[index];
	}

	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack();
		
		stack.push("최한수");
		stack.push("이원제");
		
		System.out.println(stack.pop());
		
		stack.push("김주엽");
		stack.push("이영은");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
