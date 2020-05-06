package kr.hs.dgsw.c2.d0506;

public abstract class Polygon {
	
	protected double height;
	
	protected double width;
	
	protected double radius;

	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public abstract double getArea();
	
	public void print() {
		System.out.println(String.format("%s의 면적: %.2f", getName(), getArea()));
	}
	
	public String getName() {
		return "다각형";
	}
	
	public static void main(String[] args) {
		
		Polygon rectangle = new Rectangle();
		rectangle.setHeight(8);
		rectangle.setWidth(6);
		rectangle.print();
		
		Polygon triangle = new Triangle();
		triangle.setHeight(5);
		triangle.setWidth(7);
		triangle.print();
		
		Polygon circle = new Circle();
		circle.setRadius(5);
		circle.print();
	}

}
