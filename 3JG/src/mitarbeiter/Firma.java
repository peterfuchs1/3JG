package mitarbeiter;

public class Firma {
	private Zahlung[] liste;

	public Firma() {
		liste = new Zahlung[10];
	}
	public void setZahlungen(Zahlung z, int i) {
		liste[i]=z;
	}
	public void setMitarbeiter(Mitarbeiter m, int i) {
		liste[i]=m;
	}
	
	public String namen() {
		String alle="";
		for (int i=0;i<liste.length;++i) {
			if(liste[i]!=null)
				alle +=liste[i].getName()+"\n";
		}
		return alle;
	}
	public static void main(String[] args) {
		Firma f=new Firma();
		f.setMitarbeiter(new Angestellter("Ang1", 23, 2000), 0);
		f.setMitarbeiter(new Arbeiter("Arb1", 20, 2000), 1);
		f.setMitarbeiter(new Angestellter("Ang2", 23, 2000), 2);
		f.setMitarbeiter(new Arbeiter("Arb2", 20, 2000), 3);
		f.setZahlungen(new Projekt("mein Projekt",1400), 4);
		System.out.println(f.namen());
		System.out.println("Lohnkosten: "+f.bezahlung());
	}
	public double bezahlung() {
		double z=0;
		for (int i=0;i<liste.length;++i) {
			if(liste[i]!=null)
				z +=liste[i].zahlung();
		}
		return z;
	}
}
