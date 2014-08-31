package polymorphie;

public class Ueberladen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void irgendeineMethode( int i, double d, String s){
		
	}
	
	
	public static int max( int i, int j ) {
		  return Math.max( i, j );
	}
	public static int max( double d, int i){
		return (int) Math.max(d, (double)i);
	}
	public static int max(int[] a){
		int ret=a[0];
		for(int i=1;i<a.length;i++)
			if(a[i]>a[i-1]) ret=a[i];
		return ret;
	}
	public static int max(int i,int j, int k){
		return  max( i, max(j, k) ); 
	}
}
