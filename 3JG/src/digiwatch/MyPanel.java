/**
 * 
 */
package digiwatch;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// center
	private JPanel anzeige;
	// east
	private JPanel buttons;
	///////////////
	// Buttons
	private JButton inc,dec,set;
	///////////////
	// TextFields
	private JTextField stunden,minuten;
	//////////////
	// Labels
	private JLabel dp;
	/**
	 * @param model
	 */
	public MyPanel(MyController controller) {
		//create new Font
        Font font = new Font("Courier", Font.BOLD,48);
        
		this.setLayout(new BorderLayout());
		///CENTER: Anzeige
		anzeige=new JPanel();
		stunden=new JTextField("00", 2);
		stunden.setEditable(false);
		stunden.setFont(font);
		anzeige.add(stunden);
		
		dp=new JLabel(":");
		dp.setFont(font);
		anzeige.add(dp);
		
		minuten=new JTextField("00",2);
		minuten.setEditable(false);
		minuten.setFont(font);
		anzeige.add(minuten);
		this.add(anzeige,BorderLayout.CENTER);
		
		///EAST: Buttons
		buttons=new JPanel(new GridLayout(3,1));
		String label="set";
		set=new JButton(label);
		set.addActionListener(controller);
		buttons.add(set);
		
		label="inc";
		inc=new JButton(label);
		inc.addActionListener(controller);
		buttons.add(inc);
		
		label="dec";
		dec=new JButton(label);
		dec.addActionListener(controller);
		buttons.add(dec);
		this.add(buttons,BorderLayout.EAST);
	}
	public void setStunden(String s){
		this.stunden.setText(s);
	}
	public void setMinuten(String m){
		this.minuten.setText(m);
	}
	public void refresh(){
		this.repaint();
	}
}