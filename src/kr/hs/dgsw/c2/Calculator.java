package kr.hs.dgsw.c2;

public class Calculator {
	
	public int plus(int a, int b) {
		return a+b;
	}
	
	public int minus(int a, int b) {
		return a - b;
	}
	
	public int times(int a, int b) {
		return a*b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public double plus(double a, double b) {
		return a+b;
	}
	
	public double minus(double a, double b) {
		return a-b;
	}
	
	public double times(double a, double b) {
		return a*b;
	}
	
	public double divide(double a, double b) {
		return a/b;
	}
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		int intValue = calculator.plus(3, 5);
		double doubleValue = calculator.plus(3.14, 1.414);

	}

}
