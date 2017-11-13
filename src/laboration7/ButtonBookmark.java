package laboration7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonBookmark extends JButton{
	
	public ButtonBookmark(String s) {
		super(s);
		this.setPreferredSize(new Dimension(100, 40));
		 this.setMargin(new Insets(0,0,0,0));
	     //button.setContentAreaFilled(false);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		 this.setBorder(raisedbevel);
		 this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 this.setIconTextGap(0);
		 this.setOpaque(true);
		 this.addMouseListener(new MouseAdapter() {
	         private boolean mousePressed = false;
				public void mousePressed(MouseEvent e) throws NullPointerException{
	             mousePressed = true;
	             new Thread() {
	                 public void run() {
	                     while (mousePressed) {
	                    	 ButtonBookmark.this.setBackground(Color.gray);
	                     }
	                 } 
	             }.start();  
	         }
	         public void mouseReleased(MouseEvent e) {
	             mousePressed = false;
	             ButtonBookmark.this.setBackground(new JButton().getBackground());
	         }
	     });
	}
	 
}
