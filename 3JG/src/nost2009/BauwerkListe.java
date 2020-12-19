package nost2009;

public class BauwerkListe {
	private Bauwerk[] liste;
	public BauwerkListe() { liste = new Bauwerk[10];}
	public void setBauwerk(Bauwerk f, int i) {
		if(liste[i]==null)
			liste[i]=f;
	}
	public String gesamt() {
		String s="";
		for (int i=0;i<liste.length;++i) {
			if(liste[i]!= null)
				s += liste[i].beschreibung()+"\n";
		}
		return s;
	}
	public static void main(String[] args) {
		BauwerkListe p= new BauwerkListe();
		p.setBauwerk(new Garage("TGM-Garage", 200000, 210), 1);
		p.setBauwerk(new Garage("Opern-Garage", 220000, 120), 2);
		p.setBauwerk(new Garage("Ring-Garage", 350000, 320), 2);
		p.setBauwerk(new Haus("TGM", 4000000, 280), 6);
		System.out.println(p.gesamt()); 
	}

}
