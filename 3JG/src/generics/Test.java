package generics;

public class Test {
public static <T extends Comparable <T>> int firstSmallerThan(T[] f, T a){
	int i;
	for(i=0;i<f.length;++i) {
		if(f[i].compareTo(a)<0) return i;
	}
	return -1;
}
	public static void main(String[] args) {
		Integer[] f= {9,8,7,6,4,3,2};
		System.out.println(Test.firstSmallerThan(f,new Integer(5)));
	}

}
