package kr.hs.dgsw.c2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate{
	public static void main(String[] args) {
		
		Date now = new Date();
		
	    String date1 = "2003-03-21";
	    String date2 = "2020-04-29";
	 
	    try{ 
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	        Date FirstDate = format.parse(date1);
	        Date SecondDate = format.parse(date2);

	        long calDate = FirstDate.getTime() - SecondDate.getTime(); 
	
	        long calDateDays = calDate / ( 24*60*60*1000); 
	 
	        calDateDays = Math.abs(calDateDays);
	        
	        System.out.println("�� ��¥�� ��¥ ����: "+calDateDays);
	        }
	        catch(ParseException e)
	        {
	        }
	}
}

// ���ϰھ��.. �ʹ� ������� .. 
// ���� ���ݸ� õõ�� ���ֽø� �ȵɱ�� ? �ѹ� ��ġ�� ���󰡱Ⱑ ������� .. �ФФФ�