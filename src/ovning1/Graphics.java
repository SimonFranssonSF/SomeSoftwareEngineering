package ovning1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Graphics implements ActionListener{
	public static void main(String[] args){
		new Graphics();
	}
	
	public Graphics(){
		JFrame frame = new JFrame("Title");
		frame.setVisible(true);
		frame.setSize(100, 100);
		
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		
		frame.add(button1);
		frame.add(button2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setLayout(new GridLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Button 1")){
			System.out.println("Button 1");
		}
	}

}
