package dgsw.hs.kr.main;

public class ThreadFor1 extends Thread {

	@Override
	public void run() {
		for(int i =0; i<600 ; i ++) {
			System.out.print("-");
		}
	}
}