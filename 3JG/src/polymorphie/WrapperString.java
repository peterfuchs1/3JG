package polymorphie;

public class WrapperString  {
	private String value;
	public WrapperString(String t){
		this.value=t;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString(){
		return ""+getValue();
	}
	public static void main(String[] a){
		WrapperString s=new WrapperString("1");
		System.out.println(s.toString());
		
	}
}
