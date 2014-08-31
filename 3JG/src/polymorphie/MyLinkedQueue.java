/**
 * 
 */
package polymorphie;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

import myLinkedList.MyLinkedList;

/**
 * @author Walter Rafeiner-Magor
 * @version 2.0
 * @param <E>
 * 
 */
public class MyLinkedQueue<E> implements MyQueue<E>, Iterable<E> {
	/**
	 * the representation of a node
	 * @author Walter Rafeiner-Magor
	 *
	 */
	private class Cell {
		private E value;	// the value
		private Cell next;	// pointer to the next Cell
		/**
		 * Constructor with a new element
		 * @param element
		 */
		public Cell(E element) {value = element;}
	}

	private Cell front, rear;	// the first and the last element
	private int count;			// count the elements

	@Override
	public boolean isEmpty() {
		return (front == null);
	}

	@Override
	public E peek() {
		if (front == null)
			throw new NoSuchElementException();
		return front.value;
	}
	@Override
	public E peekLast() {
		if (rear == null)
			throw new NoSuchElementException();
		return rear.value;
	}
	@Override
	public MyQueue<E> append(E element) {
		Cell c = new Cell(element);
		if (front == null)
			front = c;
		else
			rear.next = c;
		rear = c;
		count++;
		return this;
	}

	@Override
	public E delete() throws NoSuchElementException {
		if(count==0) throw new NoSuchElementException();
		E ret = null;
		if (front != null) {
			ret = front.value;
			front = front.next;
		}
		if(--count==0)
			rear=null;
		return ret;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterator<E> iterator() {
		// create a new iterator
		return new MyIterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E item : this)
			sb.append(item + " ");
		return sb.toString();
	}

	private class MyIterator implements Iterator<E> {
		private Cell pointer;	// where are we
		private boolean begin;	// are we at the top
		private boolean removable;	// the remove a element a next() has been done before.

		/**
		 * Constructor
		 */
		public MyIterator() {
			begin = true;		// we are at the top
			pointer = front;	// 
			removable = false;	// we are not allowed to remove this element
		}

		@Override
		public boolean hasNext() {
			if (front==null) return false;
			// if the next is not null 
			return (!begin && pointer.next == null)?false:true;
		}

		@Override
		public E next() throws NoSuchElementException  {
			// if its empty 
			if (isEmpty())
				throw new NoSuchElementException();
			// if we are at the top
			if (begin) {
				begin = false;
			} else {
				// if the next is null
				if (pointer.next == null)
					throw new NoSuchElementException();
				else
					// go forward
					pointer = pointer.next;
			}
			// we are allowed to remove this element!
			removable = true;
			// return the value
			return pointer.value;
		}

		@Override
		public void remove() throws IllegalStateException{
			// we can remove after a next()
			// it must be the top of the queue
			if (!removable || pointer !=front)
				throw new IllegalStateException();
			// only the first element can be removed
			delete();
			// we are at the beginning again
			begin = true;
			pointer = front;
			// only one deletion is allowed
			removable = false;
		}

		@Override
		public void forEachRemaining(Consumer<? super E> action) {
			// TODO Auto-generated method stub
			
		}

	}
	public static void main(String[] a){
		String[] VALUES={"erstes","zweites","drittes","viertes"};
		MyLinkedQueue<String> mll=new MyLinkedQueue<String>();
		for(String s:VALUES)
			mll.append(s);
		for(String s:VALUES)
			mll.delete();
		int expected=0;
		int actual=mll.size();
	}

	@Override
	public void forEach(Consumer<? super E> action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spliterator<E> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
