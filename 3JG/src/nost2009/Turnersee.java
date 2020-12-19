package nost2009;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Turnersee {
	private WetterEintrag[] werte;
	public Turnersee() {werte = new WetterEintrag[0];}
	public void addWert(WetterEintrag we) {
		werte = Arrays.copyOf(werte, werte.length + 1);
		werte[werte.length - 1] = we;
	}
	// IOException kann auch direkt in speichern behandelt werden
	public void speichern(String filename) throws IOException {
		try (PrintWriter outputStream = new PrintWriter(filename)) {
			for (int i = 0; i < werte.length; ++i) {
				outputStream.print(werte[i].getDatum());
				outputStream.print(";");
				outputStream.println(werte[i].getWert());
			}
		}
	}

	// IOException kann auch direkt in laden behandelt werden
	public void laden(String filename) throws IOException {
		try (BufferedReader inputStream = new BufferedReader(new FileReader(filename))) {
			String text;
			while ((text = inputStream.readLine()) != null) {
				String[] s = text.split(";");
				WetterEintrag p = new WetterEintrag(s[0], Float.parseFloat(s[1]));
				addWert(p);
			}
		}
	}

	public static void main(String[] args) {
		Turnersee p = new Turnersee();
		try {
			p.laden("Turnersee.txt");
			p.addWert(new WetterEintrag("2020-09-01", 18));
			p.addWert(new WetterEintrag("2020-09-02", 19));
			p.speichern("TurnerseeNeu.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
