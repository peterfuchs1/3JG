package polymorphie;

public class TypanpassungExplizit {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		double dValue=1234.5E27;
		byte bValue=(byte) dValue;
		short sValue=(short)dValue;
		int iValue=(int) dValue+5;
		long lValue=11111111111111L;
		float fValue=(float)lValue;

	}

}
