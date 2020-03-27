package generics;

public class Tools {
	public static <T extends Comparable<T>>
	  int firstEqualThan(T[] a, T b) {
	    for (int i=0;i<a.length;i++) {
	      if (a != null && a[i].compareTo(b) == 0) 
	        return i;
	    }
	    return -1;
	}

	public static <T> T[] fillAlternate(T[] f, T a, T b) {
		for (int i=0;i<f.length;++i) {
			f[i] = (i%2==0)?a:b;
		}
		return f;
	}
	public static void main(String[] args) {
		Character c[]=new Character[20];
		c=Tools.fillAlternate(c, 'X', 'O');
		for(int i=0;i<c.length;++i)
			System.out.print(c[i]);
		Integer integer[]=new Integer[20];
		for(int i=0;i<integer.length; ++i) {
			integer[i]=i;
		}
		System.out.println();
		System.out.println(Tools.firstEqualThan(integer, 9));
	}
}
