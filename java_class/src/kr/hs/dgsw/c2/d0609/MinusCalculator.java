package kr.hs.dgsw.c2.d0609;

import java.util.Scanner;

public class MinusCalculator extends Calculator{
 
	@Override
	public void calculate(int value1, int value2) {
		int result = value1 - value2;
		System.out.println(String.format("%d - %d = %d", value1, value2, result));
	}

    public static void main(String[] args) {
        Calculator calculator = new MinusCalculator();
        calculator.execute();
    }
}
