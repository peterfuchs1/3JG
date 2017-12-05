package rekursion;

public class Utils {
	public static boolean DEBUG=false;
	/**
	 * Summe der natürlichen Zahlen bis n rekursive Variante
	 * @param n
	 * @return Summe
	 */
	public static long sum(long n) {
		if(n==0) return 0;
		if (DEBUG) System.out.println("Vor Rekursion: "+n);
		long sum1 =Utils.sum(n-1);
		long sum2 = n+sum1;
		if (DEBUG) System.out.println("Nach Rekursion: "+sum1+"+"+n+"="+sum2);
		return sum2;
	}
	/**
	 * Summe der natürlichen Zahlen bis n 
	 * @param n
	 * @return Summe
	 */
	public static long sum2(long n) {
		return Utils.add_sum(0, n);
	}
	/**
	 * Summe der natürlichen Zahlen bis n: endrekursive Variante
	 * @param m Startwert 0
	 * @param n 
	 * @return Summe
	 */
	private static long add_sum(long m, long n) {
		if(n==0) return m;
		long sum = m+n;
		if (DEBUG) System.out.println("Vor Rekursion: "+m+"+"+n+"="+sum);
		return Utils.add_sum(sum, n-1);
	}
	/**
	 * Fakultät (n!) rekursive Variante 
	 * @param n
	 * @return Fakultät
	 */
	public static long fact(long n) {
		if(n<=1) return 1;
		return n*Utils.fact(n-1);
	}
	/**
	 * Fakultät n!
	 * @param n
	 * @return Fakultät
	 */
	public static long fact2(long n) {
		return Utils.mult_fact(1,n);
	}
	/**
	 * Endrekursive Variante der Fakultät
	 * @param m Startwert 1
	 * @param n Parameter der Fakultät
	 * @return Fakultät
	 */
	private static long mult_fact(long m, long n) {
		if(n<=1) return m;
		long p=m*n;
		if (DEBUG) System.out.println("Vor Rekursion: "+m+"*"+n+"="+p);
		return Utils.mult_fact(p, n-1);
		
	}
	/**
	 * ggT nach Euclid
	 * @param a 
	 * @param b
	 * @return ggT
	 */
	public static long euclid(long a, long b) {
		if(b==0) return a;
		if (DEBUG) System.out.println("Vor Rekursion: "+b);
		return Utils.euclid(b, a%b);
	}
	/**
	 * Fibonacci-Zahl
	 * @param n 
	 * @return Fibonacci-Zahl
	 */
	public static long fib(int n) {
		return Utils.add_fib(n, 0, 1);
	}
	/**
	 * Endrekursive Variante  
	 * @param n 
	 * @param a Startwert 0
	 * @param b Startwert 1
	 * @return Fibonacci
	 */
	private static long add_fib(int n, long a, long b) {
		if (n<=0) return a;
		long sum=a+b; 
		if (DEBUG) System.out.println("Vor Rekursion: "+n+":"+a+","+b);
		return Utils.add_fib(n-1, b, sum);
	}
}
