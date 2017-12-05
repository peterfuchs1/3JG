/**
 * 
 */
package baulexikon;

/**
 * @author uhs374h
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BauLexikon l= new BauLexikon();
		System.out.println(l.get("Pfette"));
		System.out.println(l.get("Halbolive"));
		System.out.println(l.get("Armierung"));
		System.out.println(l.values());
		System.out.println(l.keySet());
		System.out.println(l.containsKey("Mörtel"));
		System.out.println(l.containsValue("Bewehrung"));
	}

}
