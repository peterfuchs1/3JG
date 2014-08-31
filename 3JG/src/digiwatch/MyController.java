/**
 * 
 */
package digiwatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author uhs374h
 * 
 */
public class MyController implements ActionListener {
	private MyPanel mPanel;
	private DigitalUhr model;

	/**
	 * @param gui
	 */
	public MyController() {
		model = new DigitalUhr();
		mPanel = new MyPanel(this);
		new MyFrame("DigitalUhr", mPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Buttons gedrückt
		String s = e.getActionCommand();
		switch (s) {
		case "set":
			model.set();
			break;
		case "inc":
			model.inc();
			doState();
			break;
		case "dec":
			model.dec();
			doState();
			break;
		default:
		}

	}

	public void doState() {
		mPanel.setStunden(model.getStunden());
		mPanel.setMinuten(model.getMinuten());
		mPanel.refresh();
	}

	public static void main(String[] a) {
		new MyController();
	}

}
