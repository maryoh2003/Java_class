package kr.hs.dgsw.c2.d0609;

public class MinusStrategy implements CalculateStrategy{
	@Override
	public void calculate(int value1, int value2) {
		int result = value1 + value2;
		System.out.println(String.format("%d + %d = %d", value1, value2, result));
	}
	
}
