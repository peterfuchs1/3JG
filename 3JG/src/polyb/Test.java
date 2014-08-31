package polyb;
public class Test {
	public static void main(String[] args) {
		A[] a=new A[6];
		int i=0;
		a[i++]=new D();
//		a[i++]=new A(10);
		a[i++]=new B();
		a[i++]=new B(i);
//		a[i++]=new C();
		a[i++]=new C(i);
		a[i++]=new C(i);
		a[i++]=new D(i);
//		a[i++]=new A();
		for(i=0;i<a.length;i++)
			a[i].printValues();					
	}
}
