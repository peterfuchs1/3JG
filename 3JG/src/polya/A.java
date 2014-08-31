package polya;
public abstract class A implements Printing{
	private int value;
	public A(int value) {
		this.setValue(value);
	}
	public A() {
		this(0);
	}
	public void printValues(){
		System.out.println("value: "+getValue());
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
