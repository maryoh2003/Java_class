package afterscl0623;

import java.util.Scanner;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            arr[i] = scan.nextInt();
        }

        check(arr);
        System.out.println();
    }
    
    static void check(int[] arr) {
    	  for(int i = 0; i < 9; i++) {
              for(int j = 0; j < 9; j++) {
                  if(arr[j] > arr[j + 1]) {
                      ascending(arr);
                  } else {
                	  for (int k = 0; k<10; k++) {
                		  System.out.print(arr[i] + " ");
                	  }
                  }
             } 
        }
 }


    static void ascending(int[] arr) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < 10; i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}
