package kr.hs.dgsw.c2.d0513;

public class MyRunnable implements Runnable {

	private String name;
	
	private long delay;

	public MyRunnable(String name, long delay) {
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
		
		MyRunnable runnable1 = new MyRunnable("�̿���", 50L);
		new Thread(runnable1).start();

		MyRunnable runnable2 = new MyRunnable("������", 40L);
		new Thread(runnable2).start();

	}
}