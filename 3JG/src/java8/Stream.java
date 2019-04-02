package java8;


import java.util.List;
import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;

public class Stream {
	private static List<Integer> getInts(){
		return Stream.getInts(0, 1000, 10000);
	}
	private static List<Integer> getInts(int min, int max, long count){
		Random r=new Random();
		return r.ints(count, min, max+1).boxed().collect(Collectors.toList());
	}
	private static List<Long> getLongs(){
		return Stream.getLongs(0, 1000, 10000);
	}
	private static List<Long> getLongs(int min, int max, long count){
		Random r=new Random();
		return r.longs(count, min, max+1).boxed().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<Integer> l1=Stream.getInts();
		List<Long> l2=Stream.getLongs();
		
		IntSummaryStatistics s =l1.stream().collect(Collectors.summarizingInt(x->x));
		System.out.println(s);
		
		System.out.println("Max="+s.getMax()+"; Min="+s.getMin()+"; Count="+s.getCount()
						+"; Average="+s.getAverage()+"; Sum="+s.getSum()
						);
		LongSummaryStatistics t =l2.stream().collect(Collectors.summarizingLong(x->x));
		
		System.out.println(t);
		System.out.println("Max="+t.getMax()+"; Min="+t.getMin()+"; Count="+t.getCount()
						+"; Average="+t.getAverage()+"; Sum="+t.getSum()
						);

	}

}
