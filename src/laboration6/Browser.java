package laboration6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Browser extends JFrame {
	
	public Browser() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		//Container
		Container container = this.getContentPane();
		
		//Table East
		JTable table = new JTable(50, 2);
		JScrollPane links = new JScrollPane(table);
		container.add(links, BorderLayout.CENTER);
		
		//JEditorPane North
		JEditorPane JEPNorth = new JEditorPane();
		JEPNorth.setBackground(Color.BLACK);
		container.add(JEPNorth, BorderLayout.NORTH);
		
		//JEditorPane Center
		JEditorPane JEPCenter = new JEditorPane();
		JScrollPane html = new JScrollPane(JEPCenter);
		JEPCenter.setBackground(Color.GRAY);
		container.add(html, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Browser b = new Browser();
	}
}
