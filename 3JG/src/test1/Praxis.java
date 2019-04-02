package test1;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Praxis {
	public static void main(String[] args) {
		LocalTime start=LocalTime.of(8, 0);
		LocalTime end=LocalTime.now();
		//Version 1
		LocalTime dauer=LocalTime.of(end.getHour()-start.getHour(),end.getMinute());
		System.out.println(dauer);
		//Version 2
		long minutes=start.until(end, ChronoUnit.MINUTES);
		LocalTime start0=LocalTime.of(0, 0);
		LocalTime dauer_2=start0.plus(minutes, ChronoUnit.MINUTES);
		System.out.println(dauer_2);
	}
}

