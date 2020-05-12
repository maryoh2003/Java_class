package kr.hs.dgsw.main;

public class ThreadFor2 extends Thread {

	@Override
	public void run() {
		for(int i =0; i<600 ; i ++) {
			System.out.print("|");
		}
	}

}