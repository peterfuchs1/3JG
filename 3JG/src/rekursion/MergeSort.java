package rekursion;

import java.util.List;
import java.util.ArrayList;

public class MergeSort<T extends Comparable<? super T>> {
	/* source list */
	private List<T> source;

	/**
	 * source List
	 * 
	 * @param source
	 */
	public MergeSort(List<T> source) {
		this.source = source;
	}

	/**
	 * start the merge sort process
	 * 
	 * @return sorted list
	 */
	public List<T> start() {
		return sorting(source);
	}

	/**
	 * MergeSort
	 * 
	 * @param source
	 * @return
	 */
	private List<T> sorting(List<T> source) {
		/* return list with not more one element */
		if (source.size() <= 1)
			return source;
		else {
			// create a left and a right part
			List<T> left = new ArrayList<T>();
			List<T> right = new ArrayList<T>();
			int ssize =source.size();
			int middle = ssize / 2;
			// initialize the left part
			for (int i = 0; i < middle; i++)
				left.add(source.get(i));
			// initialize the right part
			for (int i = middle; i < ssize; i++)
				right.add(source.get(i));

			// merge the sorted parts into a new list
			return merge(sorting(left), sorting(right));
		}
	}

	/**
	 * Merge to lists into a new list
	 * 
	 * @param a
	 *            left part
	 * @param b
	 *            right part
	 * @return merged list
	 */
	private List<T> merge(List<T> a, List<T> b) {
		List<T> ret = new ArrayList<T>();
		int asize = a.size(), bsize = b.size(); // performance
		int ia = 0, ib = 0;
		while (ia < asize || ib < bsize) {
			if (ia < asize && ib < bsize) {
				if (a.get(ia).compareTo(b.get(ib)) <= 0) {
					ret.add(a.get(ia));
					ia++;
				} else {
					ret.add(b.get(ib));
					ib++;
				}
			} else if (ia < asize) {
				ret.add(a.get(ia));
				ia++;
			} else {
				ret.add(b.get(ib));
				ib++;
			}
		}
		return ret;
	}

}
