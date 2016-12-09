/**
 * 
 */
package lotto2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * @author Walter Rafeiner-Magor
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	// Konstanten
	private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
//	private static final Font SMALLER_FONT = new Font("monspaced", Font.PLAIN, 14);

	private static final Color BACKGROUND_COLOR=new Color(176,226,255); //skyBlue
	@SuppressWarnings("unused")
	private static final Color COLOR2=new Color(0,191,255); //skyBlue
	
	
	private TreeSet<Integer> actualTip;
	private TreeSet<Integer> lottoTip;
	
	// rechts Output-Bereich
	private JTextField jtfZahlenGewaehlt;
	private JTextField jtfLottoZahlen;
	private JTextField jtfErgebnis;
	// rechts Button-Bereich
	private JButton jbNeuesLotto;
	private JButton jbNeuerTip;
	private JButton jbTipAuswerten;
	private JButton jbAutoTip;
	private JButton jbLottoAnzeigen;
	private JButton jbClear;
	
	// links Titelbereich
	private JTextArea jtaInfo;
	
	// links Werte-Bereich
	private JTextField[] jtfBFErgebnisse;
	private JButton[] jbBFAnzeige;
	// links Status-Bereich
	private JTextField jtfBFVersuche;
	private JTextField jtfBFBestTry;
	private JTextField jtfBFBestResult;
	// links Button-Bereich
	private JTextField jtfBFLottoZahlen;
	private JButton jbBFStart;
	private JToggleButton jbBFLottoZahlen;
	private JButton jbBFStop;
	
	private JButton[] numButtons;  						//numerische Buttons
	// Kontrollerklasse einbinden
//	private MyController myController; //wird durch den Parameter des
	// Kontruktors erreicht

	/**
	 * Konstruktor
	 */
	public MyPanel(MyController myController, Lotto model) {
		// höchster Wert stammt aus dem Model
		int valueHigh=Lotto.MAX;
		// Anzahl gezogene Werte stammt aus dem Model
		int valueCount=Lotto.ANZAHL;
		// Anzahl der Gewinnzeilen stammt aus dem Controller
		int resultLines=Lotto.ERGEBNISSE;
		//******************************
		//rechte Spalte 
		//******************************
		JPanel rechts=new JPanel(new GridLayout(4,1,10,10));
		//******************************
		//Titelzeile
		JPanel rechtsTitel=new JPanel();
		JLabel jlrechtsTitel= new JLabel("Lotto manuell");
		jlrechtsTitel.setFont(BIGGER_FONT);
		rechtsTitel.add(jlrechtsTitel);
		
		//******************************
		// Nummernblock
		JPanel rechtsWerte=new JPanel(new GridLayout(5,valueCount/5,3,3));
		// numerische Buttons erstellen
		numButtons=new JButton[valueHigh];
	       for (int i = 0; i < numButtons.length; i++) {
	        	numButtons[i]=new JButton(""+(i+1));
	        	numButtons[i].addActionListener(myController);
 
        		numButtons[i].setFont(BIGGER_FONT);
	        	numButtons[i].setToolTipText("Tippe "+(i+1));
	            rechtsWerte.add(numButtons[i]);
	        }
	 		
	    //******************************
		// Output-Bereich
			
		JPanel rechtsOutput=new JPanel(new GridLayout(3,2,20,20));
		
		JLabel jlZahlengewaehlt=new JLabel("Zahlen gewaehlt: ");
		jlZahlengewaehlt.setFont(BIGGER_FONT);
		jtfZahlenGewaehlt=new JTextField("");
		rechtsOutput.add(jlZahlengewaehlt);
		rechtsOutput.add(jtfZahlenGewaehlt);
		
		JLabel jlLottoZahlen=new JLabel("Lottozahlen: ");
		jlLottoZahlen.setFont(BIGGER_FONT);
		jtfLottoZahlen=new JTextField("");
		rechtsOutput.add(jlLottoZahlen);
		rechtsOutput.add(jtfLottoZahlen);
		
		JLabel jlErgebnis=new JLabel("Ergebnis: ");
		jlErgebnis.setFont(BIGGER_FONT);
		jtfErgebnis=new JTextField("");
		rechtsOutput.add(jlErgebnis);
		rechtsOutput.add(jtfErgebnis);
		
		//******************************
		// Button-Bereich
				
		JPanel rechtsButtons=new JPanel(new GridLayout(2,3,10,10));
		
		jbNeuesLotto=		new JButton("neues Lotto");
		jbNeuesLotto.addActionListener(myController);
		jbNeuesLotto.setFont(BIGGER_FONT);
		
		jbNeuerTip=			new JButton("neuer Tip");
		jbNeuerTip.addActionListener(myController);
		jbNeuerTip.setFont(BIGGER_FONT);
		
		jbAutoTip=			new JButton("Auto-Tip");
		jbAutoTip.addActionListener(myController);
		jbAutoTip.setFont(BIGGER_FONT);
		
		jbTipAuswerten=		new JButton("Tip auswerten");
		jbTipAuswerten.addActionListener(myController);
		jbTipAuswerten.setFont(BIGGER_FONT);
		
		jbLottoAnzeigen=	new JButton("Lotto anzeigen");
		jbLottoAnzeigen.addActionListener(myController);
		jbLottoAnzeigen.setFont(BIGGER_FONT);
		
		jbClear=			new JButton("Anzeige löschen");
		jbClear.addActionListener(myController);
		jbClear.setFont(BIGGER_FONT);
		
		rechtsButtons.add(jbNeuesLotto);
		rechtsButtons.add(jbNeuerTip);
		rechtsButtons.add(jbAutoTip);
		rechtsButtons.add(jbTipAuswerten);
		rechtsButtons.add(jbLottoAnzeigen);
		rechtsButtons.add(jbClear);
		
		// rechten Teil fertigstellen
		rechts.add(rechtsTitel);
		rechts.add(rechtsWerte);
		rechts.add(rechtsOutput);
		rechts.add(rechtsButtons);
		rechts.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		////////////////////////////////////////////////////////////

		//******************************
		//linke Spalte 
		//******************************
		JPanel links=new JPanel(new GridLayout(4,1,10,10));
		//******************************
		//Titelzeile
		JPanel linksTitel=new JPanel(new GridLayout(2,1,10,10));
		linksTitel.setBackground(BACKGROUND_COLOR);
		JLabel jllinksTitel= new JLabel("Lotto per Brute-force");
		jllinksTitel.setHorizontalAlignment(SwingConstants.CENTER);
		jllinksTitel.setFont(BIGGER_FONT);
		jllinksTitel.setBackground(BACKGROUND_COLOR);
		linksTitel.add(jllinksTitel);
		jtaInfo= new JTextArea(5,40);
		jtaInfo.setEditable(false);
		jtaInfo.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		jtaInfo.setText(
				"Diese Programm bietet die Möglichkeit mithilfe von Threads\n"+
				"eine beliebige Anzahl von Lotto-Tips zu ermitteln.\n"+
				"Jeder Tip wird statistisch ausgewertet\n"+ 
				"und ab einem 3er in Collections gespeichert"
				);
		jtaInfo.setFont(BIGGER_FONT);
		linksTitel.add(jtaInfo);

		//******************************
		// Ergebnisse
		JPanel linksWerte=new JPanel(new GridLayout(5,3,3,3));
		linksWerte.setBackground(BACKGROUND_COLOR);
		// Ergebnisfelder erstellen
		// 
		JLabel jlBFErgebnisse[]=new JLabel[resultLines];
		jtfBFErgebnisse=new JTextField[resultLines];
		jbBFAnzeige=new JButton[resultLines];
	       for (int i = 0; i < resultLines; i++) {
	    	   StringBuilder sb=new StringBuilder();
	    	   if(i>= resultLines-2)
	    		   sb.append(i+2);
	    	   else
	    		   sb.append(i+3);
	    	   sb.append("er ");
	    	   if(i==resultLines-2)
	    		   sb.append("mit ZZ");
	    	   
	    	   String text=sb.toString();
	    	   jlBFErgebnisse[i]=new JLabel(text+":");
	    	   jlBFErgebnisse[i].setFont(BIGGER_FONT);
	    	   linksWerte.add(jlBFErgebnisse[i]);
	    	   
	    	   jtfBFErgebnisse[i]=new JTextField("");
	    	   jtfBFErgebnisse[i].setFont(BIGGER_FONT);
	    	   jtfBFErgebnisse[i].setEditable(false);
	    	   linksWerte.add(jtfBFErgebnisse[i]);
	    	   
	    	   jbBFAnzeige[i]=new JButton("Anzeige "+text);
	    	   jbBFAnzeige[i].addActionListener(myController);
 	    	   jbBFAnzeige[i].setFont(BIGGER_FONT);
 	    	   jbBFAnzeige[i].setToolTipText("Zeige Liste von "+text+" an");
	           linksWerte.add(jbBFAnzeige[i]);
	        }
	    //******************************
		// Status-Bereich
				
		JPanel linksOutput=new JPanel(new GridLayout(3,2,20,20));
		linksOutput.setBackground(BACKGROUND_COLOR);
		JLabel jlBFVersuche=new JLabel("Anzahl Versuche: ");
		jlBFVersuche.setFont(BIGGER_FONT);
		linksOutput.add(jlBFVersuche);
		jtfBFVersuche=new JTextField("");
		jtfBFVersuche.setFont(BIGGER_FONT);
		jtfBFVersuche.setEditable(false);
		linksOutput.add(jtfBFVersuche);
		
		JLabel jlBFBestTry=new JLabel("Bester Versuch: ");
		jlBFBestTry.setFont(BIGGER_FONT);
		linksOutput.add(jlBFBestTry);
		jtfBFBestTry=new JTextField("");
		jtfBFBestTry.setFont(BIGGER_FONT);
		jtfBFBestTry.setEditable(false);
		linksOutput.add(jtfBFBestTry);
		

		JLabel jlBFBestResult=new JLabel("Bestes Ergebnis: ");
		jlBFBestResult.setFont(BIGGER_FONT);
		linksOutput.add(jlBFBestResult);
		jtfBFBestResult=new JTextField("");
		jtfBFBestResult.setFont(BIGGER_FONT);
		jtfBFBestResult.setEditable(false);
		linksOutput.add(jtfBFBestResult);		
		
		
		//******************************
		// Button-Bereich
	    
		JPanel linksButtonBereich=new JPanel(new GridLayout(3,1));
		
		JPanel linksLottoZahlen=new JPanel(new GridLayout(1,2,10,20));
		linksLottoZahlen.setBackground(BACKGROUND_COLOR);
		JPanel linksDummyButtons=new JPanel(new GridLayout(1,3,10,10));
		linksDummyButtons.setBackground(BACKGROUND_COLOR);
	    JPanel linksButtons=new JPanel(new GridLayout(1,3,10,10));
	    linksButtons.setBackground(BACKGROUND_COLOR);
	    
	    
	    
	    
	    JLabel jlBFLottoZahlen=new JLabel("aktuelle Lottozahlen");
	    jlBFLottoZahlen.setFont(BIGGER_FONT);
	    jtfBFLottoZahlen=new JTextField("");
	    jtfBFLottoZahlen.setEditable(false);
	    jtfBFLottoZahlen.setVisible(false);
	    jtfBFLottoZahlen.setFont(BIGGER_FONT);
	    linksLottoZahlen.add(jlBFLottoZahlen);
	    linksLottoZahlen.add(jtfBFLottoZahlen);
	    
	  //Dummy buttons
	    {
	    	JLabel dummy[]=new JLabel[3];
	    	for(int i=0;i<dummy.length;i++){
	    	dummy[i]=new JLabel();
	    	linksDummyButtons.add(dummy[i]);
	    	}
	    }
	    
	    jbBFStart=new JButton("Start Brute-force");
	    jbBFStart.addActionListener(myController);
	    jbBFStart.setFont(BIGGER_FONT);
	    linksButtons.add(jbBFStart);

	    jbBFLottoZahlen=new JToggleButton("Lottozahlen anzeigen");
	    jbBFLottoZahlen.addActionListener(myController);
	    jbBFLottoZahlen.setToolTipText("Schaltet die Lottozahlen ein und aus");
	    jbBFLottoZahlen.setFont(BIGGER_FONT);
	    linksButtons.add(jbBFLottoZahlen);
	    
	    jbBFStop=new JButton("Stoppe Brute-force");
	    jbBFStop.addActionListener(myController);
	    jbBFStop.setFont(BIGGER_FONT);
	    linksButtons.add(jbBFStop);
	    
	    linksButtonBereich.add(linksLottoZahlen);
	    linksButtonBereich.add(linksDummyButtons);
	    linksButtonBereich.add(linksButtons);
	    
	    
		// linken Teil fertigstellen
		links.add(linksTitel);
		links.add(linksWerte);
		links.add(linksOutput);
		links.add(linksButtonBereich);
		links.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		////////////////////////////////////////////////////////////

		
        ////////////////////////////////////////////////////////////
        // Main Panel
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(BACKGROUND_COLOR);
        this.add(links);
        this.add(rechts);
        // 10 Pixel Abstand in alle Richtungen
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        ////////////////////////////////////////////////////////////
        
        
        
	}

	/**
	 * @return the actualTip
	 */
	public TreeSet<Integer> getActualTip() {
		return actualTip;
	}

	/**
	 * @param actualTip the actualTip to set
	 */
	public void setActualTip(TreeSet<Integer> actualTip) {
		this.actualTip = actualTip;
	}

	/**
	 * @return the lottoTip
	 */
	public TreeSet<Integer> getLottoTip() {
		return lottoTip;
	}

	/**
	 * @param lottoTip the lottoTip to set
	 */
	public void setLottoTip(TreeSet<Integer> lottoTip) {
		this.lottoTip = lottoTip;
	}

	/**
	 * @return the jtfZahlenGewaehlt
	 */
	public String getJtfZahlenGewaehlt() {
		return jtfZahlenGewaehlt.getText();
	}

	/**
	 * @param jtfZahlenGewaehlt the jtfZahlenGewaehlt to set
	 */
	public void setJtfZahlenGewaehlt(String jtfZahlenGewaehlt) {
		this.jtfZahlenGewaehlt.setText(jtfZahlenGewaehlt);
	}

	/**
	 * @return the jtfLottoZahlen
	 */
	public String getJtfLottoZahlen() {
		return jtfLottoZahlen.getText();
	}

	/**
	 * @param jtfLottoZahlen the jtfLottoZahlen to set
	 */
	public void setJtfLottoZahlen(String jtfLottoZahlen) {
		this.jtfLottoZahlen.setText(jtfLottoZahlen);
	}

	/**
	 * @return the jtfErgebnis
	 */
	public String getJtfErgebnis() {
		return jtfErgebnis.getText();
	}

	/**
	 * @param jtfErgebnis the jtfErgebnis to set
	 */
	public void setJtfErgebnis(String jtfErgebnis) {
		this.jtfErgebnis.setText(jtfErgebnis);
	}

	/**
	 * @return the jbNeuesLotto
	 */
	public JButton getJbNeuesLotto() {
		return jbNeuesLotto;
	}

	/**
	 * @param jbNeuesLotto the jbNeuesLotto to set
	 */
	public void setJbNeuesLotto(JButton jbNeuesLotto) {
		this.jbNeuesLotto = jbNeuesLotto;
	}

	/**
	 * @return the jbNeuerTip
	 */
	public JButton getJbNeuerTip() {
		return jbNeuerTip;
	}

	/**
	 * @param jbNeuerTip the jbNeuerTip to set
	 */
	public void setJbNeuerTip(JButton jbNeuerTip) {
		this.jbNeuerTip = jbNeuerTip;
	}

	/**
	 * @return the jbTipAuswerten
	 */
	public JButton getJbTipAuswerten() {
		return jbTipAuswerten;
	}

	/**
	 * @param jbTipAuswerten the jbTipAuswerten to set
	 */
	public void setJbTipAuswerten(JButton jbTipAuswerten) {
		this.jbTipAuswerten = jbTipAuswerten;
	}

	/**
	 * @return the jbAutoTip
	 */
	public JButton getJbAutoTip() {
		return jbAutoTip;
	}

	/**
	 * @param jbAutoTip the jbAutoTip to set
	 */
	public void setJbAutoTip(JButton jbAutoTip) {
		this.jbAutoTip = jbAutoTip;
	}

	/**
	 * @return the jbLottoAnzeigen
	 */
	public JButton getJbLottoAnzeigen() {
		return jbLottoAnzeigen;
	}

	/**
	 * @param jbLottoAnzeigen the jbLottoAnzeigen to set
	 */
	public void setJbLottoAnzeigen(JButton jbLottoAnzeigen) {
		this.jbLottoAnzeigen = jbLottoAnzeigen;
	}

	/**
	 * @return the jbClear
	 */
	public JButton getJbClear() {
		return jbClear;
	}

	/**
	 * @param jbClear the jbClear to set
	 */
	public void setJbClear(JButton jbClear) {
		this.jbClear = jbClear;
	}

	/**
	 * @return the jtfBFErgebnisse
	 */
	public String getJtfBFErgebnisse(int index) {
		return jtfBFErgebnisse[index].getText();
	}

	/**
	 * @param jtfBFErgebnisse the jtfBFErgebnisse to set
	 */
	public void setJtfBFErgebnisse(String jtfBFErgebnisse, int index) {
		this.jtfBFErgebnisse[index].setText(jtfBFErgebnisse);
	}

	/**
	 * @return the jbBFAnzeige
	 */
	public JButton getJbBFAnzeige(int index) {
		return jbBFAnzeige[index];
	}

	/**
	 * @param jbBFAnzeige the jbBFAnzeige to set
	 */
	public void setJbBFAnzeige(JButton jbBFAnzeige, int index) {
		this.jbBFAnzeige[index] = jbBFAnzeige;
	}

	/**
	 * @return the jtfBFVersuche
	 */
	public String getJtfBFVersuche() {
		return jtfBFVersuche.getText();
	}

	/**
	 * @param jtfBFVersuche the jtfBFVersuche to set
	 */
	public void setJtfBFVersuche(String jtfBFVersuche) {
		this.jtfBFVersuche.setText(jtfBFVersuche);
		
	}

	/**
	 * @return the jtfBFBestTry
	 */
	public String getJtfBFBestTry() {
		return jtfBFBestTry.getText();
	}

	/**
	 * @param jtfBFBestTry the jtfBFBestTry to set
	 */
	public void setJtfBFBestTry(String jtfBFBestTry) {
		this.jtfBFBestTry.setText(jtfBFBestTry);
	}

	/**
	 * @return the jtfBFBestResult
	 */
	public String getJtfBFBestResult() {
		return jtfBFBestResult.getText();
	}

	/**
	 * @param jtfBFBestResult the jtfBFBestResult to set
	 */
	public void setJtfBFBestResult(String jtfBFBestResult) {
		this.jtfBFBestResult.setText(jtfBFBestResult);
	}

	/**
	 * @return the jbBFStart
	 */
	public JButton getJbBFStart() {
		return jbBFStart;
	}

	/**
	 * @param jbBFStart the jbBFStart to set
	 */
	public void setJbBFStart(JButton jbBFStart) {
		this.jbBFStart = jbBFStart;
	}

	/**
	 * @return the jbBFStop
	 */
	public JButton getJbBFStop() {
		return jbBFStop;
	}

	/**
	 * @param jbBFStop the jbBFStop to set
	 */
	public void setJbBFStop(JButton jbBFStop) {
		this.jbBFStop = jbBFStop;
	}

	/**
	 * @return the numButtons
	 */
	public JButton[] getNumButtons() {
		return numButtons;
	}

	/**
	 * @param numButtons the numButtons to set
	 */
	public void setNumButtons(JButton[] numButtons) {
		this.numButtons = numButtons;
	}

	/**
	 * @return the jtfBFLottoZahlen
	 */
	public JTextField getJtfBFLottoZahlen() {
		return jtfBFLottoZahlen;
	}

	/**
	 * @param jtfBFLottoZahlen the jtfBFLottoZahlen to set
	 */
	public void setJtfBFLottoZahlen(JTextField jtfBFLottoZahlen) {
		this.jtfBFLottoZahlen = jtfBFLottoZahlen;
	}

	/**
	 * @return the jbBFLottoZahlen
	 */
	public JToggleButton getJbBFLottoZahlen() {
		return jbBFLottoZahlen;
	}



}
