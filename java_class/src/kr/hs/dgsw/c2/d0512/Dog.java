package kr.hs.dgsw.c2.d0512;

public class Dog implements Printable, Countable {

	private int count = 0;
	
	@Override
	public void print()
	{
		System.out.println("강아지");
	}

	@Override
	public int count() {
		return ++count;
	}
	
	public void eat()
	{
		System.out.println("고기를 먹어요");
	}
	
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.print();
		dog.eat();
		System.out.println(dog.count());
		
		Printable dog1 = (Printable)dog;

		Printable printable = new Dog();
		printable.print();
		
		Countable countable = new Dog();
		System.out.println(countable.count());
		
		Printable printable2 = new Cat();
		printable2.print();
		
		Cat cat = new Cat();
		Countable cat1 = (Countable)cat;
	}
}