package polyb;
public class B extends A {
	private int val;
	public B() {val=17;}
	public B(int val) {
		this.val=-33;
		this.setValue(val);
	}
	public void printValues(){
		System.out.println("value: "+val);
	}
}
