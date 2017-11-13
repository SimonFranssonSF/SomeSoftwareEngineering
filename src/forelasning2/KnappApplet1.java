package forelasning2;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
// import an extra class for the ActionListener 
import java.awt.event.ActionListener;

public class KnappApplet1 extends Applet implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int radie = 5;
    Button knapp = new Button("Tryck");

    public void init () {
    	setBackground(Color.white);
    	add(knapp);
    	knapp.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	radie +=5;
    	repaint();
    }

    public void paint (Graphics g) {
    	int x = getWidth()/2;    // window witdh
    	int y = getHeight()/2;   // window height
    	g.setColor(Color.red);   // to place circle in middle of window
    	g.fillOval(x-radie, y-radie, 2*radie, 2*radie);
    }
}