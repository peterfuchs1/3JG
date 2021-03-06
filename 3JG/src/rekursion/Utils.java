package rekursion;

public class Utils {
	public static boolean DEBUG = false;

	/**
	 * Summe der nat�rlichen Zahlen bis n rekursive Variante
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
	 * Summe der nat�rlichen Zahlen bis n
	 * 
	 * @param n
	 * @return Summe
	 */
	public static long sum2(long n) {
		return Utils.add_sum(0, n);
	}

	/**
	 * Summe der nat�rlichen Zahlen bis n: endrekursive Variante
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
	 * Fakult�t (n!) rekursive Variante
	 * 
	 * @param n
	 * @return Fakult�t
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
	 * Fakult�t n!
	 * 
	 * @param n
	 * @return Fakult�t
	 */
	public static long fact2(long n) {
		return Utils.mult_fact(1, n);
	}

	/**
	 * Endrekursive Variante der Fakult�t
	 * 
	 * @param m
	 *            Startwert 1
	 * @param n
	 *            Parameter der Fakult�t
	 * @return Fakult�t
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

	public static long func1(long x) {
		if(x<1) return 0;
		return 2*x+func1(x-1);
	}
	
	public static long func2(long x) {
		return func3(0,x);
	}
	private static long func3(long i,long x) {
		if(x<1) return i;
		return func3(2*x+i, x-1);
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
		return nicht_assoziativ2(indexStart, algorithmusStart, indexSchranke);
	}
	/**
	 * Endrekursion eines nicht-assoziativer Algorithmus: Algorithmus 
	 * @param a 
	 * @return
	 */
	private static long nicht_assoziativ2(long index, long ergebnis, long schranke) {
		if(index>schranke) return ergebnis;
		long algorithmus=7*index-index*ergebnis; // beispielhafter Algorithmus
		return nicht_assoziativ2(index+1,algorithmus, schranke);
	}
	
	public static long fn1(long x) {
		if(x==0) return 0;
		return 7+fn1(x-1);
	}
	
	public static long fn2(long x) {
		return fn(x,0);
	}

	private static long fn(long x, long i) {
		if(x==0) return i;
		return fn(x-1,7+i);
	}
	
	public static long f7_sum1(long x) {
		if(x==0) return 0;
		return 7*x+f7_sum1(x-1);
	}
	
	public static long f7_sum2(long x) {
		return f7(x,0);
	}

	private static long f7(long x, long i) {
		if(x==0) return i;
		return f7(x-1,7*x+i);
	}
	
	public static void printArrayRec(int[] workArray, int idx) {
		if (idx < 0 || idx >= workArray.length) return;
		System.out.println(workArray[idx]);
		printArrayRec(workArray, idx-1);
	}
	
	public static int findMax(int[] workArray, int idx) {
		return findMax2(workArray, idx, workArray[idx]);
	}
	private static int findMax2( int[] workArray, int idx, int max) {
		if(idx <= 0) return max;
		return findMax2(workArray, idx-1, Math.max(max,workArray[idx-1]));
	}

	public static int findMin(int[] workArray, int idx) {
		return findMin2(workArray, idx, workArray[idx]);
	}
	private static int findMin2( int[] workArray, int idx, int min) {
		if(idx <= 0) return min;
		return findMin2(workArray, idx-1, Math.min(min,workArray[idx-1]));
	}
	public static int calcSum(int[] workArray, int idx) {
		return findCalcSum2(workArray, idx, workArray[idx]);
	}
	private static int findCalcSum2( int[] workArray, int idx, int sum) {
		if(idx <= 0) return sum;
		return findCalcSum2(workArray, idx-1, sum+workArray[idx-1]);
	}
	

}
