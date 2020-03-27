package file2;

import java.io.*;
import java.util.Arrays;


public class Wien {
	private Temperatur[] werte;

	public Wien() {
		werte = new Temperatur[0];
	}

	public void addWert(Temperatur t) {
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
				Temperatur p = new Temperatur(s[0], Float.parseFloat(s[1]));
				addWert(p);
			}
		}
	}

	public static void main(String[] args) {
		Wien p = new Wien();
		try {
			p.laden("Wien.txt");
			p.addWert(new Temperatur("2020-01-15", 6));
			p.addWert(new Temperatur("2020-01-16", 7));
			p.speichern("WienNeu.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
