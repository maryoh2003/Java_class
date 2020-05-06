package kr.hs.dgsw.c2;

import java.util.ArrayList;

public class Dog extends Animal{
	
	private String nickname;
	
	public Dog() {
		super("zzzz"); //Animal 생성자에서 매개변수로 문자열을 받기 때문에 아무 문자열이나 넣어줘야지만 오류가 안뜬다.
		System.out.println("Dog 생성자 호출");
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String getName() {
		return "이름: " + super.getName();
	}

	public static void main(String[] args) {

		Dog dog = new Dog();
		Animal puppy = new Dog();
		
		dog.setName("개");
		puppy.setName("반려견");
		
		System.out.println(dog.getName());
		System.out.println(puppy.getName());
//		puppy.getNickname(); //Animal타입에 getnickname이 없기 때문에 에러 발생
		
//		ArrayList<String> list = new ArrayList<String>();
//		
//		dog.name = "강아지";
		

		
//		System.out.println(dog.getName() + " "+ dog.getSound()+ " "+ dog.getNickname());

	}

}
