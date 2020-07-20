package dgsw.hs.kr.thread;

public class TestMain {
	public static void main(String[] args) {
		
		MyThread thread1 = new MyThread();
		thread1.start();
		
		MyRunnable thread2 = new MyRunnable();
		new Thread(thread2).start();
		
		//Thread thread3 = new Thread(thread2);
		//thread3.start();
		
		//new Thread(new MyRunnable()).start();
		
		System.out.println("Main Thread Class");
	}
}
