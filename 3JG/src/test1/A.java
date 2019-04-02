package test1;

public class A {
	public static void method(B b) {
		// Ausgabe 'a'
		// Ein neues Objekt erzeugt, womit die Referenz b �berschrieben wird
		// und somit keine �nderung des Originalobjektes vollzogen wird.
		// Am Ende dieser Methode wird das neue Objekt wieder zerst�rt
		b = new B();

		// Ausgabe 'x'
		// Mittels vorhandener Referenz b wird das Originalobjekt �berschrieben.
		b.set('x');
	}

	public static void main(String[] args) {
		B obj = new B();
		obj.set('a');
		A.method(obj);
		System.out.println(obj.get());
	}
}
