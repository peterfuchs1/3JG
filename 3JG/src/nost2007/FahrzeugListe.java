package nost2007;

public class FahrzeugListe {
	private Fahrzeug[] liste;
	public FahrzeugListe() { liste = new Fahrzeug[10];}
	public void setFahrzeug(Fahrzeug f, int i) {
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
		FahrzeugListe p= new FahrzeugListe();
		p.setFahrzeug(new PKW("Ford", 20000, 210), 1);
		p.setFahrzeug(new PKW("Opel", 22000, 120), 2);
		p.setFahrzeug(new PKW("Porsche", 35000, 320), 2);
		p.setFahrzeug(new Fahrrad("Driver", 400, 21), 6);
		System.out.println(p.gesamt()); 
	}

}
