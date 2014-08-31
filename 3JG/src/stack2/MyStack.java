package stack2;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<E> implements MyStackable<E>{

	private ArrayDeque<E> stack;
	
	/**
	 * @param stack
	 */
	public MyStack(int initialCapacity) {
		stack=new ArrayDeque<>(initialCapacity);
	}
	public MyStack(){
		this(50);
	}
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public E peek() {
		return stack.peek();
	}

	@Override
	public E pop() throws EmptyStackException {
		if(stack.isEmpty()) throw new EmptyStackException();
		return stack.pop();
	}

	@Override
	public E push(E item) {
		stack.push(item);
		return item;
	}

	@Override
	public int search(Object o) {
		int ret=0;
		if(!stack.contains(o)) return 0;
		Iterator<E> it=stack.iterator();
		while(it.hasNext()){
			ret++;
			if(it.next().equals(o)) break;
		}
		return ret;
	}



	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public <T> T[] toArray(T[] a) throws NullPointerException,
			ArrayStoreException {
		return stack.toArray(a);
	}
	@Override
	public Object toArray()  {
		return stack.toArray();
	}
	@Override
	public <T extends Comparable<E>> E sortedStack() {
		return null;
	}
	@Override
	public MyStack<E> copy() {
		MyStack<E> newStack=new MyStack<>(stack.size());
		Iterator<E> iter=stack.iterator();
		while(iter.hasNext())
			newStack.push(( iter.next()));
		return newStack;
	}


}
