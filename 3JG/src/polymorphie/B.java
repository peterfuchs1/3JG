package polymorphie;

public class B extends A {
	 void p(int b) { // overrides second p
	     print("Beh!");
	}

	public static void main(String[] args) {
		A a = new A();
		a.p(1); // print  „Aah!“
		a = new B();
		a.p(1); // print  „Beh!“
	}
}
