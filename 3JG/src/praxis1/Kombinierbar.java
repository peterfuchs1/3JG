package praxis1;

import java.util.Arrays;

public interface Kombinierbar {
	public final static int MAX_SIZE=500;
	public default int[] kombinieren (int[] a, int[] b) {
		int[] r=Arrays.copyOf(a, a.length+b.length);
		for (int i=a.length, j=0;i<a.length+b.length;++i,++j) {
			r[i]=b[j];
		}
		return r;
	}
}
