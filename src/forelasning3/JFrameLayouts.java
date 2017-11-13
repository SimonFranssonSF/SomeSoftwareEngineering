package forelasning3;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameLayouts extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrameLayouts(String name){
		super(name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		Container cc = getContentPane();
		cc.setBackground(new Color(210, 210, 255));
		
		//setLayout(new FlowLayout());
		setLayout(new GridLayout(2,2));
		//setLayout(new BorderLayout());
		
		JButton b = new JButton("Tryck på mig");
		b.setBackground(Color.magenta);
		b.setOpaque(true);
		add(b);
		
		JLabel la = new JLabel("Cheaton");
		la.setBackground(Color.white);
		la.setOpaque(true);
		add(la);
		
		JTextField tf = new JTextField(5);
		tf.setBackground(Color.yellow);
		add(tf);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new JFrameLayouts("Mitt fönster");
	}

}
