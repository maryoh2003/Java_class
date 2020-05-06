package kr.hs.dgsw.c2.d0506;

public class Multiplier extends Calculator{
	
	public int calculate()
	{
		return value1 * value2;
	}
	
	public String getOperator()
	{
		return "x";
	}
	
	public static void main(String[] args) {
		
		Multiplier multiply = new Multiplier();
		multiply.setOperand(4, 5);
		multiply.print();
		
	}
}
