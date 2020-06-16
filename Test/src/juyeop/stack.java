package juyeop;

import java.util.Scanner;

public class stack {
	
	final static int MAX = 100;
    static int[] stack = new int[MAX];
    static int top = -1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        char[] arr;
        
        arr = scan.nextLine().toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(')
                push(i);
            else if(arr[i] == ')')
                System.out.printf("<%d, %d>", pop(), i);
        }
		
	}
	
	
	
	public static void parenthesis(char arr[])
	{
		int i = 0;
		for(char a : arr)
		{
			if(a =='(')
				push(i);
			else if(a == ')')
				System.out.printf("<%d, %d>\n", pop(), i);
			
			i++;
		}
	}
	
	public static int pop()
	{
		if(top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		
		return stack[top--];
	}
	
	public static void push(int t)
	{
		if(top > MAX -1) {
			System.out.println("Stack overflow");
			return;
		}
		
		stack[++top] = t; 
	}
}
