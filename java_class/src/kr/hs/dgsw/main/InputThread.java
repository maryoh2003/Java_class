package kr.hs.dgsw.main;

public class InputThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}