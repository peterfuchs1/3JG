/**
 * 
 */
package lotto2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

/**
 * @author Walter Rafeiner-Magor
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	MyPanel myPanel;
	public MyFrame(MyPanel myPanel) {
		this.myPanel=myPanel;
		// ‹berschrift setzen
		this.setTitle("Lottocenter");
		// Hintergrundfarbe setzen
		this.setBackground(Color.BLUE);
		// Schlieﬂe Anwendung, Falls der Frame geschlossen wurde
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(BorderLayout.CENTER,myPanel);
	
		this.pack();
		this.setVisible(true);
	}
}
