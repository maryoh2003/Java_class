package kr.hs.dgsw.c2.d0506;

public abstract class Calculator {
	
	protected int value1;
	
	protected int value2;
	
	
	public void setOperand(int value1, int value2)
	{
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public abstract int calculate();
	
	
	public void print()
	{
		System.out.println(String.format("%d %s %d = %d", value1, getOperator(), value2, calculate()));
	}
	
	public abstract String getOperator();
	
	public static void main(String[] args) {
		
		Calculator adder = new Adder();
		Calculator subtractor = new Subtractor();
		
		adder.setOperand(8, 5);
		adder.print();
		
		subtractor.setOperand(8,  5);
		subtractor.print();
		
	}
}