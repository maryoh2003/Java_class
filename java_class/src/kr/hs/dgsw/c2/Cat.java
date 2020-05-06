package kr.hs.dgsw.c2;

public class Cat extends Animal{

	public static void main(String[] args) {

		Cat cat = new Cat();
		
		cat.setName("고양이");
		cat.setSound("야옹");
		
		System.out.println(cat.getName() + " "+ cat.getSound());

	}

}
