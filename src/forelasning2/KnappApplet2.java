package forelasning2;
import java.awt.*; 
import java.applet.*; 
// import an extra class for the ActionListener 
import java.awt.event.*;

public class KnappApplet2 extends Applet implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int radie = 5;
    Button knapp = new Button("Tryck");

    public void init () {
    	this.setBackground(Color.green);
    	knapp.setBackground(Color.white);
    	add(knapp);
    	knapp.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	System.out.println("Hej knappen");
    }
}