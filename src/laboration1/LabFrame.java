package laboration1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import laboration1.buttons.MyButton;

public class LabFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LabFrame(){
		//Exits java-application when closing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame Settings
		setTitle("Simon");
		
		//Container for the jframe (lattviktsbehallare med komponenter i)
        Container container = getContentPane();
        
        //for backgroundcolor jPanels
        Color color = new Color(0x798795);
        
        //Panel containing buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3,3,4,4));
        buttonPanel.setBackground(color);
		
		//Make some MyButtons, subclass of Jbutton
		MyButton button1 = new MyButton(Color.green, Color.red, "ON", "OFF" );
		MyButton button2 = new MyButton(Color.blue, Color.yellow, "Blue", "Yellow" );
		MyButton button3 = new MyButton(Color.white, Color.black, "Day", "Night" );
		MyButton button4 = new MyButton(Color.orange, Color.cyan, "Orange", "Cyan" );
		MyButton button5 = new MyButton(Color.pink, Color.gray , "Run", "Walk" );
		MyButton button6 = new MyButton(Color.DARK_GRAY , Color.MAGENTA, "Color1", "Color2" );

		//Add buttons to the buttonPanel
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		
		container.add(buttonPanel, BorderLayout.WEST);
		
		//Makes the panel fixed, (it doesnt change when a button changes its text)
		buttonPanel.setPreferredSize(new Dimension(200, 200));
		buttonPanel.setMinimumSize(new Dimension(200, 200));
		buttonPanel.setMaximumSize(new Dimension(200, 200));
		
		//Panel containing a label
        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(color);
        
        //A label and some settings
        JLabel label = new JLabel("Uppgift 4B");
		label.setFont(new Font("Serif", Font.PLAIN, 36));
		label.setForeground(Color.orange);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    labelPanel.add(label);
        
	    //Adding the labelPanel to the contentPane
	    container.add(labelPanel, BorderLayout.CENTER);
                
        //"The pack method sizes the frame so that all its contents are at or above their preferred sizes"
        pack();
        
		//Centers Frame
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
	public static void main(String[] args){
		LabFrame frame = new LabFrame();
		frame.setVisible(true);
	}

	
}
