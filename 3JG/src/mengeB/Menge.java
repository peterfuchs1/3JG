package mengeB;

import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;



public class Menge<E> extends HashSet<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1104600478535160705L;

	/**
	 * Return the union of this set with that set.
	 */
	public Menge<E> vereinigung(Menge<E> other) {
		Menge<E> c = new Menge<E>();
		for (E x : this) {
			c.add(x);
		}
		for (E x : other) {
			c.add(x);
		}
		return c;
	}

	/**
	 * Return the intersection of this set with that set.
	 */
	public Menge<E> durchschnitt(Menge<E> other) {
		Menge<E> c = new Menge<E>();
		if (this.size() < other.size()) {
			for (E x : this) {
				if (other.contains(x))
					c.add(x);
			}
		} else {
			for (E x : other) {
				if (this.contains(x))
					c.add(x);
			}
		}
		return c;
	}

	public Menge<E> differenz(Menge<E> other){
		Menge<E> c = new Menge<E>();
		Menge<E> durchschnitt=this.durchschnitt(other);

		for(E x: this){
			if(!durchschnitt.contains(x))
				c.add(x);
		}
		return c;
	}
	public Menge<E> symmetrie(Menge<E> other){
		Menge<E> c = new Menge<E>();
		Menge<E> vereinigung=this.vereinigung(other);
		Menge<E> durchschnitt=this.durchschnitt(other);
		for(E x: vereinigung){
			if(!vereinigung.contains(durchschnitt))
				c.add(x);
		}
		return c;
	}
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
		for(E x:Menge.this){
			sb.append(x.toString()).append("; ");
		}
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

		Menge<Integer> ver=m1.vereinigung(m2);
		Menge<Integer> durch=m1.durchschnitt(m2);
		Menge<Integer> diff=m1.differenz(m2);
		
		System.out.println("m1 | m2:"+ver.toString());
		System.out.println("m1 & m2:"+durch.toString());
		System.out.println("m1 \\ m2:"+diff.toString());
		System.out.println("m1&m2 == m2&m1:"+durch.equals(m2.durchschnitt(m1)));
		System.out.println("m1|m2 == (m2\\m1)|(m1&m2):"+durch.equals(diff.vereinigung(durch)));
	}

}
