package pers;

import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		TreeSet<Person> persons=new TreeSet<>();
		persons.add(new Person("Wolfgang","Berger"));
		persons.add(new Person("Hans","Weber"));
		persons.add(new Person("Peter","Müller"));
		persons.add(new Person("Renate","Bauer"));
		persons.add(new Person("Patrizia","Franz"));
		for(Person p:persons)
			System.out.println(p.toString());
	}

}
