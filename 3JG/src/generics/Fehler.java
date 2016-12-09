package generics;

public class Fehler {
	public static void main(String[] args) {
		 Number[] a = new Integer[1];
		 a[0] = new Double( 3.14 );  // <-- kein Kompilierfehler, aber Laufzeitfehler

//		 ArrayList<Number> a = new ArrayList<Integer>();  // <-- Kompilierfehler
	}
}
