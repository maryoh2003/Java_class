package kr.hs.dgsw.c2.d0519;

public class AdvancedExceptionStudy
{

	public static void main(String[] args)
	{
		
		try
		{
			

			Exception e = new MyException("이유를 적고 싶어");
			throw e;
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}