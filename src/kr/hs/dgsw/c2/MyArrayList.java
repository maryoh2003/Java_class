package kr.hs.dgsw.c2;

import java.util.ArrayList;
import java.util.Collections;

public class MyArrayList extends ArrayList<String>{
	
	public String getLast()
	{
		if(super.size()==0) {
			return null;
		}
		
		return super.get(super.size()-1);
	}
	
	public void reverse() {
		MyArrayList temp = new MyArrayList();
		
		for(int i=(size()-1);i>=0;i--) {
			temp.add(get(i));
		}
		
		this.clear();
		
		for(int i=0;i< temp.size();i++) {
			add(temp.get(i));
		}
	}
	
	public void print() {
		for(String item : this) {
			System.out.println(item);
		}
	}

	public static void main(String[] args) {

		MyArrayList list = new MyArrayList();
		
		list.add("±èÁÖ¿±");
		list.add("¿ÀÇÏÇü");
		list.add("±èÇý¼±");
		list.add("Àüµµ±Ç");
		
		
		System.out.println("Size: " + list.size());
		System.out.println("Last: "+ list.getLast());
		list.reverse();
		list.print();
	
		
		
//		Collections.reverse(list);
//		
//		System.out.println(list);
		
	}

}
