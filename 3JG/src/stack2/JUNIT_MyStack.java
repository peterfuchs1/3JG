/**
 * 
 */
package stack2;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class JUNIT_MyStack {
	private MyStack<Integer> stack;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack=new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		stack=null;
	}

	/**
	 * Test method for {@link stack.MyStack#MyStack(int)}.
	 */
	@Test
	public final void testMyStackInt() {
		stack=new MyStack<>(10);
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(i);
		int expected=10;
		int actual=stack.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link stack.MyStack#MyStack()}.
	 */
	@Test
	public final void testMyStack() {
		stack=new MyStack<>();
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(i);
		int expected=10;
		int actual=stack.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link stack.MyStack#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		int input=1;
		stack.push(input);
		stack.pop();
		boolean expected=true;
		boolean actual=stack.isEmpty();
		assertEquals(expected, actual);
	}
	/**
	 * Test method for {@link stack.MyStack#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty2() {
		int input=1;
		stack.push(input);
		
		boolean expected=false;
		boolean actual=stack.isEmpty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link stack.MyStack#peek()}.
	 */
	@Test
	public final void testPeek() {
		int input=1;
		stack.push(input);
		int expected=input;
		int actual=stack.peek();
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link stack.MyStack#pop()}.
	 */
	@Test
	public final void testPop() {
		int input=1;
		stack.push(input);
		int expected=input;
		int actual=stack.pop();
		assertEquals(expected,actual);

	}

	/**
	 * Test method for {@link stack.MyStack#pop()}.
	 */
	@Test(expected=EmptyStackException.class)
	public final void testPop2() {
		int input=1;
		stack.push(input);
		stack.pop();
		stack.pop();
		fail("EmptyStackException!");

	}

	/**
	 * Test method for {@link stack.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public final void testPush() {
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(input[i]);
		int expected=input[input.length-1];
		int actual=stack.peek();
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link stack.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public final void testSearch() {
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(input[i]);
		int expected=2;
		int actual=stack.search(9);
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link stack.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public final void testSearch2() {
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(i);
		int expected=0;
		int actual=stack.search(11);
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link stack.MyStack#countAppearance(java.lang.Object)}.
	 */
	@Test
	public final void testCountAppearance() {
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10,2,3,2,2};
		for(int i=0;i<input.length;i++)
			stack.push(input[i]);
		MyStack<Integer> expected=stack;
		MyStack<Integer> actual=stack.copy();
		assertTrue(expected.equals(actual));
	}

	/**
	 * Test method for {@link stack.MyStack#size()}.
	 */
	@Test
	public final void testSize() {
		int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(input[i]);
		int expected=input.length;
		int actual=stack.size();
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link stack.MyStack#toArray(T[])}.
	 */
	@Test
	public final void testToArray() {
		Integer[] input=new Integer[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(i);
		Integer[] expected=input;
		Integer[]actual=stack.toArray(input);
		assertTrue(expected.equals(actual));
	}


	/**
	 * Test method for {@link stack.MyStack#toArray(T[])}.
	 */
	@Test(expected=NullPointerException.class)
	public final void testToArray2() {
		Integer[] input=new Integer[]{1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<input.length;i++)
			stack.push(i);
		Integer output[]=null;
		stack.toArray(output);
		fail("NullPOinterException");
	}
}
