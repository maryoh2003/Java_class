package kr.hs.dgsw.c2.d0512;

import java.util.Date;

public class ComparableStudy {

	public static void main(String[] args) {
		
		String str1 = "abcde";
		String str2 = "qwerty";
		String str3 = "GGG";
		
		int result1 = str1.compareTo(str2);
		int result2 = str1.compareTo(str3);
		int result3 = str1.compareTo(str1);
		
		System.out.println(result1 + "  " + result2 + "  " + result3);
		
		
		Date date1 = new Date(10000000);
		Date date2 = new Date(9999);
		Date date3 = new Date(100000001);
		
		int result4 = date1.compareTo(date2);
		int result5 = date1.compareTo(date3);
		int result6 = date1.compareTo(date1);
		
		System.out.println(result4 + "  " + result5 + "  " + result6);
		
	}
	
}