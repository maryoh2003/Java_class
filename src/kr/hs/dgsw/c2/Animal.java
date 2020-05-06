package kr.hs.dgsw.c2;

public class Animal {

	protected String name;
	
	private String sound;
	
	public Animal(String param) {
		System.out.println("Animal생성자 호출");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSound() {
		return sound;
	}
	
	public void setSound(String sound) {
		this.sound = sound;
	}
}
