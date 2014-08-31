/**
 * 
 */
package effizienz;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class Test {
	private int[] array;
	public void gut(){
		array=new int[99];
		for(int i=0;i<array.length;i++)
			array[i]=i*i;
	}
	
	public void besser(){
		array=new int[99];
		int len=array.length;
		int i;
		for(i=0;i<len;i++)
			array[i]=i*i;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
