package kr.hs.dgsw.c2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateStudy {

	public static void main(String[] args) {
		
		Date now = new Date();
		System.out.println(now);
		System.out.println("getDay:"+now.getDay());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
		System.out.println(dateFormat.format(now));
		
		String sTime = "2020�� 02�� 03�� 13�� 22�� 19��";
		try {
			Date time1 = dateFormat.parse(sTime);
			System.out.println(time1);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		System.out.println("��: "+calendar.get(Calendar.YEAR));
		System.out.println("��: "+calendar.get(Calendar.MONTH));
		System.out.println("��: "+calendar.get(Calendar.DATE));
		
		calendar.set(Calendar.YEAR, 2019);
		System.out.println("��: "+calendar.get(Calendar.YEAR));
	}

}
