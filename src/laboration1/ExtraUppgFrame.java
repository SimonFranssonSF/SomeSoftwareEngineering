package laboration1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import laboration1.buttons.ExtraUppgKnapp;

public class ExtraUppgFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	//Checks so that there are no InvalidClassException
	private static final long serialVersionUID = 1L;
	
	//Class variable that will contain the buttons that will be added to the ExtraUppgFrame
	static ExtraUppgKnapp[] buttons;
	Container container;
	
	public ExtraUppgFrame(String[] buttonSpecs){
		//Exits java-application when closing the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Some settings for the jFrame
		setTitle("Simon");
		
        //Container for the jframe (lattviktsbehallare med komponenter i)
        container = getContentPane();
        
        //Backgroundcolor for JPanels
        Color color = new Color(0x798795);
        
		//Panel to add the buttons in with setLayout(new GridLayout(rows, col));
        JPanel buttonPanel = new JPanel(new GridLayout(4,4,4,4));
		buttonPanel.setBackground(color);
        
        //First argument which decides number of buttons to create
      	int noButtons = Integer.parseInt(buttonSpecs[0]);
      		
  		//initialize the array class variable to the length of number of buttons
  		buttons = new ExtraUppgKnapp[noButtons];
  		
  		//Creates an ExtraUppgKnapp object at each index of the array class variable buttons, this array is used to change the buttons when actionperformed is triggered. 
  		//Adds an actionListener to the buttons add then adds them to the buttonPanel
  		int j = 1;
  		for(int i = 0; i < noButtons; i++){
  			buttons[i] = new ExtraUppgKnapp(Color.orange, Color.cyan, buttonSpecs[j], buttonSpecs[j+1]);
  			buttons[i].addActionListener(this);
  			buttonPanel.add(buttons[i]);
  			j += 2;
  		}
  		
		//Adding the buttonPanel to the contentPane
		container.add(buttonPanel, BorderLayout.WEST);
		
		//Panel with a label
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(color);
        
	    //A label and some settings
        JLabel label = new JLabel("Extrauppgift");
		label.setFont(new Font("Serif", Font.PLAIN, 36));
		label.setForeground(Color.orange);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    labelPanel.add(label);
	    
	    //Adding the labelPanel to the contentPane
        container.add(labelPanel, BorderLayout.CENTER);
	   
        //"The pack method sizes the frame so that all its contents are at or above their preferred sizes"
        pack();
        
        //Centers the jFrame
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		container.setVisible(false);
		for(ExtraUppgKnapp m : buttons){
			if(!m.equals(e.getSource())){
				m.toggleState();
			}
		}
		container.setVisible(true);
	}
	
	public static void main(String[] args){
		//creates the ExtraUppgFrame, the array buttons is sent to the constructor of ExtraUppgFrame 
		ExtraUppgFrame frame = new ExtraUppgFrame(args);
		
		//Sets the frame visible
		frame.setVisible(true);
	}
}
