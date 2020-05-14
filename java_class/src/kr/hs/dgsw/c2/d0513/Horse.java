package kr.hs.dgsw.c2.d0513;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Horse implements Runnable  {
	
	private static List<Integer> rankList = new ArrayList<Integer>();

	private int no;
	
	public Horse(int no) 
	{
		this.no = no;
	}
	
	@Override
	public void run() {
		
		int distance = 0;
		
		while (distance < 10000)
		{
			distance += makeRandomNumber();
			
			System.out.println(String.format("말 %d : %d", no, distance));
			
			try 
			{
				Thread.sleep(100L);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("말 " + no + "가 경주를 마쳤습니다.");
		
		finish(no);
	}
	
	private int makeRandomNumber()
	{
		Random random = new Random();
		
		int value = random.nextInt(50) + 100;
		
		return value;
	}
	
	private void finish(int no)
	{
		rankList.add(no);
		
		if(rankList.size()== 8) {
			showRank();
		}
	}
	
	private void showRank()
	{
		System.out.println("최종결과");
		
		int rank = 0;
		for(Integer no : rankList)
		{
			rank++;
			System.out.println(String.format("%d위 : %d번 말", rank, no));
		}
	}
	
	public static void main(String[] args) {
		
		Horse horse = null;
		
		for (int i = 0 ; i < 8 ; i++)
		{
			horse = new Horse(i + 1);
			new Thread(horse).start();
		}
		
//		horse.showRank();
	}
	
}