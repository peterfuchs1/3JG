package rekursion;

public class TestRekursionen {

	public static void main(String[] args) {
//		Utils.DEBUG=true;
//		System.out.println("Die Summe aller natürlichen Zahlen bis 6: "+Utils.sum(6));
//		System.out.println("Die Summe aller natürlichen Zahlen bis 6: "+Utils.sum2(6));
//		System.out.println("Die Fakultät (6!) beträgt: "+Utils.fact(6));
//		System.out.println("Die Fakultät (6!) beträgt: "+Utils.fact2(6));
//		System.out.println("Der ggT von 1071 und 1029 beträgt: "+Utils.euclid(1071, 1029));
//		System.out.println("Die Fibonacci-Zahl 13 beträgt: "+ Utils.fib(13));
//		System.out.println("Die Zahl 34 ist gerade: " + Utils.gerade(99));
//		System.out.println("Die Zahl 33 ist ungerade: " + Utils.ungerade(33));
//		System.out.println("Der Rest der Ganzzahl-Division(rekursiv) 1271/57= "+Utils.rest1(1271, 57));
//		System.out.println("Der Rest der Ganzzahl-Division(iterativ) 1271/57= "+Utils.rest(1271, 57));
//		System.out.println("Der Summe der Quadrate von 0 bis 10(rekursiv) beträgt "+Utils.sum_quad_rec(10));
//		System.out.println("Der Summe der Quadrate von 0 bis 10(endrekursiv) beträgt "+Utils.sum_quad_endrec(10));
//		System.out.println("Der Summe der Quadrate von 0 bis 10(iterativ) beträgt "+Utils.sum_quad(10));
		System.out.println("Problematische Rekursion mit 34: "+Utils.rec1(-1				));
		int b=1;
		System.out.println("Fibonacci fib("+b+") beträgt:"+Utils.fib(b));
		System.out.println("Double-Summe s1 ("+b+") beträgt:"+Utils.double_s1(b));
		System.out.println("Double-Summe s2 ("+b+") beträgt:"+Utils.double_s2(b));
		System.out.println("Gemischt-1 ("+b+") beträgt:"+Utils.nicht_assoziativ1(b));
		System.out.println("Gemischt-2 ("+b+") beträgt:"+Utils.nicht_assoziativ2(b));
		System.out.println("fn "+b+") beträgt:"+Utils.f7_sum1(b));
		System.out.println("fn "+b+") beträgt:"+Utils.f7_sum2(b));
		System.out.println("fn2 "+b+") beträgt:"+Utils.func1(b));
		System.out.println("fn3 "+b+") beträgt:"+Utils.func2(b));
		System.out.println("nicht-assoziativ "+b+") beträgt:"+Utils.nicht_assoziativ1(b));
		System.out.println("nicht-assoziativ endrekursiv "+b+") beträgt:"+Utils.nicht_assoziativ2(b));
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
