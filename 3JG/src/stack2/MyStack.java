package stack2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyStack<E extends Comparable<E>> implements MyStackable<E>, Comparator<E>{

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
	/**
	 * @see MyStackable#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	/**
	 * @see MyStackable#peek()
	 */
	@Override
	public E peek() {
		return stack.peek();
	}
	/**
	 * @see MyStackable#pop()
	 */
	@Override
	public E pop() throws EmptyStackException {
		if(stack.isEmpty()) throw new EmptyStackException();
		return stack.pop();
	}
	/**
	 * @see MyStackable#push(Object)
	 */
	@Override
	public void push(E item) throws NullPointerException {
		if (item==null) throw new NullPointerException();
		stack.push(item);
	}
	/**
	 * @see MyStackable#search(Object)
	 */
	@Override
	public int search(Object o) {
		int ret=0;
		if(!stack.contains(o)) return 0;
		Iterator<E> it=stack.descendingIterator();
		while(it.hasNext()){
			ret++;
			if(it.next().equals(o)) break;
		}
		return ret;
	}

	/**
	 * @see MyStackable#size()
	 */
	@Override
	public int size() {
		return stack.size();
	}
	/**
	 * @see MyStackable#toArray(Object[])
	 */
	@Override
	public <T> T[] toArray(T[] a) throws NullPointerException,
			ArrayStoreException {
		///////////////////////////
		// Solution with two arrays
		// reversing from in to out
		///////////////////////////
//		T[] in=stack.toArray(a);
//		T[] out=stack.toArray(a);
//		for (int i=0,j=in.length-1;i<in.length;++i,--j){
//			out[i]=in[j];
//		}
//		return out;
		/////////////////////////////////////////////
		// Soultion with Collections.reverse(List<T))
		// converting into List and back into Array
		/////////////////////////////////////////////
		List<T> l=Arrays.asList(stack.toArray(a));
		Collections.reverse(l);
		return l.toArray(a);

	}
	/**
	 * @see MyStackable#toArray()
	 */
	@Override
	public Object[] toArray()  {
		//return stack.toArray();
		
		Object[] newStack=new Object[stack.size()];
		Iterator<E> iter = stack.descendingIterator();
		int i=0;
		while(iter.hasNext())
			newStack[i++]=iter.next();
		return newStack;
	
	}
	/**
	 * @see MyStackable#sortedList()
	 */
	@Override
	public List<E> sortedList() {
		List<E> ll= this.toList();
		Collections.sort(ll);
		return ll;
	}
	@Override
	public List<E> toList() {
		if (stack.isEmpty()) return null;
		LinkedList<E> ll= new LinkedList<E>();
		ll.addAll(stack);
		return ll;
	}
	/**
	 * @see MyStackable#copy()
	 */
	@Override
	public MyStack<E> copy() {
		MyStack<E> newStack=new MyStack<>(stack.size());
		Iterator<E> iter = stack.descendingIterator();
		while(iter.hasNext())
			newStack.push(iter.next());
		return newStack;
	}
	@SuppressWarnings("unused")
	private ArrayDeque<E> getStack(){
		return stack;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) return true;
		if ( !(obj instanceof MyStack<?>) ) return false;
		////////////////////////////////////////////
		// ArrayDeque does not override equals !!!
		// so it is only inherited from Object!
		// There is no possibility to do it without warning
		////////////////////////////////////////////
		// return ((MyStack<?>) obj).getStack().equals(this.stack);
		////////////////////////////////////////////
		
		@SuppressWarnings("unchecked")
		MyStack<E> other = (MyStack<E>) obj;
		if (this.size()!=other.size()) return false;
		List<E> o_l= other.toList();
		List<E> t_l= this.toList();
		Iterator<E> i_o=o_l.iterator();
		Iterator<E> i_t=t_l.iterator();
		while (i_o.hasNext()){
			E o_next= i_o.next();
			E t_next= i_t.next();
			if( (compare(o_next,t_next))!=0) return false;

		}
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * @see MyStackable#contains(Object)
	 */
	@Override
	public boolean contains(Object o) {
		return stack.contains(o);
	}
	/**
	 * We use the natural compareTo method,
	 * because <E> had to implement Comparable<E>!
	 * @see Compare
	 */
	@Override
	public int compare(E o1, E o2) {
		return o1.compareTo(o2);
	}



}
