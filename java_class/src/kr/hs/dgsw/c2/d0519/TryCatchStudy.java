package kr.hs.dgsw.c2.d0519;

import java.util.Scanner;

public class TryCatchStudy
{
	
	public String method1()
	{
		Scanner scanner = new Scanner(System.in);
		
		try
		{
			String str = "hello";
			
			System.out.println("check 1");
			
			// do something;
			int a = 5 / 0;
			
			System.out.println("check 2");
			
			return str;
		}
		catch (Exception e)
		{
			System.out.println("예외가 발생하였습니다.");
		}
		finally 
		{
			scanner.close();
			System.out.println("check 4");
		}
		
		
		System.out.println("check 3");

		return null;
	}
	

	public static void main(String[] args)
	{
		TryCatchStudy study = new TryCatchStudy();
		study.method1();
		
	}
	
}