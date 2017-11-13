package forelasning7;

import java.awt.*;
import javax.swing.*;
import java.util.*;
class TextView extends JFrame implements Observer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea ta = new JTextArea();
    TextView () {
	super("TextView of chocolate voting");
	setSize(300,200);
	ta.setEditable(false);
	ta.setFont(new Font("SansSerif",Font.PLAIN,20));
	add(ta);
	setVisible(true);
    }

    // From interface Observer
    public void update(Observable obs, Object arg) {
	VotesModel votes = (VotesModel) obs;
	StringBuilder tex = new StringBuilder("\n");
	for (int i = 0; i<votes.getN(); i++)
	    tex.append(" " + votes.getChoc(i) + " :  " + 
		       votes.getFreq(i) + "\n");
	ta.setText(tex.toString());
    }
}

// With StringBuilder, a String-object is built without 
// wasting space. 
