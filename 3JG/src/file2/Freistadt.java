package file2;

import java.io.*;
import java.util.Arrays;


public class Freistadt {
	private WetterEintrag[] werte;

	public Freistadt() {
		werte = new WetterEintrag[0];
	}

	public void addWert(WetterEintrag t) {
		werte = Arrays.copyOf(werte, werte.length + 1);
		werte[werte.length - 1] = t;
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
		Freistadt p = new Freistadt();
		try {
			p.laden("Freistadt.txt");
			p.addWert(new WetterEintrag("2020-07-01", 30));
			p.addWert(new WetterEintrag("2020-07-02", 25));
			p.speichern("FreistadtNeu.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
