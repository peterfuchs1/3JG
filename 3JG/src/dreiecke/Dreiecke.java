package dreiecke;

import java.util.*;
/**
 * Dreieckskonstruktion:
 * 
 * <br>Winkel im Dreieck: 
 * <br>  wa steht für α, 
 * <br>  wb steht für β,
 * <br>  wc steht für γ
 * <br>Die Winkel werden im Bogenmaß (wa+wb+wc=2π) eingegeben.
 * <br>Eingabe der Seiten: a, b, c
 * <br>Eingabe der Winkel: wa, wb, wc 
 * <br>      - www: 3 Winkel gegeben: ist nicht eindeutig
 * <br>      z.B.: {wa=3.14, wb=1.0, wc=2.14}
 * <br>      - sss: 3 Seiten gegeben: Dreiecksungleichung!
 * <br>      z.B.: {a=3.0, b=4.0, c=5.0}
 * <br>      - ssw: Angabe möglich
 * <br>      z.B.: {a=3.0, b=2.5, wa=2.0}
 * <br>      - wsw: Angabe möglich
 * <br>      z.B.: {c=3.0, a=5.0, wb=4.0}
 * <br>      - sws: Angabe möglich
 * <br>      z.B.: {a=3.0, c=5.0, wb=4.0}
 *      
 * @author Walter Rafeiner-Magor
 * @version 2018-04-22
 *
 */
public class Dreiecke {

	public static final List<String> SSS = Arrays.asList("a","b","c");
	private static final List<String> sws1= Arrays.asList("c","a","wb");
	private static final List<String> sws2= Arrays.asList("a","b","wc");
	private static final List<String> sws3= Arrays.asList("b","c","wa");
	public static final List<List<String>> SWS=Arrays.asList(sws1,sws2,sws3);
	private static final List<String> wsw1= Arrays.asList("b","wc","wa");
	private static final List<String> wsw2= Arrays.asList("a","wb","wc");
	private static final List<String> wsw3= Arrays.asList("c","wa","wb");
	public static final List<List<String>> WSW=Arrays.asList(wsw1,wsw2,wsw3);
	private static final List<String> ssw1= Arrays.asList("b","c","wb");
	private static final List<String> ssw2= Arrays.asList("a","b","wa");
	private static final List<String> ssw3= Arrays.asList("c","a","wc");
	public static final List<List<String>> SSW=Arrays.asList(ssw1,ssw2,ssw3);
	public static final List<String> WWW = Arrays.asList("wa","wb","wc");
	/**
	 * check
	 * Untersucht den Parameter ob ein Dreieck konstruierbar ist.
	 * 
	 * @param d Dreiecksangabe 
	 * @return true, wenn korrekt konstruierbar, ansonsten false
	 */
	public static boolean check(HashMap<String,Double> d) {

 		boolean ret=false;
		if(d.size()!=3) return false;
		Set<String> s=d.keySet();
		List<String> l=new ArrayList<String>(s);
		if (s.containsAll(SSS)) {
            if (d.get("a")+d.get("b") <= d.get("c") ||
                    d.get("a") + d.get("c") <= d.get("b") ||
                    d.get("c") + d.get("b") <= d.get("a"))
            	return false;
            else
            	return true;			
		}
		if(SWS.contains(l)) return true;
		if(SSW.contains(l)) return true;
		return ret;
	}
	/**
	 * checkText
	 * Untersucht den Parameter ob ein Dreieck konstruierbar ist.
	 * 
	 * @param d Dreiecksangabe
	 * @return textuelle Beschreibung, ob ein Dreieck konstruierbar ist; bzw. Fehlerhinweis
	 * <br>positiv: Ein Dreieck kann mit den Daten konstruiert werden
	 * <br>negativ: Ein Dreieck benoetigt zur Konstruktion 3 Parameter (x bekommen)
	 * <br>			Die Dreiecksungleichung ist nicht erfüllt
	 * <br>			Ein Dreieck ist mit den Daten nicht konstruierbar
	 * <br>			Dreieck ist nicht eindeutig: 3 Winkel
	 */
	public static String checkText(HashMap<String,Double> d) {
 		String ret="Ein Dreieck kann mit den Daten konstruiert werden";
 		int anzahl=d.size();
		if(anzahl!=3) return "Ein Dreieck benoetigt zur Konstruktion 3 Parameter ("+anzahl+" bekommen)";
		Set<String> s=d.keySet();
		List<String> l=new ArrayList<String>(s);
		if (s.containsAll(SSS)) {
            if (d.get("a")+d.get("b") <= d.get("c") ||
                    d.get("a") + d.get("c") <= d.get("b") ||
                    d.get("c") + d.get("b") <= d.get("a"))
            	return "Die Dreiecksungleichung ist nicht erfuellt";
            else
            	return ret;			
		}
		if(SWS.contains(l)) return ret;
		if(SSW.contains(l)) return ret;
		if(s.containsAll(WWW)) return "Dreieck ist nicht eindeutig: 3 Winkel";
		return "Ein Dreieck ist mit den Daten nicht konstruierbar";
	}

}
