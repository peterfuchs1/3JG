package rekursion;

public class TestRekursionen {

	public static void main(String[] args) {
		//Utils.DEBUG=true;
		System.out.println("Die Summe aller nat�rlichen Zahlen bis 6: "+Utils.sum(6));
		System.out.println("Die Summe aller nat�rlichen Zahlen bis 6: "+Utils.sum2(6));
		System.out.println("Die Fakult�t (6!) betr�gt: "+Utils.fact(6));
		System.out.println("Die Fakult�t (6!) betr�gt: "+Utils.fact2(6));
		System.out.println("Der ggT von 1071 und 1029 betr�gt: "+Utils.euclid(1071, 1029));
		System.out.println("Die Fibonacci-Zahl 13 betr�gt: "+ Utils.fib(13));
	}

}
