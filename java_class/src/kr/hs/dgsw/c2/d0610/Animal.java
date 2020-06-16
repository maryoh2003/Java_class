package kr.hs.dgsw.c2.d0610;

public class Animal {
	protected Sound sound;
	
	public void eat()
	{
		System.out.println("°í±â");
	}
	
	public void sound()
	{
		this.sound.sound();
	}
	
	public void setSound(Sound sound)
	{
		this.sound = sound;
	}
	
	public static void main(String[] args) {
		Animal dog = new Animal();
		dog.setSound(new Sound()
		{
			@Override
			public void sound() {
				System.out.println("¸Û¸Û");
			}
		});
	Animal cat = new Animal();		
	}
}
