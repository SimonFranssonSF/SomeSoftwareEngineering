package forelasning5;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorMix extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ColorMix () {
	setLayout(new FlowLayout());
	setSize(400, 300);
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(2,1));
	JLabel l1 = 
	    new JLabel("Välkommen till färgblandaren!");
	JLabel l2 = 
	    new JLabel("Ställ in rött, grönt och blått!");
	p.add(l1); p.add(l2);
	add(p);

	ColorAndView cav = new ColorAndView();    // model and view
	ControlPanel cp = new ControlPanel(cav);  // control

	add(cav);
	add(cp);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main (String[] x) {
	new ColorMix();
    }
}