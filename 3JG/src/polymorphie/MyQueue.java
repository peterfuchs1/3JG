package polymorphie;

import java.util.NoSuchElementException;

public interface MyQueue<T> {
	/**
	 * append an element at the end of the queue
	 * @param element
	 * @return the queue
	 */
	public MyQueue<T> append(T element);
	/**
	 * remove the first element
	 * @return the value
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T delete() throws NoSuchElementException;
	/**
	 * count the elements of the queue
	 * @return size
	 */
	public int size();
	/**
	 * is the queue empty?
	 * @return true or false
	 */
	public boolean isEmpty();
	/**
	 * show the value of the first element
	 * @return the value of the first element
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peek() throws NoSuchElementException;
	/**
	 * show the value of the last element
	 * @return the value of the last element
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peekLast() throws NoSuchElementException;
	
	public String toString();
}
