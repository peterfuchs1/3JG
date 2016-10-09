package use_stack;

public class TestB {

	public static void main(String[] args) {
		int[] int1={4,1,2};
		String[] str1={"s1","s2","s3"};
		
		int[] int2={14,11,12};
		String[] str2={"s11","s12","s13"};

		int[] int3={24,21,22};
		String[] str3={"s21","s22","s23"};
		
		Verwenden v= new Verwenden();
		v.sichern(int1, str1);
		v.sichern(int2, str2);
		Merken m=new Merken(int3, str3);
		v.sichern(m);

		for(int i=0;i<3;++i){
			m=v.laden();
			m.printInts();
			m.printStrings();
		}

	}

}
