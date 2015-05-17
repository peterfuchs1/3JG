/**
 * 
 */
package digiwatch;

import java.time.ZonedDateTime;

/**
 * @author uhs374h
 *
 */
public class MyClock extends Thread {

	private MyPanel mp;
	private DigitalUhr uhr;
	private boolean running;

	/**
	 * 
	 */
	public MyClock(MyPanel mp, DigitalUhr uhr) {
		this.mp=mp;
		this.uhr=uhr;
		this.running=true;
		
	}
	@Override
	public void run(){
		while(running){
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
			}
			ZonedDateTime lt=ZonedDateTime.now();
			int localtime=lt.getHour()*60+lt.getMinute()-uhr.getDifToLocalTime();
			int hour=localtime/60;
			int minute=localtime-hour*60;
			mp.setStunden(DigitalUhr.toDigits(hour));
			mp.setMinuten(DigitalUhr.toDigits(minute));
			mp.refresh();
		}
		
	}
	public void stopping(){
		this.running=false;
	}
}
