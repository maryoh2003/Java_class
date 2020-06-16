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
	 * �־��� ���ڰ� �Ҽ����� ���θ� �Ǵ��Ѵ�.
	 * 
	 * @param a �Ҽ����� �Ǵ��� ����
	 * @return �Ҽ���� true, �ƴϸ� false
	 */
	public boolean isPrime(int a) {
		for (int i=2;i<a;i++) {
		  if(a%i==0)
			return false;
		}
		return true;
	}
	/**
	 * 1���� �־��� max_number������ ���� ���, ��� �Ҽ��� ã�´�.
	 * 
	 * @param max_number ������
	 * @return 1���� �־��� max_number ���̿� �����ϴ� ��� �Ҽ� ���
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