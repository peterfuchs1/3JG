package rekursion;

public class Vergleich_Rekursion_Iteration {
	/**
	 * Trennlinie
	 */
	public static final String T="==========";
	/**
	 * Startzeit
	 */
	public static long START=0;
	/**
	 * Start der Stoppuhr
	 */
	public static void start() {
		System.out.println(T);
		START=System.nanoTime();
	}
	/**
	 * Ende der Stoppuhr
	 */
	public static void ende() {
		System.out.println("Dauer: "+((System.nanoTime()-START)/1000)+"ms");
		System.out.println();
	}
	/**
	 * Fakultaet: mittels primitiver direkter Rekursion
	 * @param n Parameter der Fakultaet
	 * @return Fakultaet
	 */
	public static long fact1(long n) {
//		System.out.println("Primitive direkte Rekursion");
		if (n < 2) return 1;
		System.out.println("Vor der Rekursion: "+n);
		long sum=fact1(n - 1);
		System.out.println("Nach der Rekursion: "+n+"*"+sum+"="+n*sum);
		return n*sum;
	}

	/**
	 * Fakultaet: mittels Rekursion: Umwandlung in Endrekursion
	 * @param n Parameter der Fakultaet
	 * @return Fakultaet
	 */

	public static long fact2(long n) {
		System.out.println("Endrekursion:");
		return mult_fact(1, n);
	}

	/**
	 * Endrekursive Variante der Fakultaet
	 * 
	 * @param m Startwert 1
	 * @param n Parameter der Fakultaet
	 * @return Fakultaet
	 */
	private static long mult_fact(long m, long n) {
		if (n < 2) return m;
		System.out.println("Vor der Rekursion: "+m+"*"+n+"="+m*n);
		return mult_fact(m * n, n - 1);

	}
	/**
	 * Fakultaet: mittels while-Iteration 
	 * @param n Parameter der Fakultaet
	 * @return Fakultaet
	 */
	public static long fact3(long n) {
		long m = 1; 
		System.out.println("Iteration mit while-Schleife:");
		while (n > 1) {
			System.out.println("Schleife: "+m+"*"+n+"="+m*n);
			m *= n--;
		}
		return m;
	}

	/**
	 * Fakultaet: mittels for-Iteration 
	 * @param n Parameter der Fakultaet
	 * @return Fakultaet
	 */
	public static long fact4(long n) {
		long m = 1; 
		System.out.println("Iteration mit for-Schleife:");
	
		for (;n > 1;--n) {
			System.out.println("Schleife: "+m+"*"+n+"="+m*n);
			m *= n;
		}		
		return m;
	}
	
	public static void main(String[] args) {
		start(); // Stoppuhr gestartet
				 // Primitive direkte Rekursion n*fact(n-1)
		System.out.println("Ergebnis: "+fact1(6));
		ende();  // Stoppuhr beendet
		start(); // Stoppuhr gestartet
				 // Endrekursion: fact(m*n,n-1) [Startwert m=1]
		System.out.println("Ergebnis: "+fact2(6));
		ende();  // Stoppuhr beendet
		start(); // Stoppuhr gestartet
				 // Iteration mit while-Schleife 
		System.out.println("Ergebnis: "+fact3(6));
		ende();  // Stoppuhr beendet
		start(); // Stoppuhr gestartet
				 // Iteration mit for-Schleife
		System.out.println("Ergebnis: "+fact4(6));
		ende();  // Stoppuhr beendet
	}
}
