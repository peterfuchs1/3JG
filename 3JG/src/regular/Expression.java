package regular;

public class Expression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String EXAMPLE_TEST = "Hier wurden häufig Leerzeichen verwendet , "
				+ "obwohl dies das Lesen und Verstehen erschwert    ! "
				+ "Aber ist es wirklich so einfach ? Alles klar ?";
		String pattern = "(\\w)(\\s+)([\\.,!\\?])";
		System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));
		String[] tel=new String[4];
		int i=0;
		tel[i++]="+43664 4323553";
		tel[i++]="+431 33126321";
		tel[i++]="+4365011345678";
		tel[i++]="+432272 70483";
		
		while(--i>=0)
			System.out.println(tel[i]+" ist " +
					((tel[i].matches("^\\+43[1-9]{1,4} ?\\d{4,10}$"))?' ':'k')+"eine gueltige Telefonnummer");
		String pattern2="^[wieder]+(hol){1,3}ung?";
		i=0;
		String[] test=new String[5];
		test[i++]="Wiederholung";
		test[i++]="erholung";
		test[i++]="holung";
		test[i++]="derholunderstrauch";
		test[i++]="wiederwiederholholungung";
		while(--i>=0)
			System.out.println(test[i].matches(pattern2));
	}
	
}
