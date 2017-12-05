package rekursion;

public class TestRekursionen {

	public static void main(String[] args) {
		//Utils.DEBUG=true;
		System.out.println("Die Summe aller natürlichen Zahlen bis 6: "+Utils.sum(6));
		System.out.println("Die Summe aller natürlichen Zahlen bis 6: "+Utils.sum2(6));
		System.out.println("Die Fakultät (6!) beträgt: "+Utils.fact(6));
		System.out.println("Die Fakultät (6!) beträgt: "+Utils.fact2(6));
		System.out.println("Der ggT von 1071 und 1029 beträgt: "+Utils.euclid(1071, 1029));
		System.out.println("Die Fibonacci-Zahl 13 beträgt: "+ Utils.fib(13));
	}

}
