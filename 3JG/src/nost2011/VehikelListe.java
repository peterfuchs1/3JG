package nost2011;

public class VehikelListe {
	private Vehikel[] liste;
	public VehikelListe() { liste = new Vehikel[10];}
	public void setVehikel(Vehikel f, int i) {
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
		VehikelListe p= new VehikelListe ();
		p.setVehikel (new Motorrad("TGM-Motorrad", 20000, 120), 1);
		p.setVehikel (new Motorrad ("Suzuki Katana", 13000, 160), 2);
		p.setVehikel (new Motorrad ("Yamaha MT-10", 7000, 160), 2);
		p.setVehikel (new Kutsche("TGM-Kutsche", 8000, 6), 6);
		System.out.println(p.gesamt()); 
	}


}
