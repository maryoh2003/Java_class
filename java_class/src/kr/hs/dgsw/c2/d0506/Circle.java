package kr.hs.dgsw.c2.d0506;

public class Circle extends Polygon {
	
	private static final double PI = 3.14;

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public String getName() {
		return "��";
	}
	
	@Override
	public void print()
	{
		System.out.println(String.format("������: %.2f ����: %.2f", radius, getArea()));
	}

}
