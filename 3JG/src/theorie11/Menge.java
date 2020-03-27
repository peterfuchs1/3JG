package theorie11;

public class Menge<E> {
	public boolean contains(E e) {
		return true;
	}
	public static void main(String[] args) {
		Menge<String> e1 = new Menge();
		Menge<String> e3 = new Menge<String>();
//		boolean b = e3.contains(5); // Achtung 5 ist kein String!

	}
}
