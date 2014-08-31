package polyb;
public class C extends A {
	public C(int value) {
		super(value);
	}
	public void printValues(){
		System.out.println("value: "+(getValue()+9));
	}
}
