package rekursion;

public class Utils {
	public static boolean DEBUG = false;

	/**
	 * Summe der natürlichen Zahlen bis n rekursive Variante
	 * 
	 * @param n
	 * @return Summe
	 */
	public static long sum(long n) {
		if (n == 0)
			return 0;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + n);
		long sum1 = Utils.sum(n - 1);
		long sum2 = n + sum1;
		if (DEBUG)
			System.out.println("Nach Rekursion: " + sum1 + "+" + n + "=" + sum2);
		return sum2;
	}

	/**
	 * Summe der natürlichen Zahlen bis n
	 * 
	 * @param n
	 * @return Summe
	 */
	public static long sum2(long n) {
		return Utils.add_sum(0, n);
	}

	/**
	 * Summe der natürlichen Zahlen bis n: endrekursive Variante
	 * 
	 * @param m
	 *            Startwert 0
	 * @param n
	 * @return Summe
	 */
	private static long add_sum(long m, long n) {
		if (n == 0)
			return m;
		long sum = m + n;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + m + "+" + n + "=" + sum);
		return Utils.add_sum(sum, n - 1);
	}

	/**
	 * Fakultät (n!) rekursive Variante
	 * 
	 * @param n
	 * @return Fakultät
	 */
	public static long fact(long n) {
		if (n <= 1)
			return 1;
		if (DEBUG) System.out.println("Vor der Rekursion "+n);
		long sum=Utils.fact(n - 1);
		if (DEBUG) System.out.println("Nach der Rekursion "+n+"*"+sum+"= "+n*sum);
		return n*sum;
	}

	/**
	 * Fakultät n!
	 * 
	 * @param n
	 * @return Fakultät
	 */
	public static long fact2(long n) {
		return Utils.mult_fact(1, n);
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
		if (n <= 1)
			return m;
		long p = m * n;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + m + "*" + n + "=" + p);
		return Utils.mult_fact(p, n - 1);

	}

	/**
	 * ggT nach Euclid
	 * 
	 * @param a
	 * @param b
	 * @return ggT
	 */
	public static long euclid(long a, long b) {
		if (b == 0)
			return a;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + b);
		return Utils.euclid(b, a % b);
	}

	/**
	 * Fibonacci-Zahl
	 * 
	 * @param n
	 * @return Fibonacci-Zahl
	 */
	public static long fib(int n) {
		return Utils.add_fib(n, 0, 1);
	}

	/**
	 * Endrekursive Variante
	 * 
	 * @param n
	 * @param a
	 *            Startwert 0
	 * @param b
	 *            Startwert 1
	 * @return Fibonacci
	 */
	private static long add_fib(int n, long a, long b) {
		if (n <= 0)
			return a;
		long sum = a + b;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + n + ":" + a + "," + b);
		return Utils.add_fib(n - 1, b, sum);
	}
	/**
	 * gerade
	 * @param n
	 * @return true, if n % 2 == 0
	 */
	public static boolean gerade(long n) {
		if (n==0) return true;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + n );
		return Utils.ungerade(n-1);
	}
	/**
	 * ungerade
	 * @param n
	 * @return false, if n % 2 == 0
	 */
	public static boolean ungerade(long n) {
		if (n==0) return false;
		if (DEBUG)
			System.out.println("Vor Rekursion: " + n );
		return Utils.gerade(n-1);
	}
	/**
	 * modulo interation 
	 * @param divident
	 * @param divisor
	 * @return
	 */
	public static long rest(long divident, long divisor) {
		while(divident>divisor)
			divident -=divisor;
		return divident;
	}
	/**
	 * modulo recursive
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long rest1(long d1, long d2) {
		if(d1<d2) return d1;
		return rest1(d1-d2,d2);
	}
	/**
	 * Summe der Quadrate
	 * @param max
	 * @return
	 */
	public static long sum_quad(long max) {
		long result=0;
		for(int i=1;i<=max;++i)
			result += i*i;
		return result;
	}
	/**
	 * Summe der Quadrate rekursiv
	 * @param max
	 * @return
	 */
	public static long sum_quad_rec(long max) {
		if(max < 1) return 0;
		return max*max+sum_quad_rec(max-1);
	}

	
	/**
	 * Summe der Quadrate endrekursiv
	 * @param max
	 * @return
	 */
	public static long sum_quad_endrec(long max) {
		return quad_endrec(0,max);
	}

	private static long quad_endrec(long i, long max) {
		if(max < 1) return i;
		return quad_endrec(i+max*max,max-1);
	}
	
	public static long rec1(long a) {
		if(a==0) return 1;
		return rec2(a+1);
	}
	public static long rec2(long b) {
		if(b==0) return 0;
		return rec1(b-1);
	}
	
	public static long double_s1(long a) {
		if(a == 0) return 0;
		return a+a*double_s1(a-1);
	}
	public static long double_s2(long a) {
		return double_s(1,0,a);
	}

	private static long double_s(long a, long b, long c) {
		if(a>c) return b;
		long sum=a+a*b; 
		return double_s(a+1,sum, c);
	}
	/**
	 * Direkte Rekursion eines nicht-assoziativer Algorithmus 
	 * @param a 
	 * @return
	 */
	public static long nicht_assoziativ1(long a) {
		if(a==0) return 0;
		// beispielhafter Algorithmus
		return 7*a-a*nicht_assoziativ1(a-1);
	}
	/**
	 * Endrekursion eines nicht-assoziativer Algorithmus: Aufruf 
	 * @param a 
	 * @return
	 */
	public static long nicht_assoziativ2(long a) {
		long indexStart =1;
		long algorithmusStart =0;
		long indexSchranke = a;
		return nicht_assoziativ(indexStart, algorithmusStart, indexSchranke);
	}
	/**
	 * Endrekursion eines nicht-assoziativer Algorithmus: Algorithmus 
	 * @param a 
	 * @return
	 */
	private static long nicht_assoziativ(long index, long b, long schranke) {
		if(index>schranke) return b;
		long algorithmus=7*index-index*b; // beispielhafter Algorithmus
		return nicht_assoziativ(index+1,algorithmus, schranke);
	}
}
