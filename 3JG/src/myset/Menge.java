package myset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * The <tt>SET</tt> class represents an ordered set. It assumes that the
 * elements are <tt>Comparable</tt>. It supports the usual <em>add</em>,
 * <em>contains</em>, and <em>delete</em> methods. It also provides ordered
 * methods for finding the <em>minimum</em>, <em>maximum</em>, <em>floor</em>,
 * and <em>ceiling</em>.
 * <p>
 * This implementation uses a balanced binary search tree. The <em>add</em>,
 * <em>contains</em>, <em>delete</em>, <em>minimum</em>, <em>maximum</em>,
 * <em>ceiling</em>, and <em>floor</em> methods take logarithmic time.
 * <p>
 * For additional documentation, see <a href="/algs4/45applications">Section
 * 4.5</a> of <i>Algorithms in Java, 4th Edition</i> by Robert Sedgewick and
 * Kevin Wayne.
 */

public class Menge<Key extends Comparable<Key>> implements SortedSet<Key>,
		Iterable<Key> {
	private TreeSet<Key> set;

	/**
	 * Create an empty set.
	 */
	public Menge() {
		set = new TreeSet<Key>();
	}

	/**
	 * Is this set empty?
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Add the key to this set.
	 * 
	 * @return
	 */
	public boolean add(Key key) {
		return set.add(key);
	}

	/**
	 * Does this set contain the given key?
	 */
	public boolean contains(Key key) {
		return set.contains(key);
	}


	/**
	 * Return the number of keys in this set.
	 */
	public int size() {
		return set.size();
	}

	/**
	 * Return an Iterator for this set.
	 */
	public Iterator<Key> iterator() {
		return set.iterator();
	}

	/**
	 * Return the key in this set with the maximum value.
	 */
	public Key last() {
		return set.last();
	}

	/**
	 * Return the key in this set with the minimum value.
	 */
	public Key first() {
		return set.first();
	}

	/**
	 * Return the smallest key in this set >= k.
	 */
	public Key ceiling(Key k) {
		return set.ceiling(k);
		
	}

	/**
	 * Return the largest key in this set <= k.
	 */
	public Key floor(Key k) {
		return set.floor(k);
	}

	/**
	 * Return the union of this set with that set.
	 */
	public Menge<Key> union(Menge<Key> that) {
		Menge<Key> c = new Menge<Key>();
		for (Key x : this) {
			c.add(x);
		}
		for (Key x : that) {
			c.add(x);
		}
		return c;
	}

	/**
	 * Return the intersection of this set with that set.
	 */
	public Menge<Key> intersects(Menge<Key> that) {
		Menge<Key> c = new Menge<Key>();
		if (this.size() < that.size()) {
			for (Key x : this) {
				if (that.contains(x))
					c.add(x);
			}
		} else {
			for (Key x : that) {
				if (this.contains(x))
					c.add(x);
			}
		}
		return c;
	}

	/**
	 * Does this SET equal that set.
	 */
	public boolean equals(Object y) {
		// a reference of our object?
		if (y == this) 	return true;
		// a null reference
		if (y == null)	return false;
		// is it our class?
		if (y.getClass() != this.getClass())
			return false;
		// cast to compare the content 
		Menge<?> that = (Menge<?>) y;
		// the same size
		if (this.size() != that.size())
			return false;
		try {
			// compare the content
			for (Key k : this)
				if (!that.contains(k))
					return false;
		} catch (ClassCastException exception) {
			return false;
		}
		return true;
	}

	/***********************************************************************
	 * Test routine.
	 **********************************************************************/
	public static void main(String[] args) {
		Menge<String> set = new Menge<String>();

		// insert some keys
		set.add("www.cs.princeton.edu");
		set.add("www.cs.princeton.edu"); // overwrite old value
		set.add("www.princeton.edu");
		set.add("www.math.princeton.edu");
		set.add("www.yale.edu");
		set.add("www.amazon.com");
		set.add("www.simpsons.com");
		set.add("www.stanford.edu");
		set.add("www.google.com");
		set.add("www.ibm.com");
		set.add("www.apple.com");
		set.add("www.slashdot.com");
		set.add("www.whitehouse.gov");
		set.add("www.espn.com");
		set.add("www.snopes.com");
		set.add("www.movies.com");
		set.add("www.cnn.com");
		set.add("www.iitb.ac.in");

		System.out.println(set.contains("www.cs.princeton.edu"));
		System.out.println(!set.contains("www.harvardsucks.com"));
		System.out.println(set.contains("www.simpsons.com"));
		System.out.println();

		System.out.println("ceil(www.simpsonr.com) = "
				+ set.ceiling("www.simpsonr.com"));
		System.out.println("ceil(www.simpsons.com) = "
				+ set.ceiling("www.simpsons.com"));
		System.out.println("ceil(www.simpsont.com) = "
				+ set.ceiling("www.simpsont.com"));
		System.out.println("floor(www.simpsonr.com) = "
				+ set.floor("www.simpsonr.com"));
		System.out.println("floor(www.simpsons.com) = "
				+ set.floor("www.simpsons.com"));
		System.out.println("floor(www.simpsont.com) = "
				+ set.floor("www.simpsont.com"));
		System.out.println();

		// print out all keys in the set in lexicographic order
		for (String s : set) {
			System.out.println(s);
		}

	}

	@Override
	public boolean addAll(Collection<? extends Key> c) {
		return set.addAll(c);
	}

	@Override
	public void clear() {
		set.clear();

	}

	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}

	@Override
	public Object[] toArray() {
		return set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}

	@Override
	public Comparator<? super Key> comparator() {
		return set.comparator();
	}

	@Override
	public SortedSet<Key> headSet(Key toElement) {
		return set.headSet(toElement);
	}

	@Override
	public SortedSet<Key> subSet(Key fromElement, Key toElement) {
		return set.subSet(fromElement, toElement);
	}

	@Override
	public SortedSet<Key> tailSet(Key fromElement) {
		return set.tailSet(fromElement);
	}

	@Override
	public boolean removeIf(Predicate<? super Key> filter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stream<Key> stream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Key> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(Consumer<? super Key> action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spliterator<Key> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
