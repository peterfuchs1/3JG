package polyb;
public class D extends C {
	public D(){super(9);}
	public D(int value) {
		super(value);
	}
	@Override
	public void printValues() {
		System.out.println(
		"value: "+getValue()+9);
	}
}
