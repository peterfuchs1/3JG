package lotto2;

import java.util.TreeSet;

public class BrutForce extends Thread {
	private MyController myController;
	private boolean stopped=false;
	public static final long SLEEP_TIME=100L;
	/**
	 * @param myController
	 * @param model
	 */
	public BrutForce(MyController myController, Lotto model) {
		this.myController = myController;
	}
	
	@Override
	public void run(){
		while(!stopped){
			TreeSet<Integer> tip=Lotto.autoTip();
			myController.evalulateBF(tip);
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
				//Da kann man nichts mehr machen
				stopped=true;
			}

		}
		
	}
	
	public void stoppe(){
		stopped=true;
	}
}

