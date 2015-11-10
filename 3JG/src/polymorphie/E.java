package polymorphie;

public class E {
	public static void main(String[] args) {
		A[] a = new A[4];
		int i = a.length - 1;
		a[i--] = new B(2); // A
		a[i--] = new C(-2); // B
		a[i--] = new D(9); // C
		a[i] = new A(); // D
		for (; i < a.length; i++) {
			a[i].p(i); // 1-4
		}
		System.out.println(a[2].hurra()); // 5
		System.out.println(a[3].hurra(i)); // 6
		a[2].p(14); // 7
		a[0].p(-6); // 8
	}
}
