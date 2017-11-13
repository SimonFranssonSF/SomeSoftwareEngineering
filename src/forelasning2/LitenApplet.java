package forelasning2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;

public class LitenApplet extends Applet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init () {
    	add(new Label("En_liten_applet_for_kursen_programutvecklingsteknik"));
    }

    public void paint (Graphics g) {
    	g.setColor(Color.cyan);
    	g.fillRect(100, 100, 50, 50);
    	g.setColor(Color.magenta);
    	g.fillRect(150, 100, 50, 50);
    	g.setColor(Color.yellow);
    	g.fillRect(200, 100, 50, 50);
    }
}
