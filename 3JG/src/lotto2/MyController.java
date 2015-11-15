/**
 * 
 */
package lotto2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JToggleButton;


/**
 * @author uhs374h
 *
 */
public class MyController implements ActionListener{
	private MyFrame mf;
	private MyPanel gui;
	private Lotto model;
	
	private int anzGewaehlterZahlen;
// Bruteforce
	public static final int BF_ERGEBNISSE=5;
	private ArrayList<LinkedList<TreeSet<Integer>>> bfListe;		// alle Tipps gesammelt
	private int bfVersuche;
	private int bfBestResult;
	private int bfErgebnisse[];
	private BrutForce bf=null;
	
	public static void main(String[] args){
		new MyController();
	}
	
	public void startBF(){
		if(bf==null){
			model.newTip();
			clearBF();
			bf=new BrutForce(this,model);

			bfListe=new ArrayList<LinkedList<TreeSet<Integer>>>();
			for(int i=0;i<BF_ERGEBNISSE;i++){
				bfListe.add( new LinkedList<TreeSet<Integer>>());
			}

			bf.start();
		}
	}
	
	public void showLottozahlen(){
		boolean aktuell=!gui.getJtfBFLottoZahlen().isVisible();
		gui.getJtfBFLottoZahlen().setVisible(aktuell);
		
	}
	
	public void stopBF(){
		if(bf!=null){
			bf.stoppe();
			bf=null;
		}
	}

	public void clearBF(){
		bfBestResult=0;
		bfVersuche=0;
		this.bfErgebnisse=new int[BF_ERGEBNISSE];
		for(int i=0;i<bfErgebnisse.length;i++) {
			bfErgebnisse[i]=0;
			gui.setJtfBFErgebnisse(""+0, i);
		}
		gui.setJtfBFBestResult("");
		gui.setJtfBFVersuche("0");
		
		gui.getJtfBFLottoZahlen().setVisible(false);
		gui.getJtfBFLottoZahlen().setText(model.toString());
		
		
	}
	/**
	 * @param tip (aktueller autotip)
	 * @param index (3er, 4er, 5er, 5er ZZ, 6er)
	 */
	public void setBfListe(TreeSet<Integer> tip, int index) {
		this.bfListe.get(index).add( tip);
	}

	public void evalulateBF(TreeSet<Integer> tip){
		int erg=model.check(tip);
		boolean zz=model.checkZusatz(tip);
		switch (erg){
		case 3:
		case 4:
			bfErgebnisse[erg-3]++;
			setBfListe(tip, erg-3);break;
		case 6:
			bfErgebnisse[erg-2]++;
			setBfListe(tip, erg-2);break;
		case 5:
			if(zz){
				bfErgebnisse[erg-2]++;
				setBfListe(tip, erg-2);
			}
			else{
				bfErgebnisse[erg-3]++;
				setBfListe(tip, erg-3);
			}
		}
		bfVersuche++;
		gui.setJtfBFVersuche(""+bfVersuche);
		if(erg>2){
			for(int i=0;i<BF_ERGEBNISSE;i++){
				gui.setJtfBFErgebnisse(""+bfErgebnisse[i], i);
			}
		}
		if (erg>bfBestResult) {
			bfBestResult=erg;
			gui.setJtfBFBestTry(Lotto.toString(tip));
			gui.setJtfBFBestResult(""+erg);
		}
	}
	
	
	/**
	 * @param gui
	 */
	public MyController() {
		// neues Model erstellen
		model=new Lotto();
		// neues Panel erstellen
		gui=new MyPanel(this,model);
		// neuer Frame erstellen
		mf=new MyFrame(gui);
				
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Buttons gedrückt
		Object o=e.getSource();
		if(o==gui.getJbBFStart()) startBF();
		else if( o==gui.getJbBFStop()) stopBF();
		else if( o==gui.getJbBFAnzeige(0)) new GUIListe(bfListe.get(0),"3er");
		else if( o==gui.getJbBFAnzeige(1)) new GUIListe(bfListe.get(1),"4er");
		else if( o==gui.getJbBFAnzeige(2)) new GUIListe(bfListe.get(2),"5er");
		else if( o==gui.getJbBFAnzeige(3)) new GUIListe(bfListe.get(3),"5er mit ZZ");
		else if( o==gui.getJbBFAnzeige(4)) new GUIListe(bfListe.get(4),"6er");
		else if( o==gui.getJbBFLottoZahlen()) showLottozahlen();
		gui.requestFocus();
	}


}
