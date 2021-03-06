package lotto2;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import java.util.*;

public class GUIListe extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUIListe(LinkedList<TreeSet<Integer>> ll, String head) {
		
		// Überschrift setzen
		this.setTitle(head);
		// Hintergrundfarbe setzen
		this.setBackground(Color.BLUE);
		// Schließe Anwendung, Falls der Frame geschlossen wurde
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel jp=new JPanel(new GridLayout(ll.size(),1));
		Iterator<TreeSet<Integer>> it=ll.iterator();
		while(it.hasNext()){
			String s=Lotto.toString(it.next());
			JLabel jl=new JLabel(s);
			jp.add(jl);
		
		}
		jp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		JScrollPane pane=new JScrollPane(jp);
//		pane.validate();
		this.setAlwaysOnTop(true);
		pane.setSize(80, 40);
		this.setContentPane(pane);
		
		this.pack();

		
		this.setVisible(true);
	}

}
