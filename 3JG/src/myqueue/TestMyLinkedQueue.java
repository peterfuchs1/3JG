/**
 * 
 */
package myqueue;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author gary
 * the class to test the MyLinkedQueue
 * using Integer as the type of our elements
 */
public class TestMyLinkedQueue {
	private MyLinkedQueue<Integer> q;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		q = new MyLinkedQueue<Integer>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		q = null;
	}

	/**
	 * Test method for {@link ye.MyLinkedQueue#append(java.lang.Object)}.
	 */
	@Test
	public void testAppend() {
		q.append(5);
		assertEquals(5, (int)q.delete());
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#append(java.lang.Object)}.
	 */
	@Test
	public void testAppendTwice() {
		q.append(5);
		q.append(42);
		assertEquals(5, (int)q.delete());
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#append(java.lang.Object)}.
	 */
	@Test
	public void testAppend3() {
		q.append(5);
		q.append(42);
		q.append(69);
		assertEquals(5, (int)q.delete());
	}
	
	/**
	 * Test method for {@link ye.MyLinkedQueue#append(java.lang.Object)}.
	 */
	@Test
	public void testAppend4(){
		q.append(5);
		q.append(42);
		q.append(69);
		q.delete();
		q.append(5);
		assertEquals(42, (int)q.delete());
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#delete()}.
	 */
	@Test
	public void testDelete() {
		q.append(100);
		assertEquals(100, (int)q.delete());
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#delete()}.
	 */
	@Test(expected=NoSuchElementException.class)
	public void testDeleteEmpty() {
		q.delete();
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#size()}.
	 */
	@Test
	public void testSize() {
		int n = 1000;
		for(int i = 0; i < n; i++)
			q.append((int)(Math.random()*10000));
		assertEquals(n,  q.size());
	}

	/**
	 * Test method for {@link ye.MyLinkedQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assert(q.isEmpty());
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmptyIfItIsNot() {
		q.append(42);
		assert(q.isEmpty() == false);
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty2() {
		int n = 1000;
		for(int i = 0; i < n; i++)
			q.append((int)(Math.random()*10000));
		for(int i = 0; i < n; i++)
			q.delete();
		assert(q.isEmpty());
	}
	/**
	 * Test method for {@link ye.MyLinkedQueue#peek()}.
	 */
	@Test
	public void testPeek() {
		q.append(10);
		assertEquals(10, (int)q.peek());
	}

	/**
	 * Test method for {@link ye.MyLinkedQueue#peekLast()}.
	 */
	@Test
	public void testPeekLast() {
		int last = 0, n = (1 << 16);
		for(int i = 0; i < n; i++)
			q.append(last = (int)(Math.random()*10000));
		assertEquals(last, (int)q.peekLast());
	}

	/**
	 * Test method for {@link ye.MyLinkedQueue#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<Integer> it = q.iterator();
		int[] arr = new int[]{3, 1, 5, 9, 3, 10};
		for(int i = 0; i < arr.length; i++)
			q.append(arr[i]);
		int[] res = new int[arr.length];
		int i = 0;
		while(it.hasNext())
			res[i++] = (int)it.next();
		assertArrayEquals(arr, res);
	}

	/**
	 * Test method for {@link ye.MyLinkedQueue#toString()}.
	 */
	@Test
	public void testToString() {
		q.append(50);
		q.append(100);
		assertEquals("50 100 ", q.toString());
	}
	@Test
	public void testInsert() {
		Integer i=120, i2=42;
		q.append(5);
		q.append(i2);
		q.append(69);

		q.insert(i, i2);
		assertEquals("5 42 120 69 ", q.toString());
	}
	@Test
	public void testInsertLast() {
		Integer i=120, i2=42;
		q.append(5);
		q.append(69);
		q.append(i2);

		q.insert(i, i2);
		assertEquals("5 69 42 120 ", q.toString());
		assertTrue(q.size()== 4);
	}
	@Test
	public void testInsertEmpty() {
		Integer i=120;

		q.insert(i, null);
		assertEquals("120 ", q.toString());
		assertTrue(q.size()==1);

	}	
	@Test
	public void testInsertBegin() {
		Integer i=120;
		q.append(5);
		q.append(69);
		q.append(42);

		q.insert(i, null);
		assertEquals("120 5 69 42 ", q.toString());
		assertTrue(q.size()==4);
	}
}
