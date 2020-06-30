package nost2007;

public class Generic {
	public static  <T extends Number> double minimum(T[] n){
		double min= n[0].doubleValue();
		for (int i=1;i<n.length;++i) {
			if(n[i].doubleValue()<min)
				min=n[i].doubleValue();
		}
		return min;
	}
	public static void main(String[] args) {
		Integer[] noten=new Integer[16];
		for(int i=0;i<noten.length;++i) {
			noten[i]=(int)(Math.random()*5+1);
		}
		System.out.println(Generic.minimum(noten));
	}

}
