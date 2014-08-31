package polymorphie;

public class WrapperDouble  {
	private Double value;
	public WrapperDouble(Double t){
		this.value=t;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	@Override
	public String toString(){
		return ""+getValue();
	}
	public static void main(String[] a){
		WrapperDouble s=new WrapperDouble(3.6);
		System.out.println(s.toString());
		s.setValue(4.4);
		System.out.println(s.toString());
	}
}
