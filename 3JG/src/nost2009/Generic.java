package nost2009;

public class Generic {
	public static  <T extends Number> double maximum(T[] n){
		double max= n[0].doubleValue();
		for (int i=1;i<n.length;++i) {
			if(n[i].doubleValue()>max)
				max=n[i].doubleValue();
		}
		return max;
	}
	public static void main(String[] args) {
		Integer[] noten=new Integer[16];
		for(int i=0;i<noten.length;++i) {
			noten[i]=(int)(Math.random()*5+1);
		}
		System.out.println(Generic.maximum(noten));
	}

}
