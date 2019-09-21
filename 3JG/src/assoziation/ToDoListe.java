package assoziation;

import java.io.*;
import java.util.Arrays;

public class ToDoListe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2122493726570151624L;
	private String name;
	private ToDoEintrag[] eintraege;

	public ToDoListe(String name) {
		this.name = name;
		init();
	}

	public void init() {
		this.eintraege = new ToDoEintrag[0];
	}

	public void addEintrag(String text) {
		eintraege = Arrays.copyOf(eintraege, eintraege.length + 1);
		eintraege[eintraege.length - 1] = new ToDoEintrag(text);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name).append("\n");
		for (int i = 0; i < eintraege.length; ++i) {
			sb.append(eintraege[i].getText()).append("\n");
		}
		return sb.toString();
	}

	public void laden(String filename) throws IOException {
		init();
		try (BufferedReader inputStream = new BufferedReader(new FileReader(filename))) {
			String text;
			while ((text = inputStream.readLine()) != null) {
				addEintrag(text);
			}
		}
	}

	public void speichern(String filename) throws IOException {
		File f = new File(filename);
		try (PrintWriter outputStream = new PrintWriter(new FileWriter(f))) {
			for (int i = 0; i < eintraege.length; ++i) {
				outputStream.println(eintraege[i].getText());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ToDoListe t = new ToDoListe("Hallo Welt");
		t.addEintrag("Einkaufen");
		t.addEintrag("Hausuebung machen");
		System.out.println(t.toString());
		// Einträge sichern
//		t.speichern("test1.txt");
//		t.laden("test1.txt");
//		System.out.println(t.toString());
		// Objekt t serialisieren
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ToDo.txt"))) {
			outputStream.writeObject(t);
		} catch (IOException e) {
			System.err.println("Beim Schreiben trat ein Fehler auf: " + e.toString());
		}
		// Objekt t deserialisieren
		t = null;
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ToDo.txt"))
			) {
			t = (ToDoListe) inputStream.readObject();
		} catch (IOException e) {
			System.err.println("Beim Schreiben trat ein Fehler auf: " +
					e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Beim Schreiben trat ein Fehler auf: " +
					e.toString());
		}
		System.out.println(t.toString());
	}
}