package forelasning3;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrame15Anonymous extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b = new JButton("Press to change background color");
	Container cc;
	Color[] colors = {Color.yellow, Color.cyan, Color.magenta, Color.blue, Color.black};
	int colnr; 
	
	JFrame15Anonymous(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		cc = getContentPane();
		setSize(200, 300);
		cc.setBackground(Color.yellow);
		b.setBackground(Color.green);
		cc.add(b);
		b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					cc.setBackground(colors[colnr++%colors.length]);
				}
			});
		setVisible(true);
	}
}
