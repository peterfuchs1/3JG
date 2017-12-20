package rekursion;

public class TailCallOptimation {
	/**
	 * Fakultät (n!) rekursive Variante
	 * 
	 * @param n
	 * @return Fakultät
	 */
	public static long fact1(long n) {
		if (n < 2) return 1;
		long sum=fact1(n - 1);
		return n*sum;
	}

	/**
	 * Fakultät n!
	 * 
	 * @param n
	 * @return Fakultät
	 */
	public static long fact2(long n) {
		return mult_fact(1, n);
	}

	/**
	 * Endrekursive Variante der Fakultät
	 * 
	 * @param m
	 *            Startwert 1
	 * @param n
	 *            Parameter der Fakultät
	 * @return Fakultät
	 */
	private static long mult_fact(long m, long n) {
		if (n < 2) return m;
		return mult_fact(m * n, n - 1);

	}

	public static long fact3(long n) {
		long m = 1; 
	
		while (n > 1) {
			m *= n;
			n -=1;
		}
		return m;
	}

	public static long fact4(long n) {
		long m = 1; 
	
		for (;n > 1;--n)
			m *= n;
		return m;
	}
	
	public static void main(String[] args) {
		System.out.println(fact1(6));
		System.out.println(fact2(6));
		System.out.println(fact3(6));
		System.out.println(fact4(6));
	}

}
