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
		System.out.println(name + " �����尡 ���۵�");
		
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
		
		System.out.println(name + " �����尡 �����");
	}
	
	public static void main(String[] args) {
		
		MyThread thread = new MyThread("���Ѽ�", 20L);
		thread.start();
		
		MyThread thread2 = new MyThread("������", 50L);
		thread2.start();

		MyThread thread3 = new MyThread("���ֿ�", 25L);
		thread3.start();

	}
	
	
}