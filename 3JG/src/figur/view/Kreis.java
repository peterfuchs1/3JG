package figur.view;

import java.awt.*;

/**
 * Kreis
 * @author Michael Scholz
 * @version 04.10.2018
 */
public class Kreis extends Figur {
    int side;

    /**
     * Konstruktor
     */
    public Kreis(int x, int y, Color farbe, int side) {
        super(x, y, farbe);
        setSide(side);
    }

    /**
     * zeichenmethode (ruft paintComponent auf)
     * @param g Graphics Object
     */
    @Override
    public void draw(Graphics g) {
        repaint();
    }

    /**
     * zeichenmethode
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(super.getFarbe());
        g.fillRect(super.getX(), super.getY(), side, side);
    }

    /**
     * getter
     * @return side
     */
    public int getSide() {
        return side;
    }

    /**
     * setter
     * @param side side
     */
    public void setSide(int side) {
        this.side = side;
    }
}
