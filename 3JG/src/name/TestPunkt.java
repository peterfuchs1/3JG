package name;

import java.util.Arrays;
import java.util.TreeSet;

public class TestPunkt {
	public static void main(String[] args) {
		Punkt[] punkte = {new Punkt(3,2), new Punkt(4,2), 
						new Punkt(4,2), new Punkt(2,4)};

		TreeSet<Punkt> ts=new TreeSet<>();
		ts.addAll(Arrays.asList(punkte));
		for (Punkt p:ts)
			System.out.println(p.toString());
	}
}
