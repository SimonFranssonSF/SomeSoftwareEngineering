package forelasning3;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniJFrame {
	
	public static void main (String[] args){
		JFrame frame = new JFrame(); //Frame object
		frame.setSize(300, 200); //Frame size
		frame.setLocation(500,400); //Location on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program when frame closed
		JLabel label = new JLabel("Piotr");
		label.setBackground(Color.blue);
		label.setOpaque(true); //Otherwise the Jlabel-object is transparent and the color unvisible
		
		frame.add(label); //add the label to the frame
		frame.setVisible(true); //Make the frame visible
		frame.pack(); // Pack to minimal size that is preferred
	}

}
