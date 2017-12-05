package use_queue;

import java.util.LinkedList;
import java.util.Queue;
public class Verwenden {
	private Queue<Merken> liste;
	public Verwenden() {
		liste=new LinkedList<>();
	}
	public void sichern(int[] ints, String[] strings){
		this.sichern(new Merken(ints, strings));
	}
	public void sichern(Merken m){
		liste.add(m);
	}
	public Merken laden(){
		return liste.remove();
	}
	public int length() {
		return liste.size();
	}
}
