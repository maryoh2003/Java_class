package kr.hs.dgsw.c2.d0506;

public class Subtractor extends Calculator {

	public int calculate()
	{
		return value1 - value2;
	}
	
	public String getOperator()
	{
		return "-";
	}
	
	public static void main(String[] args) {
		
		Subtractor subtractor = new Subtractor();
		subtractor.setOperand(4, 5);
		subtractor.print();
		
	}
}