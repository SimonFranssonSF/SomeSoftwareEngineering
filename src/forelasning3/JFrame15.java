package forelasning3;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrame15 extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b = new JButton("Press to change background color");
	Container cc;
	Color[] colors = {Color.yellow, Color.cyan, Color.magenta, Color.blue, Color.black};
	int colnr;
	
	JFrame15(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program when frame closed
		setLayout(new FlowLayout());
		cc = getContentPane();
		setSize(300,200);
		cc.setBackground(Color.green);
		b.setBackground(Color.yellow);
		cc.add(b);
		b.addActionListener(this);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(colnr%colors.length);
		cc.setBackground(colors[colnr++%colors.length]);
	}
	
	public static void main(String[] args){
		new JFrame15();
	}

}
