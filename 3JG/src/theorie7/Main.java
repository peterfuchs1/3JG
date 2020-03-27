package theorie7;

public class Main {

	public static void main(String[] args) {
//		A a1 = new A(); //kann nicht instanziert werden
//		A a2 = new B(); // B ist kein A
		A a3 = new C(); // C ist ein A - ok!

//		I i1 = new A(); // A kann nicht instanziert werden
		I i2 = new B(); // B ist ein I - ok!
		I i3 = new C(); // C ist ein I
		
		
	}

}
