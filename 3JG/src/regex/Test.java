/**
 * 
 */
package regex;

/**
 * @author Walter Rafeiner-Magor
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String EXAMPLE_TEST = "Hier wurden häufig Leerzeichen verwendet , "
				+ "obwohl dies das Lesen und Verstehen erschwert    ! "
				+ "Aber ist es wirklich so einfach ? Alles klar ?";
		String pattern = "(\\s)*([\\.,!\\?])";
		System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$2"));

		
		String[] test={
				"-------------A------------",
				"+43(1)33126 295",
				"+43(1) 33126 295",
				"+431 33126 295",
				"+43 1 33126 295",
				"+43-33126 295",
				"01/33126/295",
				"0133126295",
				"-------------B------------",
				"+43/1/33126 295",
				"+431/33126 295",
				"+431 33126295",
				"+43/1/33126295",
				"+43133126295",
				"01 33126 295",
				"01\\33126295",
				"01-33126-295"
	
				};
		pattern="" +
				"^((\\+\\d{2,4}( ?\\d+? ?))|(0\\d+? ?([ -|\\/]?) ?))\\d+?[0-9 \\/-]*\\d$";
		
		for (int i=0;i<test.length;i++){
			System.out.println(test[i]+" "+test[i].matches(pattern));
		}
	}
	
	


}
