package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class TestPunkt {
	public static void main(String[] args) {
		Punkt[] punkte = {new Punkt(4,2),new Punkt(3,2),  new Punkt(4,2), new Punkt(2,4)};

		HashSet<Punkt> hs=new HashSet<>();
		hs.addAll(Arrays.asList(punkte));
		for (Punkt p:hs)
			System.out.println(p.toString());
	}

}
