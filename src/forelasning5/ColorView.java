package forelasning5;

import javax.swing.*;
import java.awt.*;

class ColorAndView extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int red, green, blue;

    ColorAndView () {
	setPreferredSize(new Dimension(200, 200));
	setBackground(Color.white);
    }

    public void paintComponent (Graphics g) {
	super.paintComponent(g);
	g.setColor(new Color (red, green, blue));
	g.fillOval(40,40,120,120);
	g.setColor(Color.black);
	g.drawString
	    (" r = " + red + "  g = " + green + "  b = " + blue, 15, 185);
    }

    public void setColor(int r, int g, int b) {
	red = r; green = g; blue = b;
    }
}