package kr.hs.dgsw.c2.d0609;

import java.util.Scanner;

public class PlusCalculator extends Calculator{
    
	@Override
	public void calculate(int value1, int value2) {
		int result = value1 + value2;
		System.out.println();
	}

	public static void main(String[] args) {
		Calculate2 calculate = new Calculate2();
		CalculateStrategy strategy = new PlusStrategy();
		
		calculate.execute(strategy);
	}
}