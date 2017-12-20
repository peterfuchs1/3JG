package test3a1;

public class Generics {

	public static <T> T zufall(T a,T b,T c,T d) {
		double r=Math.random();
		if (r< 0.25) return a;
		if (r< 0.5) return b;
		if (r< 0.75) return c;
		return d;
	}

	public static void main(String[] args) {
		Integer d= Generics.zufall(1, 2, 3, 4);
		System.out.println(d);

	}

}
