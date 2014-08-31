package polymorphie;

public class WrapperInteger  {
	private Integer value;
	public WrapperInteger(Integer t){
		this.value=t;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString(){
		return ""+getValue();
	}
	public static void main(String[] a){
		WrapperInteger s=new WrapperInteger(2);
		System.out.println(s.toString());
		
	}
}
