package laboration1.buttons;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class ExtraUppgKnapp extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mode1;
	String mode2;
	Color color1;
	Color color2;
	
	public ExtraUppgKnapp(Color c1, Color c2, String m1, String m2){
		mode1 = m1;
		mode2 = m2;
		color1 = c1;
		color2 = c2;
		setPreferredSize(new Dimension(100, 100));
		setBackground(c1);
		
		//To color buttons in OSX
		//
		
		setText(m1);
		setOpaque(true);
		setBorderPainted(false);
	}
	
	public void toggleState(){
		if(getBackground() == color1){
			setBackground(color2);
			setText(mode2);
		}else{
			setBackground(color1);
			setText(mode1);
		}
	}

}
