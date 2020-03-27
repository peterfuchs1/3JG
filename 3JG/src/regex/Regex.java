package regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Diese Klasse soll Hostnamen als richtig doer falsch erkennen.
 * @author 	Gary Ye
 * @version 2013-02-16
 */
public class Regex {
	public final static String URL_REGEX = "([a-z][a-z\\d]+\\.)+[a-z]{2,3}|(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
	private List<String> strings;
	private String regex;
	/**
	 * Der Defaultkonstruktor von Regex
	 */
	public Regex(){
		initList();
		setRegex("");
	}
	/**
	 * Der Konstruktor, der eine Zeichenkette in die Liste hinzufügt.
	 * @param s
	 */
	public Regex(String s){
		this(s, "");
	}
	/**
	 * Der Konstruktor, der eine Zeichenkette in die Liste hinzufügt und auch
	 * die Regular Expression Zeichenkette einen Wert zuweist.
	 * @param s
	 * @param regex
	 */
	public Regex(String s, String regex){
		initList();
		addString(s);
		setRegex(regex);
	}
	/**
	 * Der Konstruktor, der der Liste eine neue Liste zuweist.
	 * @param l
	 */
	public Regex(List<String> l){
		this(l, "");
	}
	/**
	 * Der Konstruktor, der der Liste eine neue Liste zuweist und auch
	 * die Regular Expression Zeichenkette einen Wert zuweist.
	 * 
	 * @param l
	 * @param regex
	 */
	public Regex(List<String> l, String regex){
		initList();
		setStrings(l);
		setRegex(regex);
	}
	/**
	 * Der Konstruktor, der der Liste eine neue Liste zuweist.
	 * @param st
	 */
	public Regex(String[] st){
		this(st, "");
	}
	/**
	 * Der Konstruktor, der der Liste eine neue Liste zuweist und auch
	 * die Regular Expression Zeichenkette einen Wert zuweist.
	 * @param st 
	 * @param regex
	 */
	public Regex(String[] st, String regex){
		initList();
		setStrings(st);
		setRegex(regex);
	}
	/**
	 * Initialisiert eine neue Liste
	 */
	private void initList(){
		strings = new ArrayList<String>();
	}
	/**
	 * @param i die Stelle i
	 * @return gibt zurück ob das i-te Element der Liste mit der Regular Expression matched.
	 */
	public boolean match(int i){
		return strings.get(i).matches(this.regex);
	}
	/**
	 * @return gibt zurück ob alle Element der Liste mit der Regular Expression übereinstimmen.
	 */
	public boolean match(){
		boolean matchesAll = true;
		for(int i = 0; i < strings.size() && matchesAll; i++)
			matchesAll &= match(i);
		return matchesAll;
	}
	/**
	 * @param s der String
	 * @return gibt zurück ob der String mit dem Regex übereinstimmt.
	 */
	public boolean match(String s){
		return s.matches(regex);
	}
	/**
	 * @return die Liste als eine Array zurück.
	 */
	public String[] getStrings(){
		return strings.toArray(new String[strings.size()]);
	}
	/**
	 * @param i
	 * @return gibt das i-te Element der Liste zurück.
	 */
	public String getString(int i){
		return this.strings.get(i);
	}
	/**
	 * Weist der Liste einen neuen Wert zu.
	 * @param st die neue Liste
	 */
	public void setStrings(String[] st){
		strings = Arrays.asList(st);
	}
	/**
	 * Fügt zu der Liste einen String hinzu.
	 * @param s der String
	 */
	public void addString(String s){
		this.strings.add(s);
	}
	/**
	 * Weist der Liste einen neuen Wert zu.
	 * @param l die neue Liste
	 */
	public void setStrings(List<String> l){
		this.strings = new ArrayList<String>(l);
	}
	/**
	 * Nimmt ein Array von Strings an und fügt alle Elemente zu der Liste hinzu.
	 * @param st Array von Strings
	 */
	public void addStrings(String[] st){
		for(int i = 0; i<  st.length; i++)
			addString(st[i]);
	}
	
	/**
	 * Weist der Zeichenkette regex einen neuen Wert zu.
	 * @param regex der neue Wert
	 */
	public void setRegex(String regex){
		this.regex = new String(regex);
	}
}

