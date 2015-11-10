package generics;

public class Box <T>{
	private T value;
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Box<Integer> b1=new Box<Integer>();
		b1.setValue(4);
		Box<String> b2=new Box<String>();
		b2.setValue("Text2");
		Box<Long> b3=new Box<Long>();
		b3.setValue(4L);
		System.out.println("Box1: "+b1.getValue());
		System.out.println("Box2: "+b2.getValue());
		System.out.println("Box3: "+b3.getValue());
	}

}
