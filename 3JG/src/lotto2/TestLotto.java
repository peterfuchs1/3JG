/**
 * 
 */
package lotto2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author uhs374h
 *
 */
public class TestLotto {
	private Lotto l1;
	private Set<Integer> rLottozahlen;
	private int rZusatz;
	private Class<?> c;

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
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		l1 = new Lotto();
		this.actualPrivateData();
	}
	@SuppressWarnings("unchecked")
	private void actualPrivateData() throws NoSuchFieldException, 
	SecurityException, IllegalArgumentException, IllegalAccessException{
		this.c = l1.getClass();
		// How to access private member fields of the class
		// getDeclaredField() returns the private field
		Field privateField = c.getDeclaredField("lottozahlen");
		// makes this private field instance accessible
		// for reflection use only, not normal code
		privateField.setAccessible(true);
//		String name = privateField.getName();
		// get the value of this private field

		this.rLottozahlen = (Set<Integer>) privateField.get(l1);
		privateField = c.getDeclaredField("zusatzzahl");
		privateField.setAccessible(true);
//		name = privateField.getName();
		this.rZusatz = (int) privateField.get(l1);
		
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		l1 = null;
	}

	/**
	 * Test method for {@link lotto2.Lotto#newTip()}.
	 */
	@Test
	public void testNewTip() {
		TreeSet<Integer> myTip = new TreeSet<>();
		Integer[] myValues = { 1, 2, 3, 4, 5, 6 };
		myTip.addAll(Arrays.asList(myValues));
		int before = l1.check(myTip);
		boolean beforeZusatz = l1.checkZusatz(myTip);
		l1.newTip();
		int after = l1.check(myTip);
		boolean afterZusatz = l1.checkZusatz(myTip);
		assertTrue(before != after || beforeZusatz != afterZusatz);

	}

	/**
	 * Test method for {@link lotto2.Lotto#autoTip()}.
	 */
	@Test
	public void testAutoTip() {
		Set<Integer> myTip = Lotto.autoTip();
		int expected = 6;
		int actual = myTip.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link lotto2.Lotto#check(java.util.Set)}.
	 */
	@Test
	public void testCheck() {
		TreeSet<Integer> myTip = new TreeSet<>();
		Integer[] myValues = { 1, 2, 3, 4, 5, 6 };
		myTip.addAll(Arrays.asList(myValues));
		Set<Integer> result= TestLotto.intersection(myTip, rLottozahlen); 
		int expected=result.size();
		int actual=l1.check(myTip);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link lotto2.Lotto#checkZusatz(java.util.Set)}.
	 */
	@Test
	public void testCheckZusatz() {
		TreeSet<Integer> myTip = new TreeSet<>();
		Integer[] myValues = { 1, 2, 3, 4, 5, 6 };
		myTip.addAll(Arrays.asList(myValues));
		TreeSet<Integer> zusatz=new TreeSet<>();
		zusatz.add(this.rZusatz);
		Set<Integer> result = TestLotto.intersection(myTip, zusatz);
		boolean expected = result.size()>0;
		boolean actual = l1.checkZusatz(myTip);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link lotto2.Lotto#toArray()}.
	 */
	@Test
	public void testToArray() {
		Integer[] result=rLottozahlen.toArray(new Integer[0]);
		int[] t=l1.toArray();
		Integer[] tested=new Integer[t.length];
		for (int i=0;i<t.length;i++)
			tested[i]=t[i];
		Set<Integer> setResult=new HashSet<>();
		setResult.addAll(Arrays.asList(result));
		Set<Integer> setTested=new HashSet<>();
		setTested.addAll(Arrays.asList(tested));
		assertTrue(setResult.containsAll(setTested));
	}

	/**
	 * Test method for {@link lotto2.Lotto#toString()}.
	 */
	@Test
	public void testToString() {
		String s=l1.toString();
		assertFalse(s==null);
	}


}
