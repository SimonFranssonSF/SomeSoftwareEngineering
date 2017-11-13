package laboration2U3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Square extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i;
	int j;
	
	public Square(String title, Color color){
		setText(title);
		setPreferredSize(new Dimension(100, 100));
		setFont(new Font("Arial", Font.BOLD, 35));
		setBackground(color);
		setOpaque(true);
		setBorderPainted(false);
		//setBorderPainted(false);
	}
	
	public void setIndex(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public int getIndexI(){
		return i;
	}
	
	public int getIndexJ(){
		return j;
	}
	

}
