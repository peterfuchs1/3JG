package polymorphie;

public class E {
	public static void main(String[] args) {
		A[] a = new A[4];
		int i = a.length - 1;
		a[i--] = new B(4); // A
		a[i--] = new C(-2); // B
		a[i--] = new C(9); // C
		a[i] = new B(3); // D
		for (; i < a.length; i++) {
			a[i].p(i); // 1-4
		}
		a[0].p(14); // 7
		a[1].p(6); // 8
		((B) a[1]).p(7); // 8
		a[2].p(8); // 8
	}
}
