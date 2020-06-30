package cut;

import java.util.Arrays;
import java.util.Random;

public class Lottery {
	private Random rand = new Random();

	public int[] draw(int min, int max, int count) {
		int[] v = new int[count];
		for (int i = 0; i < count; i++) {
			int d = rand.nextInt(max - min + 1) + min;
			v[i] = d;
		}
		Arrays.sort(v);
		return v;
	}
}
