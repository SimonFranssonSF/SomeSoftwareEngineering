package ovning2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class Knapptest extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Knapptest () {
	setLayout(new GridLayout(2,2));
	setSize(200,200);
	for (int i=0; i<4; i++) {
	    MinKnapp knapp = new MinKnapp();
	    add(knapp);
	    knapp.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			((MinKnapp)e.getSource()).bytStatus();
		    }
		});
	}
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main (String[] u) {
    	new Knapptest();
    }
}
