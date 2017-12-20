package test3a1;
public class MyDataImpl implements Check {

	public boolean isNull(String str) {
		System.out.println("nothing todo");
		return false;
	}
	
	public static void main(String args[]){
		MyDataImpl obj = new MyDataImpl();
		obj.print("");
		obj.isNull("abc");
	}
}