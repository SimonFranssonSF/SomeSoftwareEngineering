package forelasning3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class PanelDemo2 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PanelDemo2(){
		setSize(400,200);
		
		JPanel northpanel = new JPanel();
		northpanel.setLayout(new GridLayout(1,3));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,3));
		buttons.add(new JButton("1"));
		buttons.add(new JButton("2"));
		buttons.add(new JButton("3"));
		
		northpanel.add(buttons);
		
		northpanel.add(new TextField("Här kan man läsa och skriva"));
		
		add(northpanel, BorderLayout.NORTH);
		
		JLabel test = new JLabel("$");
		test.setOpaque(true);
		test.setBackground(Color.yellow);
		add(test, BorderLayout.WEST);
		add(new JScrollBar(), BorderLayout.EAST);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PanelDemo2();
	}

}
