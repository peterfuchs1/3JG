package test1;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class Coll {
	
	public static void main(String[] args) {
		// get 10000 random values as a list
//		List<Integer> ll=Coll.getInts();
		List<Double> ll=Coll.getDoubles(9,1,1000);
		DoubleSummaryStatistics stats=ll.stream()
				.mapToDouble(s->s.intValue())
			    .summaryStatistics();

		System.out.println("Anzahl: "+stats.getCount());
		System.out.println("summe: "+stats.getSum() +"\nDurchschnitt: "+ stats.getAverage());
		System.out.println("min: "+stats.getMin()+"\nmax: "+stats.getMax());
	}
	private static List<Double> getDoubles() {
		return Coll.getDoubles(10000, 1, 1001);
	}
	/**
	 * create new List of Integer objects
	 * use standard values
	 * count: 10.000, minimum value: 1, maximum value 1000
	 * @return a List<Integer>
	 */
	private static List<Integer> getInts(){
		int count=10000;
		int min =1;
		int max=1000;
		return Coll.getInts(count,min,max);
	}
	/**
	 * create new List of Integer objects
	 * @param count the object
	 * @param min of the values
	 * @param max of the values
	 * @return a List<Integer>
	 */
	private static List<Integer> getInts(long count, int min, int max){
		// create a new Random-Object
		Random r = new Random();
		// create random ints, boxed to Integer and add all values into a list
		return r.ints(count, min, max+1).boxed().collect(Collectors.toList());
	}
	
	/**
	 * create new array of ints
	 * @param count the values
	 * @param min of the values
	 * @param max of the values
	 * @return an array of ints
	 */
	private static int[] getIntArray(long count, int min, int max) {
		Random r=new Random();
		return r.ints(count, min, max+1).toArray();
	}

	private static List<Double> getDoubles (long count, int min, int max){
		// create a new Random-Object
		Random r = new Random();
		// create random ints, boxed to Integer and add all values into a list
		return r.doubles(count, min, max+1).boxed().collect(Collectors.toList());
	}

}
