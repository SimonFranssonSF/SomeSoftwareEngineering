package laboration1;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import laboration1.buttons.MyButton;

public class LabFrameKnapp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LabFrameKnapp(){
		setTitle("Simon");
		
		//Size for U1Frame
		setBounds(100, 100, 450, 300);
		
		//Exits java-application when closing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Center Frame
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Container for the jframe (lattviktsbehallare med komponenter i)
		Container container = getContentPane();
		
		//Background for contentPane
		Color color = new Color(0x798795);
		container.setBackground(color);
		
		//Creates, style and adds a button to the contentPane
		JLabel label = new JLabel("Uppgift 4A");
		label.setFont(new Font("Serif", Font.PLAIN, 36));
		label.setForeground(Color.orange);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setBounds(75 , 50, 300, 60);
	    container.add(label);

		//Creates and adds a Mybutton (subclass of jButton)
		MyButton button1 = new MyButton(Color.orange, Color.white, "På", "Av" );
		button1.setBounds(195, 180, 60, 36);
		container.add(button1);
		
		//Set Layout to null, absolute positioning, not recommended?
		container.setLayout(null);
	}
	
	public static void main(String[] args){
		LabFrameKnapp frame = new LabFrameKnapp();
		frame.setVisible(true);
	}

	
}
