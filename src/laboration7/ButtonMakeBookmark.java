package laboration7;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonMakeBookmark extends JButton{
	public ButtonMakeBookmark() {
		this.setIcon(new ImageIcon("src/resources/star.png"));
		this.setPreferredSize(new Dimension(60, 60));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
