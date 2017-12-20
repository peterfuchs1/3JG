package poly;

public abstract class Klasse1 implements Interface1 {

	public void methode1(String param) {

	}

	protected abstract void methode3(double param);

	public void methode4(Interface1 param) {

	}


	/**
	 * @see poly.Interface1#methode1(int)
	 */
	public void methode1(int param) {

	}


	/**
	 * @see poly.Interface1#methode2(java.lang.String, boolean)
	 */
	public int methode2(String param1, boolean param2) {
		return 0;
	}

}
