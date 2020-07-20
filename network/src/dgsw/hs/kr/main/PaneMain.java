package dgsw.hs.kr.main;

import javax.swing.JOptionPane;

public class PaneMain {

	public static void main(String[] args) {
		InputThread thread = new InputThread();
		thread.start();
		
		String input = JOptionPane.showInputDialog("input number");
		System.out.println("input : "+input);
		
		System.out.println("system out");
	}

}