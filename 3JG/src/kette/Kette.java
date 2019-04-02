package kette;
import java.util.ArrayList;


public class Kette {

	private ArrayList<Punkt> liste;

	public Kette() {
		this.liste =new ArrayList<>();
	}

	public Kette addPunkt(Punkt p) {
		this.liste.add(p);
		return this;
	}

	public Punkt removeLastPunkt() {
		return this.liste.remove(liste.size()-1);
	}

	public int anzahlPunkte() {
		return this.liste.size();
	}

	public double laenge() {
		return this.liste.size();
	}

}
