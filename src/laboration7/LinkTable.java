package laboration7;

import java.awt.Color;

import javax.swing.JTable;

public class LinkTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Object[][] data = new Object[50][50];
	static String[] columnNames = {"WEBBADRESS", "BENÄMNING"};

	
	public LinkTable() {
		super(data, columnNames);
		this.setGridColor(Color.GRAY);
	}
}
