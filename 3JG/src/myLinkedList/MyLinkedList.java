/**
 * 
 */
package myLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Walter Rafeiner-Magor
 * 
 */
public class MyLinkedList<E> implements MyList<E>, Iterable<E> {
	/**
	 * the representation of a node
	 * 
	 * @author Walter Rafeiner-Magor
	 * 
	 */
	private class Node {
		private E value; // the value
		private Node next; // pointer to the next Cell

		/**
		 * Constructor with a new element
		 * 
		 * @param element
		 */
		public Node(E element) {
			value = element;
		}
	}

	private Node front, rear; // the first and the last element
	private int count; // count the elements

	@Override
	public boolean isEmpty() {
		return (front == null);
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean contains(Object o) {
		for (Node pointer = front; pointer != null; pointer = pointer.next) {
			if (pointer.value == null) {
				if (o == null)
					return true;
			} else if (pointer.value.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {

		return new MyIterator();
	}

	@Override
	public boolean add(E element) {
		Node c = new Node(element);
		if (front == null)
			front = c;
		else
			rear.next = c;
		rear = c;
		count++;
		return true;
	}

	@Override
	public boolean remove(E o) {
		if (count == 0)
			return false;
		Node pointer = front;
		Node previous = null;
		boolean ret = false;
		for (; pointer != null; previous = pointer, pointer = pointer.next) {
			if (pointer.value == null) {
				if (o == null) {
					ret = true;
					break;
				}
			} else if (pointer.value.equals(o)) {
				ret = true;
				break;
			}
		}
		if (!ret)
			return false;
		// we are at the beginning?
		if (previous == null) {
			front = front.next;
			pointer = front;
		}
		// the current element can be removed
		else {
			previous.next = pointer.next;
			// jump to the next element
			pointer = pointer.next;
		}
		// Are we at the end
		if (pointer == null)
			rear = previous;
		count--;
		return true;
	}

	@Override
	public void clear() {

		Node pointer = front;
		Node previous = null;
		front = null;
		rear = null;
		count = 0;
		while (pointer != null) {
			pointer.value = null;
			previous = pointer;
			pointer = pointer.next;
			previous.next = null;
		}

	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException("index " + index
					+ "not available");
		Node pointer = front;
		while (--index >= 0)
			pointer = pointer.next;
		return pointer.value;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException();
		Node pointer = front;
		while (--index >= 0)
			pointer = pointer.next;
		E prevValue = pointer.value;
		pointer.value = element;
		return prevValue;
	}

	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > count)
			throw new IndexOutOfBoundsException();
		Node newElement = new Node(element);
		count++;
		if (index == 0) {
			newElement.next = front;
			front = newElement;
		} else {
			Node previous = null;
			Node pointer = front;
			while (--index >= 0) {
				previous = pointer;
				pointer = pointer.next;
			}
			previous.next = newElement;
			newElement.next = pointer;
			// was it an append?
			if (newElement.next == null)
				rear = newElement;
		}

	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException();
		count--;
		E prevValue=null;
		Node pointer = front;
		if (index == 0) {
			prevValue=front.value;
			front=front.next;
			pointer=front;
		} else {
			Node previous = null;
			
			while (--index >= 0) {
				previous = pointer;
				pointer = pointer.next;
			}
			prevValue=pointer.value;
			previous.next =  pointer.next;
			pointer=previous.next;
		}
		if(pointer==null)
			rear=null;

		return prevValue;
	}

	private class MyIterator implements Iterator<E> {
		private Node pointer; // where are we
		private boolean begin; // are we at the top
		private boolean removable; // the remove a element a next() has been
									// done before.
		private Node previous;	// the last Node

		/**
		 * Constructor
		 */
		public MyIterator() {
			begin = true; // we are at the top
			previous = null;
			pointer = front; //
			removable = false; // we are not allowed to remove this element
		}

		@Override
		public boolean hasNext() {
			if (front == null)
				return false;
			// if the next is not null
			return (begin || pointer.next != null);
		}

		@Override
		public E next() throws NoSuchElementException {
			// if its empty
			if (count == 0)
				throw new NoSuchElementException();
			// if we are at the top
			if (begin) {
				begin = false;
			} else {
				// if the next is null
				if (pointer.next == null)
					throw new NoSuchElementException();
				else {
					// go forward
					previous = pointer;
					pointer = pointer.next;
				}
			}
			// we are allowed to remove this element!
			removable = true;
			// return the value
			return pointer.value;
		}

		@Override
		public void remove() throws IllegalStateException {
			// we can remove after a next()
			if (!removable)
				throw new IllegalStateException();
			// Are we at the beginning?
			if (previous == null) {
				begin=true;
				front = front.next;
				pointer = front;
			}
			// the current element can be removed
			else {
				previous.next = pointer.next;
				// jump to the next element
				pointer = pointer.next;
			}
			// Are we at the end
			if (pointer == null)
				rear = previous;
			count--;

			// only one deletion is allowed
			removable = false;
		}
	}

}
