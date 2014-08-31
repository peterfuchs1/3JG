/**
 * 
 */
package stack2;

import java.util.EmptyStackException;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface MyStackable<E> {
	/**
	 * Tests if this stack is empty.
	 * @return
	 */
	public boolean 	isEmpty();
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return
	 */
	public E peek();
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @throws EmptyStackException 
	 * @return
	 */
	public E pop() throws EmptyStackException;
	/**
	 * Pushes an item onto the top of this stack. 
	 * @param item
	 * @return item
	 */
	public E push(E item);
	/**
	 * Returns the 1-based position where an object is on this stack.
	 * @param o
	 * @return
	 */
	public int search(Object o);
	/**
	 * Counts the appearance of an object on this stack.
	 * @param o
	 * @return
	 */
	public <T extends Comparable<E>> E sortedStack();
	
	/**
	 * Returns the number of components
	 * @return
	 */
	public int size();
	/**
	 * Returns an array containing all of the elements in the correct order; 
	 * the runtime type of the returned array is that of the specified array.
	 * @param a
	 * @return
	 * @throws NullPointerException
	 * @throws ArrayStoreException
	 */
	public <T> T[] toArray(T[] a) throws NullPointerException, ArrayStoreException;
	/**
	 * 
	 * @return
	 */
	public Object toArray();
	/**
	 * Returns a deep copy of the stack
	 * @return new stack
	 */
	public MyStack<E> copy();
	
}
