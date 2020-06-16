package kr.hs.dgsw.c2.d0611;

import java.util.ArrayList;
import java.util.List;

public class prime_Number_Finder
{
	public void inputNumber(int number) {
		try {
		prime_Number_Finder pnf = new prime_Number_Finder();
		List<Integer> PrimeNumberList = pnf.primeNumber(100);
		
		for (Integer item:PrimeNumberList) {
			System.out.println(item);
		}
	}
		catch(Exception e) {
		e.printStackTrace();
	    }
	}

	public static final int sizeofrange = 120;
	/**
	 * 주어진 숫자가 소수인지 여부를 판단한다.
	 * 
	 * @param a 소수인지 판단할 숫자
	 * @return 소수라면 true, 아니면 false
	 */
	public boolean isPrime(int a) {
		for (int i=2;i<a;i++) {
		  if(a%i==0)
			return false;
		}
		return true;
	}
	/**
	 * 1부터 주어진 max_number까지의 정수 가운데, 모든 소수를 찾는다.
	 * 
	 * @param max_number 범위값
	 * @return 1부터 주어진 max_number 사이에 존재하는 모든 소수 목록
	 */
	public List<Integer> primeNumber(int max_number) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1;i<=max_number;i ++) {
		if(isPrime(i) == true) {
		list.add(i);
		  }
		}
		return list;
	}
	public int plus(int num1, int num2) {
		if(num1>sizeofrange||num2>sizeofrange||num1+num2>sizeofrange||num2<0||num1<0) {
			return -1;
		} else
			return num1+num2;
	}
	public void print() {
		int value1, value2=3;
		int value3 = (value1=value2*5);
		String Text = value3>5?"OK":"Ooops";
		
		System.out.println(Text);
	}
}