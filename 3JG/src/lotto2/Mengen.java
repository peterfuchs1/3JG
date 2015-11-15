package lotto2;

import java.util.HashSet;
import java.util.Set;

public final class Mengen {

		public final static <T extends Comparable<T>> Set<T> intersection(
				final Set<T> first, 
				final Set<T> second) {
		    final Set<T> copy = new HashSet<>(first);
		    copy.retainAll(second);
		    return copy;
		}

		public static <T extends Comparable<T>> Set<T> union(final Set<T> first, final Set<T> second) {
		    final Set<T> copy = new HashSet<>(first);
		    copy.addAll(second);
		    return copy;
		}
}
