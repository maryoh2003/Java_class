package kr.hs.dgsw.main;

public class MyThread extends Thread{
	
	public void printTest() {
		System.out.println("MyThread print");
	}

	@Override
	public void run() {
		
//		try {
//			sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("MyThread run");
	}
	
}