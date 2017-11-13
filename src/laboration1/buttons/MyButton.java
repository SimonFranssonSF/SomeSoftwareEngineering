package laboration1.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mode1;
	String mode2;
	Color color1;
	Color color2;
	
	public MyButton(Color c1, Color c2, String m1, String m2){
		mode1 = m1;
		mode2 = m2;
		color1 = c1;
		color2 = c2;
		setSize(new Dimension(83, 291));
		setBackground(c1);
		setText(m1);
		
		//Makes it possible to change background color in osx
		setOpaque(true);
		setBorderPainted(false);
		
		addActionListener(this);
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
	
	public void actionPerformed(ActionEvent e) {
		toggleState();
	}

}
