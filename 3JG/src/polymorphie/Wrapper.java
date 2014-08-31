package polymorphie;

public class Wrapper<T>  {
	private T value;
	
	public Wrapper(T t){
		this.value=t;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	@Override
	public String toString(){
		return ""+getValue();
	}
	public static void main(String[] a){
		Wrapper<String> s=new Wrapper<String>("1");
		System.out.println(s.toString());
		Wrapper<Integer> i=new Wrapper<>(2);
		System.out.println(i.toString());
		Wrapper<Double> d=new Wrapper<>(3.6);
		System.out.println(d.toString());
		d.setValue(4.4);
		System.out.println(d.toString());
	}
}
