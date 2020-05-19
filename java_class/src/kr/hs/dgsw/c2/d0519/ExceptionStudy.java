package kr.hs.dgsw.c2.d0519;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import kr.hs.dgsw.c2.Animal;
import kr.hs.dgsw.c2.Cat;
import kr.hs.dgsw.c2.Dog;

public class ExceptionStudy 
{
	public void exception1()
	{
		String str = null;
		
		System.out.println(str.length());
	}

	public void exception2()
	{
		int a = 5;
		int b = 0;
		
		int c = a / b;
	}
	
	public void exception3()
	{
		int[] array = new int[3];
		
		array[0] = 0;
		array[1] = 0;
		array[2] = 0;
		//array[3] = 0;
		
	
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(7);
		
		System.out.println(list.get(0) + "  " + list.get(1) + "  " + list.get(2));
	}

	public void exception4()
	{
		Animal dog = new Dog();
		Animal cat = new Cat();
		
		Dog dog1 = (Dog)dog;
		Cat cat1 = (Cat)dog;
	}
	
	public void exception5()
	{
		String str = "12G";
		int value = Integer.parseInt(str);
		
		System.out.println(value + 3);
	}
	
	public void exception6() throws Exception
	{
		File file = new File("C:\\java_study\\hello1.txt");
		
		InputStream is = new FileInputStream(file);
		
		// do something
		
		is.close();
	}
	
	public static void main(String[] args)
	{
		try
		{
			ExceptionStudy study = new ExceptionStudy();
			
			study.exception6();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}