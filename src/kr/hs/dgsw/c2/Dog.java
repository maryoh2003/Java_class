package kr.hs.dgsw.c2;

import java.util.ArrayList;

public class Dog extends Animal{
	
	private String nickname;
	
	public Dog() {
		super("zzzz"); //Animal �����ڿ��� �Ű������� ���ڿ��� �ޱ� ������ �ƹ� ���ڿ��̳� �־�������� ������ �ȶ��.
		System.out.println("Dog ������ ȣ��");
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String getName() {
		return "�̸�: " + super.getName();
	}

	public static void main(String[] args) {

		Dog dog = new Dog();
		Animal puppy = new Dog();
		
		dog.setName("��");
		puppy.setName("�ݷ���");
		
		System.out.println(dog.getName());
		System.out.println(puppy.getName());
//		puppy.getNickname(); //AnimalŸ�Կ� getnickname�� ���� ������ ���� �߻�
		
//		ArrayList<String> list = new ArrayList<String>();
//		
//		dog.name = "������";
		

		
//		System.out.println(dog.getName() + " "+ dog.getSound()+ " "+ dog.getNickname());

	}

}
