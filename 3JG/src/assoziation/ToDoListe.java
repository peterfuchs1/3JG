package assoziation;

import java.util.Arrays;

public class ToDoListe {

	private String name;
	private ToDoEintrag[] eintraege;

	public ToDoListe(String name) {
		this.name = name;
		this.eintraege = new ToDoEintrag[0];
	}

	public void addEintrag(String text) {
		eintraege=Arrays.copyOf(eintraege, eintraege.length+1);
		eintraege[eintraege.length-1]=new ToDoEintrag(text);
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(this.name).append("\n");
		for(int i=0;i<eintraege.length;++i) {
			sb.append(eintraege[i].getText()).append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		ToDoListe t = new ToDoListe("Hallo Welt");
		t.addEintrag("Einkaufen");
		t.addEintrag("Hausuebung machen");
		System.out.println(t.toString());
	}
}