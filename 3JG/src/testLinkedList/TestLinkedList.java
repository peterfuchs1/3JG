/**
 * 
 */
package testLinkedList;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import myLinkedList.MyLinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestLinkedList {
	private static String[] VALUES={"erstes","zweites","drittes","viertes"};
	private MyLinkedList<String> mll;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mll=new MyLinkedList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
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
			mll.add(s);
		for(String s:VALUES)
			mll.remove(s);
		assertTrue(mll.isEmpty());
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#isEmpty()}.
	 */
	@Test
	public final void testIsNotEmpty() {
		for(String s:VALUES)
			mll.add(s);
		assertFalse(mll.isEmpty());
	}
	
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#size()}.
	 */
	@Test
	public final void testSize() {
		for(String s:VALUES)
			mll.add(s);
		for(String s:VALUES)
			mll.remove(s);
		int expected=0;
		int actual=mll.size();
		assertEquals(expected, actual);

	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public final void testContainsNull() {
		for(String s:VALUES)
			mll.add(s);
		mll.add((String)null);
		boolean expected=true;
		boolean actual=mll.contains(null);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public final void testContainsNotNull() {
		for(String s:VALUES)
			mll.add(s);
		boolean expected=false;
		boolean actual=mll.contains(null);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public final void testContainsNotNull2() {
		mll.add(null);
		for(String s:VALUES)
			mll.add(s);
		boolean expected=true;
		boolean actual=mll.contains(VALUES[2]);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public final void testContains() {
		for(String s:VALUES)
			mll.add(s);
		boolean expected=true;
		boolean actual=mll.contains(VALUES[1]);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public final void testContainsNot() {
		for(String s:VALUES)
			mll.add(s);
		boolean expected=false;
		boolean actual=mll.contains(VALUES[1]+"!");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test
	public final void testIteratorHasNextBegin() {
		for(String s:VALUES)
			mll.add(s);
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
			mll.add(s);
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
			mll.add(s);
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
			mll.add(s);
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
		it.remove();
		fail("this is not possible");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test(expected=IllegalStateException.class)
	public final void testIteratorRemoveWithoutHasNext() {
		for(String s:VALUES)
			mll.add(s);
		Iterator<String> it=mll.iterator();
		it.remove();
		fail("this is not possible");
	}
	
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test(expected=IllegalStateException.class)
	public final void testIteratorRemove2Times() {
		for(String s:VALUES)
			mll.add(s);
		Iterator<String> it=mll.iterator();
		while(it.hasNext()) it.next();
		it.remove();
		it.remove();
		fail("this is not possible");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#iterator()}.
	 */
	@Test
	public final void testIteratorRemoveFirst() {
		for(String s:VALUES)
			mll.add(s);
		Iterator<String> it=mll.iterator();
		it.next();
		it.remove();
		assertFalse(mll.contains(VALUES[0]));
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(java.lang.Object)}.
	 */
	@Test
	public final void testAddE() {
		mll.add(VALUES[2]);
		int expected=1;
		int actual=mll.size();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveNull() {
		for(String s:VALUES)
			mll.add(s);
		mll.add((String)null);
		boolean expected=true;
		boolean actual=mll.remove(null);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveStart() {
		for(String s:VALUES)
			mll.add(s);
			mll.remove(VALUES[0]);
		boolean expected=false;
		boolean actual=mll.contains(VALUES[0]);
		assertEquals(expected, actual);
	}	
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveEnd() {
		for(String s:VALUES)
			mll.add(s);
		for(int i=VALUES.length-1;i>=0;i--){
			mll.remove(VALUES[i]);
		}
		mll.add(VALUES[2]);
		int expected=1;
		int actual=mll.size();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveMiddle() {
		mll.add(null);
		for(String s:VALUES)
			mll.add(s);
		for(int i=VALUES.length-2;i>0;i--){
			mll.remove(VALUES[i]);
		}
		int expected=3;
		int actual=mll.size();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveEmpty() {
		boolean expected=false;
		boolean actual=mll.remove(VALUES[0]);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public final void testRemoveNotFound() {
		for(String s:VALUES)
			mll.add(s);		
		boolean expected=false;
		boolean actual=mll.remove(VALUES[0]+"!");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#clear()}.
	 */
	@Test
	public final void testClearEmpty() {
		mll.clear();
		int expected=0;
		int actual=mll.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#clear()}.
	 */
	@Test
	public final void testClearFull() {
		for(String s:VALUES)
			mll.add(s);		
		mll.clear();
		int expected=0;
		int actual=mll.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testGetIOBE1() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length;
		mll.get(index);
		fail("this is not possible");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testGetIOBE2() {
		for(String s:VALUES)
			mll.add(s);
		int index=-1;
		mll.get(index);
		fail("this is not possible");
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test
	public final void testGetEnd() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length-1;
		String expected=VALUES[index];
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test
	public final void testGetStart() {
		for(String s:VALUES)
			mll.add(s);
		int index=0;
		String expected=VALUES[index];
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#get(int)}.
	 */
	@Test
	public final void testGetMiddle() {
		for(String s:VALUES)
			mll.add(s);
		int index=2;
		String expected=VALUES[index];
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testSetIOBE1() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length;
		String expected="neues";
		mll.set(index, expected);
		fail("this is not possible");
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testSetIOBE2() {
		for(String s:VALUES)
			mll.add(s);
		int index=-1;
		String expected="neues";
		mll.set(index, expected);
		fail("this is not possible");
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public final void testSetStart() {
		for(String s:VALUES)
			mll.add(s);
		int index=0;
		String expected="neues";
		mll.set(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);

	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public final void testSetEnd() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length-1;
		String expected="neues";
		mll.set(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);

	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public final void testSetMiddle() {
		for(String s:VALUES)
			mll.add(s);
		int index=2;
		String expected="neues";
		mll.set(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testAddIntIOBE1() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length+1;
		String expected="neues";
		mll.add(index, expected);
		fail("this is not possible!");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testAddIntIOBE2() {
		for(String s:VALUES)
			mll.add(s);
		int index=-1;
		String expected="neues";
		mll.add(index, expected);
		fail("this is not possible!");
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntMiddle() {
		for(String s:VALUES)
			mll.add(s);
		int index=2;
		String expected="neues";
		mll.add(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntStart() {
		for(String s:VALUES)
			mll.add(s);
		int index=0;
		String expected="neues";
		mll.add(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntEnd() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length-1;
		String expected="neues";
		mll.add(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntAfterEnd() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length;
		String expected="neues";
		mll.add(index, expected);
		String actual=mll.get(index);
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(int)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testRemoveIntIOBE1() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length;
		mll.remove(index);
		fail("this is not possible");
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(int)}.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testRemoveIntIOBE2() {
		for(String s:VALUES)
			mll.add(s);
		int index=-1;
		mll.remove(index);
		fail("this is not possible");
	}

	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(int)}.
	 */
	@Test
	public final void testRemoveIntEnd() {
		for(String s:VALUES)
			mll.add(s);
		int index=VALUES.length-1;
		String expected=VALUES[index];
		mll.remove(index);
		assertFalse(mll.contains(expected));
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(int)}.
	 */
	@Test
	public final void testRemoveIntStart() {
		for(String s:VALUES)
			mll.add(s);
		int index=0;
		String expected=VALUES[index];
		mll.remove(index);
		assertFalse(mll.contains(expected));
	}
	/**
	 * Test method for {@link myLinkedList.MyLinkedList#remove(int)}.
	 */
	@Test
	public final void testRemoveIntMiddle() {
		for(String s:VALUES)
			mll.add(s);
		int index=2;
		String expected=VALUES[index];
		mll.remove(index);
		assertFalse(mll.contains(expected));
	}

}
