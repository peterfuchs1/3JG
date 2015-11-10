package myqueue;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class MyLinkedQueueTest {
	private static String[] VALUES={"erstes","zweites","drittes","viertes"};
	private MyLinkedQueue<String> mll;
	@Before
	public void setUp() throws Exception {
		mll=new MyLinkedQueue<>();
	}

	@After
	public void tearDown() throws Exception {
		mll=null;
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		assertTrue(mll.isEmpty());
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#isEmpty()}.
	 */
	@Test
	public final void testIsNotEmpty() {
		for(String s:VALUES)
			mll.append(s);
		assertFalse(mll.isEmpty());
	}
	
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#size()}.
	 */
	@Test
	public final void testSize() {
		for(String s:VALUES)
			mll.append(s);
		int expected=VALUES.length;
		int actual=mll.size();
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test
	public final void testIteratorHasNextBegin() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		boolean expected=true;
		boolean actual=it.hasNext();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test
	public final void testIteratorHasNextMiddle() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		boolean expected=true;
		int index=2;
		while(--index>=0) it.next();
		boolean actual=it.hasNext();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test
	public final void testIteratorHasNextEnd() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		boolean expected=false;
		int index=VALUES.length;
		while(--index>=0) it.next();
		boolean actual=it.hasNext();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test
	public final void testIteratorHasNextEndEmpty() {
		Iterator<String> it=mll.iterator();
		boolean expected=false;
		boolean actual=it.hasNext();
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test(expected=NoSuchElementException.class)
	public final void testIteratorNextEmpty() {
		Iterator<String> it=mll.iterator();
		it.next();
		fail("this is not possible");
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test(expected=NoSuchElementException.class)
	public final void testIteratorNextEOF() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		while(it.hasNext()) it.next();
		it.next();
		fail("this is not possible");
	}

	
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test(expected=IllegalStateException.class)
	public final void testIteratorRemoveEmpty() {
		Iterator<String> it=mll.iterator();
		it.hasNext();
		it.remove();
		fail("this is not possible");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test(expected=IllegalStateException.class)
	public final void testIteratorRemoveWithoutHasNext() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		it.remove();
		fail("this is not possible");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(java.lang.Object)}.
	 */
	@Test
	public final void testAddE() {
		mll.append(VALUES[2]);
		int expected=1;
		int actual=mll.size();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveFirst() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		it.hasNext();
		it.next();
		it.remove();
		int expected=VALUES.length-1;
		int actual=mll.size();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test(expected=IllegalStateException.class)
	public final void testRemoveTwoTimes() {
		
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		it.hasNext();
		it.remove();
		it.remove();
		fail("remove() two times without next()");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test(expected=IllegalStateException.class)
	public final void testRemoveEmpty() {
		Iterator<String> it=mll.iterator();
		it.hasNext();
		it.remove();
		fail("remove() without next()");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#clear()}.
	 */
	@Test
	public final void testClearEmpty() {
		Iterator<String> it=mll.iterator();
		boolean expected=false;
		boolean actual=it.hasNext();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#clear()}.
	 */
	@Test
	public final void testClearFull() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		while (it.hasNext()){
			it.next();
			it.remove();
		}
		
		int expected=0;
		int actual=mll.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test
	public final void testGetEnd() {
		for(String s:VALUES)
			mll.append(s);
		int index=VALUES.length-1;
		String expected=VALUES[index];
		String actual=mll.peekLast();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test
	public final void testGetStart() {
		for(String s:VALUES)
			mll.append(s);
		int index=0;
		String expected=VALUES[index];
		String actual=mll.peek();
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntStart() {
		String expected="neues";
			mll.append(expected);
			String actual=mll.peek();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntAfterEnd() {
		for(String s:VALUES)
			mll.append(s);
		int index=VALUES.length;
		String expected="neues";
		mll.append(expected);
		String actual=mll.peekLast();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(int)}.
	 */
	@Test
	public final void testRemoveIntStart() {
		for(String s:VALUES)
			mll.append(s);
		int expected=mll.size()-1;
		mll.delete();
		int actual=mll.size();
		assertEquals(expected, actual);
	}
	
	@Test(expected=NoSuchElementException.class)
	public final void testPeekEmpty() {
		String actual=mll.peek();
		fail("no element available!");
	}
	

	@Test(expected=NoSuchElementException.class)
	public final void testPeekLastEmpty() {
		String actual=mll.peekLast();
		fail("no element available!");
	}
	

	@Test
	public final void testPeek() {
		for(String s:VALUES)
			mll.append(s);
		String expected=VALUES[0];
		String actual=mll.peek();
		assertEquals(expected, actual);
	}

	@Test
	public final void testPeekLast() {
		for(String s:VALUES)
			mll.append(s);
		String expected=VALUES[VALUES.length-1];
		String actual=mll.peekLast();
		assertEquals(expected, actual);
	}

	@Test
	public final void testDelete() {
		for(String s:VALUES)
			mll.append(s);
		mll.delete();
		String expected=VALUES[1];
		String actual=mll.peek();
		assertEquals(expected, actual);

	}

	@Test(expected=IllegalStateException.class)
	public final void testRemoveMiddle() {
		for(String s:VALUES)
			mll.append(s);
		Iterator<String> it=mll.iterator();
		it.next();
		it.next();
		it.remove();
		fail("remove() is only permitted on top of the queue");

	}
	
	@Test
	public final void testDeleteJustOne() {
		mll.append("neues");
		mll.delete();
		assertTrue(mll.isEmpty());

	}
	@Test(expected=NoSuchElementException.class)
	public final void testDeleteEmpty() {
		mll.delete();
		fail("remove() without any element!");
	}
	

	@Test
	public final void testIterator() {
		Iterator<String> actual=mll.iterator();
		assertNotNull(actual);
	}

	@Test
	public final void testToString() {
		for(String s:VALUES)
			mll.append(s);
		int actual=mll.toString().length();
		assertTrue(actual>0);
	}

}
