package kr.hs.dgsw.c2;

public class Cat extends Animal{

	public static void main(String[] args) {

		Cat cat = new Cat();
		
		cat.setName("�����");
		cat.setSound("�߿�");
		
		System.out.println(cat.getName() + " "+ cat.getSound());

	}

}
