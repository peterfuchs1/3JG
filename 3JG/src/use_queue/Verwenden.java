package use_queue;

import java.util.LinkedList;
import java.util.Queue;
public class Verwenden {
	private Queue<Merken> stack;
	public Verwenden() {
		stack=new LinkedList<>();
	}
	public void sichern(int[] ints, String[] strings){
		this.sichern(new Merken(ints, strings));
	}
	public void sichern(Merken m){
		stack.add(m);
	}
	public Merken laden(){
		return stack.remove();
	}
}
