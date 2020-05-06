package kr.hs.dgsw.c2.d0506;

public class Adder extends Calculator {

	public int calculate()
	{
		return value1 + value2;
	}
	
	public String getOperator()
	{
		return "+";
	}
	
	public static void main(String[] args) {
		
		Adder adder = new Adder();
		adder.setOperand(4, 5);
		adder.print();
		
	}
}