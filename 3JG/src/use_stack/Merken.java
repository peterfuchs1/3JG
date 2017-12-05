package use_stack;

public class Merken {
	private int[] ints;
	private String[] strings;
	
	public Merken(int[] ints, String[] strings) {
		this.ints = ints;
		this.strings = strings;
	}
	
	public void printInts(){
		for (int i: ints)
			System.out.println(i);
	}
	
	public void printStrings(){
		for (String s: strings)
			System.out.println(s);
	}
}
