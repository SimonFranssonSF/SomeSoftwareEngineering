package laboration7;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class FBstack extends JPanel implements ActionListener{
	List<String> pages = new ArrayList<String>();;
	int currentPagePointer;
	WebReader wr;
	JEditorPane addressField;
	LinkTable linkTable;
	static Object[] columnNames = {"WEBBADRESS", "BENÄMNING"};
	static Object[][] tableData;
	JButton forward;
	JButton back;
	private static ImageIcon[] bilder ={new ImageIcon("src/resources/n.png"),new ImageIcon("src/resources/b.png"),new ImageIcon("src/resources/f.png")} ;
	
	public FBstack(WebReader wr, JEditorPane JEP, LinkTable linkTable) {
		this.wr = wr;
		this.addressField = JEP;
		this.linkTable = linkTable;
		forward = new JButton((ImageIcon)bilder[0]);
		forward.repaint();
		forward.setCursor(new Cursor(Cursor.HAND_CURSOR));
		forward.setActionCommand("Forward");
		//forward.setIcon();
		forward.setPreferredSize(new Dimension(50, 50));
		forward.addActionListener(this);
		back = new JButton((ImageIcon)bilder[0]);
		back.setActionCommand("Back");
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setPreferredSize(new Dimension(60, 60));
		back.addActionListener(this);
		this.setLayout(new GridLayout(1,2,2,2));
		this.add(back);
		this.add(forward);
		pages.add("firstPage");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*for(int i = 0; i < pages.size(); i++){
			System.out.println(pages.get(i));
		}
		System.out.println(currentPagePointer);*/
		if(pages != null && e.getActionCommand().equals("Forward") && currentPagePointer < pages.size()-1){
			System.out.println("inne");
			try {
				System.out.println("inne");
				currentPagePointer += 1;
				wr.showPage(pages.get(currentPagePointer));
				addressField.setText(pages.get(currentPagePointer));
				tableData = Links.getLinks(pages.get(currentPagePointer));
				linkTable.setModel(new DefaultTableModel(tableData, columnNames));
				
			} catch (IOException | BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(pages != null && e.getActionCommand().equals("Back") && currentPagePointer > 0){
			System.out.println("inne");
			try {
				currentPagePointer -= 1;
				if(pages.get(currentPagePointer).equals("firstPage")){
					HTMLEditorKit hTMLEditorKit = new HTMLEditorKit();
					HTMLDocument doc = (HTMLDocument) hTMLEditorKit.createDefaultDocument();
					wr.setDocument(doc);
					addressField.setText("");
					tableData = new Object[50][50];
					linkTable.setModel(new DefaultTableModel(tableData, columnNames));
				}else{
					wr.showPage(pages.get(currentPagePointer));
					addressField.setText(pages.get(currentPagePointer));
					tableData = Links.getLinks(pages.get(currentPagePointer));
					linkTable.setModel(new DefaultTableModel(tableData, columnNames));
				}
				
			} catch (IOException | BadLocationException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println(pages);
		System.out.println(currentPagePointer);
		if(currentPagePointer < pages.size()-1){
			forward.setIcon(bilder[2]);
			forward.repaint();
		}else{
			forward.setIcon(bilder[0]);
			forward.repaint();
		}
		if(currentPagePointer > 0){
			back.setIcon(bilder[1]);
			back.repaint();
		}else{
			back.setIcon(bilder[0]);
			back.repaint();
		}
	}

	public void addUrl(String url) {
		back.setIcon(bilder[1]);
		back.repaint();
		forward.setIcon(bilder[0]);
		forward.repaint();
		if(currentPagePointer < pages.size()-1){
			pages = new ArrayList<String>(pages.subList(0, currentPagePointer+1));
		}
		pages.add(url);
		currentPagePointer = pages.size()-1;
	}
}
