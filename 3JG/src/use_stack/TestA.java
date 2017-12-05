package use_stack;

public class TestA {

	public static void main(String[] args) {
		int[] int1={1,2,3};
		String[] str1={"s1","s2","s3"};
		
		int[] int3={21,22,23};
		String[] str3={"s21","s22","s23"};
		
		Verwenden v= new Verwenden();
		v.sichern(int1, str1);
		Merken m=new Merken(int3, str3);
		v.sichern(m);

		for(int i=0;i<=v.length();++i){
			m=v.laden();
			m.printInts();
			m.printStrings();
		}

	}

}

