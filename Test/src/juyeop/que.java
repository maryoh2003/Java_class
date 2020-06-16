package juyeop;

import java.util.Scanner;

public class que {

	static final int MAX = 100;
    static char[] stack = new char[MAX];
    static char[] queue = new char[MAX];
    static int stackTop = -1;
    static int queueTop = -1;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();

        for(int i = 0; i < input.length; i++){
            push(input[i]);
            enqueue(input[i]);
        }

        queueTop = 0;

        for(int i = 0; i < input.length / 2; i++){
            if(pop(i) != dequeue(i)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");

    }

    public static void push(char item){
        stack[++stackTop] = item;
    }

    public static char pop(int index){
        return stack[stackTop--];
    }

    public static void enqueue(char item){

        queue[++queueTop] = item;
    }

    public static char dequeue(int index){
        return queue[queueTop++];
    }
}
