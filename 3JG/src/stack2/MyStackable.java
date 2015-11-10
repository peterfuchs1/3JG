/**
 * 
 */
package stack2;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface MyStackable<E> extends Comparator<E> {

	/**
	 * Tests if this stack is empty.
	 * @return
	 */
	public boolean 	isEmpty();
	/**
	 * Looks at the object at the top of this stack without removing it 
	 * from the stack.
	 * @return item
	 */
	public E peek();
	/**
	 * Removes the object at the top of this stack and 
	 *  returns that object.
	 * @throws EmptyStackException 
	 * @return item 
	 */
	public E pop() throws EmptyStackException;
	/**
	 * Pushes an item onto the top of this stack.
	 * @throws NullPointerException, if item is null 
	 * @param item
	 */
	public void push(E item) throws NullPointerException;
	/**
	 * Returns the availability of o on the stack
	 * @param o
	 * @return true: if 'o' is available - or false if not
	 */
	public boolean contains(Object o);
	/**
	 * Returns the 1-based position where the object is on this stack.
	 * @param o object to be searched
	 * @return the position within the stack
	 * 	0: if the the stack does not contain the given object
	 */
	public int search(Object o);
	/**
	 * Returns a sorted List of this stack. The order is defined by implementing
	 * the interface Comparable<E> (with the method 'int ompareTo(E item)') 
	 * @return a List
	 */
	public List<E> sortedList();
	/**
	 * Returns a List of this stack in the order it was filled.
	 * @return a List
	 */
	public List<E> toList();
	
	/**
	 * Returns the number of elements in the stack
	 * @return 
	 */
	public int size();
	/**
	 * Returns an array containing all the elements in the correct order
	 * the stack was filled! 
	 * the runtime type of the returned array is that of the specified array.
	 * @param a is an array of the runtime type
	 * @return  is an array of type 'a'
	 * @throws NullPointerException - if 'a' is null
	 * @throws ArrayStoreException - if the runtime type of the specified array 
	 * 	is not a supertype of the runtime type of every element in this stack
	 */
	public <T> T[] toArray(T[] a) throws NullPointerException, ArrayStoreException;
	/**
	 * 
	 * @return
	 */
	public Object[] toArray();
	/**
	 * Returns an array containing all the elements in the correct order
	 * the stack was filled! 
	 * the runtime type of the returned array is that of the specified array.
	 * @return an array of Object
	 */
	public MyStack<? extends Comparable<E>> copy();
	/**
	 * Test a given object with our Mystack object
	 * 
	 * @param obj
	 * @return 
	 * 		true: if it is the same object (reference)
	 * 		true: if all elements are the same and saved in the same order
	 * 		false: in all other cases
	 */
	public boolean equals(Object obj);
}
