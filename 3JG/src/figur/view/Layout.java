package figur.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Layout extends JPanel {
    private Graphics g;
    private Figur[] figuren = new Figur[5];
    private int highestEmptyFigurElementIndex = 0;
    private JTextField x = new JTextField("x");
    private JTextField y = new JTextField("y");
    private JTextField groesse = new JTextField("groesse");
    private JTextField farbe = new JTextField("farbe");
    private JButton kreis = new JButton("kreis");
    private JButton quadrat = new JButton("quadrat");

    public Layout(ActionListener al) {
        setLayout(new BorderLayout());

        JPanel config = new JPanel();
        config.setLayout(new FlowLayout(FlowLayout.CENTER));
        kreis.setActionCommand("kreis");
        kreis.addActionListener(al);
        config.add(kreis);
        quadrat.setActionCommand("quadrat");
        quadrat.addActionListener(al);
        config.add(quadrat);

        JPanel drawing = new JPanel();
        drawing.setLayout(new BorderLayout());
    }

    public void drawKreis(int x, int y, Color farbe, int rad) {
        if (highestEmptyFigurElementIndex < figuren.length) {
            figuren[highestEmptyFigurElementIndex] = new Kreis(x, y, farbe, rad);
            figuren[highestEmptyFigurElementIndex].draw(g);
            highestEmptyFigurElementIndex++;
        }
    }

    public void drawQuadrat(int x, int y, Color farbe, int size) {

    }
}
