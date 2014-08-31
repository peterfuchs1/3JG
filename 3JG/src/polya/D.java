package polya;
public class D extends C {
	public D(){super(99);}
	public D(int value) {
		super(value);
	}
	@Override
	public void printValues() {
		System.out.println(
		"value: "+getValue()+10);
	}
}
