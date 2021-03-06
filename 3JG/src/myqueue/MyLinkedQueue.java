package myqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Eine eigene LinkedQueue Klasse
 * @author gary
 * @param <E> generic
 */
public class MyLinkedQueue<E> implements MyQueue<E>, Iterable<E>{
	private class Cell{
		public E value;
		public Cell next;
		/**
		 * constructor with a new value
		 * @param element the new value
		 */
		public Cell(E element){
			this.value = element;
		}
	}
	private class MyIterator implements Iterator<E>{
		private Cell pointer;
		private boolean begin, removable;
		/**
		 * default constructor
		 */
		public MyIterator(){
			begin = true;
			removable = false;
		}
		/**
		 * @return if it has a next element
		 */
		public boolean hasNext(){
			if (front == null)
				return false;
			// if the next is not null
			return (begin || pointer.next != null);
			//return (begin ? front : pointer.next) != null;
		}
		/**
		 * 
		 * @return the value of the element it is pointing to
		 */
		public E next() throws NoSuchElementException{
			if(!hasNext()) throw new NoSuchElementException();
			if(begin){
				removable = !(begin = false);
				return (pointer = front).value;
			}
			removable = false;
			return (pointer = pointer.next).value;
		}
		/**
		 * remove the first element of the queue
		 */
		public void remove() throws IllegalStateException{
			if(removable){
				pointer = pointer.next;
				delete();
			}else
				throw new IllegalStateException();
		}
	}
	/**
	 * insert an element
	 * after == null means insert at the beginning
	 * 
	 * @param newValue
	 * @param after 
	 */
	void insert(E newValue,E after) {
		// stop without an useful new value
		if(newValue==null) return;
		// create a new Cell with the given value
		Cell newCell = new Cell(newValue);
		// if the collection is empty or 
		// we should insert at the very beginning
		if(front==null || after ==null) {
			// correct the references
			newCell.next=front;
			front = newCell;
			// we should increment the count attribute
			++count;
			// if this was the first element, create a reference to our new Cell 
			rear = rear==null ? newCell:rear;
			return;
		}
		// Otherwise go thru and start with front
		for(Cell c=front; c!=null; c=c.next) {
			// If we found the given value
			if(c.value.equals(after)) {
				// correct the references
				newCell.next = c.next;
				c.next = newCell;
				// and increment the count attribute
				++count;
				// if this was the last element
				if(newCell.next==null)
					// correct the reference for rear
					rear=newCell;
				break;
			}
		}

	}
	private Cell rear, front;
	int count;
	@Override
	public MyQueue<E> append(E element) {
		// size() <= 1 are special cases we have to consider
		if(size() == 0){
			front = rear = new Cell(element); // both pointing to the same element
		}else{
			rear.next = new Cell(element);
			rear = rear.next;
		}
		count++;
		return this;
	}

	@Override
	public E delete() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		E ret = (E)front.value;
		if(size() > 1)
			front = front.next; // the old element will be removed by the java garbage collector
		else
			front = rear = null;
		count--;
		return ret;
	}

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		return (E)front.value;
	}

	@Override
	public E peekLast() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		return (E)rear.value;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}
	
	@Override
	public String toString(){
		MyIterator it = (MyIterator) iterator();
		
		String res = "";
		while(it.hasNext())
			res += it.next().toString() + " ";
		return res;
	}
	
}
