package polya;
public class B extends A {
	private int val;
	public B() {val=27;}
	public B(int val) {
		this.val=-3;
		this.setValue(val);
	}
	public void printValues(){
		System.out.println("value: "+val);
	}
}
