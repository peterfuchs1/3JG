package rekursion;

public class TestRekursionen {

	public static void main(String[] args) {
//		Utils.DEBUG=true;
//		System.out.println("Die Summe aller nat�rlichen Zahlen bis 6: "+Utils.sum(6));
//		System.out.println("Die Summe aller nat�rlichen Zahlen bis 6: "+Utils.sum2(6));
//		System.out.println("Die Fakult�t (6!) betr�gt: "+Utils.fact(6));
//		System.out.println("Die Fakult�t (6!) betr�gt: "+Utils.fact2(6));
//		System.out.println("Der ggT von 1071 und 1029 betr�gt: "+Utils.euclid(1071, 1029));
//		System.out.println("Die Fibonacci-Zahl 13 betr�gt: "+ Utils.fib(13));
//		System.out.println("Die Zahl 34 ist gerade: " + Utils.gerade(99));
//		System.out.println("Die Zahl 33 ist ungerade: " + Utils.ungerade(33));
//		System.out.println("Der Rest der Ganzzahl-Division(rekursiv) 1271/57= "+Utils.rest1(1271, 57));
//		System.out.println("Der Rest der Ganzzahl-Division(iterativ) 1271/57= "+Utils.rest(1271, 57));
//		System.out.println("Der Summe der Quadrate von 0 bis 10(rekursiv) betr�gt "+Utils.sum_quad_rec(10));
//		System.out.println("Der Summe der Quadrate von 0 bis 10(endrekursiv) betr�gt "+Utils.sum_quad_endrec(10));
//		System.out.println("Der Summe der Quadrate von 0 bis 10(iterativ) betr�gt "+Utils.sum_quad(10));
		System.out.println("Problematische Rekursion mit 34: "+Utils.rec1(-1				));
		int b=1;
		System.out.println("Fibonacci fib("+b+") betr�gt:"+Utils.fib(b));
		System.out.println("Double-Summe s1 ("+b+") betr�gt:"+Utils.double_s1(b));
		System.out.println("Double-Summe s2 ("+b+") betr�gt:"+Utils.double_s2(b));
		System.out.println("Gemischt-1 ("+b+") betr�gt:"+Utils.nicht_assoziativ1(b));
		System.out.println("Gemischt-2 ("+b+") betr�gt:"+Utils.nicht_assoziativ2(b));
		System.out.println("fn "+b+") betr�gt:"+Utils.f7_sum1(b));
		System.out.println("fn "+b+") betr�gt:"+Utils.f7_sum2(b));
		System.out.println("fn2 "+b+") betr�gt:"+Utils.func1(b));
		System.out.println("fn3 "+b+") betr�gt:"+Utils.func2(b));
		System.out.println("nicht-assoziativ "+b+") betr�gt:"+Utils.nicht_assoziativ1(b));
		System.out.println("nicht-assoziativ endrekursiv "+b+") betr�gt:"+Utils.nicht_assoziativ2(b));
		int[] intA = new int[20];
		int value = 0;
		for (int i=0;i< intA.length; ++i) 
			intA[i]=value++;
		Utils.printArrayRec(intA, intA.length-1);
		System.out.println("Max des intArrays: "+Utils.findMax(intA,intA.length-1));
		System.out.println("Min des intArrays: "+Utils.findMin(intA,intA.length-1));
		System.out.println("Summe des intArrays: "+Utils.calcSum(intA,intA.length-1));
	}

}
