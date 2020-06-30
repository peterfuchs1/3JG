package cjethan;

import java.util.*;

/**
 * Die Klasse Regex überprüft, welche Elemente einer Liste dem Regex entsprechen und welche nicht.
 * (Auf Kommentare wurde bei (überladenen) Setter- und Getter-Methoden, sowie Konstruktoren verzichtet)
 * @author Caroline Jethan
 * @version 2020-03-03
 */
public class Regex {
	private List<String> strings = new ArrayList<String>();
	private String regex = "";

	public String[] getStrings() {
		String[] s = new String[strings.size()];
		for (int i = 0; i < strings.size(); i++) {
			s[i] = strings.get(i);
		}
		return s;
	}

	public String getString(int i) {
		return strings.get(i);
	}

	public void setStrings(String[] st) {
		this.strings.clear();
		for (int i = 0; i < st.length; i++) {
			this.strings.add(st[i]);
		}
	}

	/**
	 * Fügt einen String der Liste an.
	 * @param s String
	 */
	public void addString(String s) {
		this.strings.add(s);
	}

	public void setStrings(List<String> l) {
		this.strings = l;
	}

	/**
	 * Fügt ein Array aus Strings der Liste an.
	 * @param st String Array
	 */
	public void addStrings(String[] st) {
		for (int i = 0; i < st.length; i++) {
			this.strings.add(st[i]);
		}
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Regex(List<String> l) {
		this.setStrings(l);
	}

	public Regex(List<String> l, String regex) {
		this.setStrings(l);
		this.setRegex(regex);
	}

	public Regex(String[] st, String regex) {
		this.setRegex(regex);
		this.setStrings(st);
	}

	public Regex(String[] st) {
		this.setStrings(st);
	}

	public Regex(String s) {
		this.regex = s;
	}

	public Regex(String s, String regex) {
		this.setRegex(regex);
	}

	/**
	 * Überprüft, ob der String an der Stelle passt oder nicht.
	 * @param i Index
	 * @return true, wenn es passt
	 */
	public boolean match(int i) {
		if (this.getString(i).matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String regex = "^(www|java|[1-9]{3})\\.([a-z]*|[0-9]*)((\\.[a-z]*)*|(\\.[1-9]*)*)\\.(com|net|at|[0-9])$";
		Regex r = new Regex(regex);
		String[] s = { "www.ibm.com", "www.java.sun.com", "www.zend.com", "java.sun.com", "www.php.net", "www.IBM.com",
				"www.ris.bka.gv.at", "www.Web addresses can't have spaces.com", "www..com2", "192.168.1.0" };
		r.setStrings(s);
		for (int i = 0; i < s.length; i++) {
			if (r.match(i)) {
				System.out.println(r.getString(i) + " ist korrekt");
			} else {
				System.out.println(r.getString(i) + " ist nicht korrekt");
			}
		}
	}
}
