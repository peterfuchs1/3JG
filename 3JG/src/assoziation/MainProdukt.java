package assoziation;

public class MainProdukt {

	public static void main(String[] args) {
		Produkt apfel=new Produkt(3.9);
		Produkt birne=new Produkt(4.2);
		Sparpaket s1=new Sparpaket(0.20, apfel);
		s1.add(birne);
		System.out.println("Das Sparpaket kostet: "+s1.gesamtPreis());
	}

}
