package test1;

public class TestQuadrat {
	public static void main(String[] args) {
		Quadrat q1=new Quadrat(-4);
		Quadrat q2=new Quadrat(2);
		System.out.println(q1.text());
		System.out.println(q2.text());
		System.out.println("Quadrat1 ist kleiner als Quadrat2: "+q1.istKleiner(q2));
	}
}
