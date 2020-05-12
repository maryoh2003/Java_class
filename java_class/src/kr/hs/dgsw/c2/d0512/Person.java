package kr.hs.dgsw.c2.d0512;

import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person> {

	private int age;
	
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		return age - o.getAge();
		
		//return name.compareTo(o.getName());
	}
	
	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person(35, "강감찬"));
		list.add(new Person(22, "이순신"));
		list.add(new Person(47, "세종대왕"));
		list.add(new Person(5, "이이"));
		list.add(new Person(72, "을지문덕"));
		
		
		list.sort(null);
		
		for (Person person : list)
		{
			System.out.println(person.getAge() + "  " + person.getName());
		}
	}
	
}