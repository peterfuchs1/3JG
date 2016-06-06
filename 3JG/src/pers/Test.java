package pers;

import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		TreeSet<Person> tm=new TreeSet<>();
		tm.add(new Person("Wolfgang","Berger"));
		tm.add(new Person("Hans","Weber"));
		tm.add(new Person("Peter","Müller"));
		tm.add(new Person("Renate","Bauer"));
		tm.add(new Person("Patrizia","Franz"));
		for(Person p:tm)
			System.out.println(p.toString());
	}

}
