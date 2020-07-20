package dgsw.hs.kr.thread;

public class ThreadMain {
	public static void main(String[] args) {
		InputThread thread = new InputThread();
		thread.start();
		
		System.out.println("Main Thread start");
	}
}
