package figur.view;

import java.awt.*;

/**
 * Quadrat
 * @author Michael Scholz
 * @version 04.10.2018
 */
public class Quadrat extends Figur {
    int rad;

    /**
     * Konstruktor
     */
    public Quadrat(int x, int y, Color farbe, int rad) {
        super(x, y, farbe);
        setRad(rad);
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
        g.fillOval(super.getX(), super.getY(), rad, rad);
    }

    /**
     * getter
     * @return rad
     */
    public int getRad() {
        return rad;
    }

    /**
     * setter
     * @param rad rad
     */
    public void setRad(int rad) {
        this.rad = rad;
    }
}
