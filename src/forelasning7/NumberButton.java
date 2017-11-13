package forelasning7;

import javax.swing.*;
class NumberButton extends JButton {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int number = 0;
    NumberButton(String s, int num) {
	super(s);
	number = num;
    }

}
