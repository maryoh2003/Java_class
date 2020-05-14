package kr.hs.dgsw.c2.d0513;

public class MyThread extends Thread {

	private String name;
	
	private long delay;
	
	public MyThread(String name, long delay) {
		this.name = name;
		this.delay = delay;
	}
	
	
	@Override
	public void run() {
		System.out.println(name + " Ω∫∑πµÂ∞° Ω√¿€µ ");
		
		for (int i = 0 ; i < 30 ; i++)
		{
			System.out.println(name + " : " + i);
			
			try 
			{
				Thread.sleep(delay);
			} catch (Exception e) 
			{
			}
		}
		
		System.out.println(name + " Ω∫∑πµÂ∞° ¡æ∑·µ ");
	}
	
	public static void main(String[] args) {
		
		MyThread thread = new MyThread("√÷«—ºˆ", 20L);
		thread.start();
		
		MyThread thread2 = new MyThread("ø©µøπŒ", 50L);
		thread2.start();

		MyThread thread3 = new MyThread("±Ë¡÷ø±", 25L);
		thread3.start();

	}
	
	
}