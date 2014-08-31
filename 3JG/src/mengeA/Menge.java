package mengeA;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;



public class Menge<E> extends TreeSet<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1104600478535160705L;

	/**
	 * Return the union of this set with that set.
	 */
	public Menge<E> or(Menge<E> other) {
		Menge<E> c = new Menge<E>();
		c.addAll(this);
		c.addAll(other);
		return c;
	}

	/**
	 * Return the intersection of this set with that set.
	 */
	public Menge<E> and(Menge<E> other) {
		Menge<E> c = new Menge<E>();
		if (this.size() < other.size()) {
			for (E x : this) 
				if (other.contains(x)) c.add(x);
		} else {
			for (E x : other) 
				if (this.contains(x)) c.add(x);
		}
		return c;
	}
	/**
	 * Komplement this \ other
	 * @param other
	 * @return koplement as Menge
	 */
	public Menge<E> komplement(Menge<E> other){
		Menge<E> c = new Menge<E>();
		for(E x: this)
			if(!other.contains(x)) c.add(x);
		return c;
	}
	/**
	 * Komplement other \ this
	 * @param other
	 * @return koplement as Menge
	 */
	public Menge<E> komplement2(Menge<E> other){
		Menge<E> c = new Menge<E>();
		for(E x: other)
			if(!this.contains(x)) c.add(x);
		return c;
	}

	/**
	 * symmetric difference (this\other | other\this)
	 * @param other
	 * @return symmetric difference as Menge
	 */
	public Menge<E> xor(Menge<E> other){
		Menge<E> c = new Menge<E>();
		c.addAll(komplement(other));
		c.addAll(komplement2(other));
		return c;
	}
	/**
	 * 
	 */
	public boolean equals(Object o) {
		if (o==null) return false;
		if (this==o) return true;
		boolean ret=false;
		if(this.getClass()==o.getClass()){
			Menge<?> m=(Menge<?>) o;
			if(this.size()==m.size()){
				ret=true;
				Iterator<E> i1=this.iterator();
				Iterator<?> i2=m.iterator();
				while(ret && i1.hasNext()){
					ret=i1.next().equals(i2.next());
				}
			}
		}
		return ret;
	}
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		// TODO Auto-generated method stub
		for(E x:Menge.this)
			sb.append(x.toString()).append("; ");
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menge<Integer> m1=new Menge<>();
		Menge<Integer> m2=new Menge<>();
		Random r= new Random();
		for(int i=0;i<15;i++){
			m1.add(r.nextInt(20)+1);
			m2.add(r.nextInt(20)+1);
		}
		System.out.println("Menge 1:"+m1.toString());
		System.out.println("Menge 2:"+m2.toString());

		Menge<Integer> ver=m1.or(m2);
		Menge<Integer> durch=m1.and(m2);
		Menge<Integer> diff=m1.komplement(m2);
		Menge<Integer> diff2=m1.komplement2(m2);
		Menge<Integer> xor=m1.xor(m2);
		
		System.out.println("m1 | m2:"+ver.toString());
		System.out.println("m1 & m2:"+durch.toString());
		System.out.println("m1 \\ m2:"+diff.toString());
		System.out.println("m2 \\ m1:"+diff2.toString());
		System.out.println("m1 xor m2:"+xor.toString());
		System.out.println("m1&m2 == m2&m1:"+durch.equals(m2.and(m1)));
		System.out.println("m1|m2 == (m2\\m1)|(m1\\m2)|(m1&m2):"+ver.equals(diff.or(diff2).or(durch)));
	}

}
