package laboration7;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonRemoveBookmark extends JButton{
	public ButtonRemoveBookmark() {
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		this.setIcon(new ImageIcon("src/resources/n2.png"));
		this.setPreferredSize(new Dimension(40, 40));
		this.setMargin(new Insets(0, 0, 0, 0));
        //removeButton.setContentAreaFilled(false);
		this.setBorder(raisedbevel);
		this.setIconTextGap(8);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
}
