package dgsw.hs.kr.main;

public class ControlMain {

	public static void main(String[] args) {
		ThreadFor1 thread1 = new ThreadFor1();
		ThreadFor2 thread2 = new ThreadFor2();
		thread1.setPriority(1);
		thread2.setPriority(10);
		thread1.setDaemon(true); //main 쓰레드가종료됐을때 종료될지말지 
		thread2.setDaemon(true);
		thread1.start();
		thread2.start();
//		for(int i =0;i<600;i++) {
//			System.out.print("/");
//		}
		System.out.println("main Thrread exit");
	}

}
