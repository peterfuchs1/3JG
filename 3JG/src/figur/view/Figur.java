package figur.view;

import javax.swing.*;
import java.awt.*;

/**
 * Figur
 * @author Michael Scholz
 * @version 04.10.2018
 */
public class Figur extends JPanel {
    private int x;
    private int y;
    private Color farbe;

    /**
     * Konstruktor
     */
    public Figur(int x, int y, Color farbe) {
        setX(x);
        setY(y);
        setFarbe(farbe);
    }

    /**
     * toString methode
     *
     * @return attribute als String
     */
    public String toString() {
        return "(" + x + "|" + y + "):" + farbe.toString();
    }

    /**
     * zeichenmethode
     * @param g Graphics Object
     */
    public void draw(Graphics g) {
    }


    /**
     * getter
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * setter
     * @param x x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * setter
     * @param y y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter
     * @return farbe
     */
    public Color getFarbe() {
        return farbe;
    }

    /**
     * setter
     * @param farbe farbe
     */
    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }
}
