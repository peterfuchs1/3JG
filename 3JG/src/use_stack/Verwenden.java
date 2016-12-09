package use_stack;

import java.util.Stack;

public class Verwenden {
	private Stack<Merken> stack;
	public Verwenden() {
		stack=new Stack<>();
	}
	public void sichern(int[] ints, String[] strings){
		this.sichern(new Merken(ints, strings));
	}
	public void sichern(Merken m){
		stack.push(m);
	}
	public Merken laden(){
		return stack.pop();
	}
}
