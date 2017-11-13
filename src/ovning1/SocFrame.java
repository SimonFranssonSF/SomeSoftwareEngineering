package ovning1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SocFrame {

    public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setVisible(true);
	frame.setSize(100,100);
		
	SocNumbComp soc = new SocNumbComp();
	frame.add(soc,BorderLayout.NORTH);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
    }
}