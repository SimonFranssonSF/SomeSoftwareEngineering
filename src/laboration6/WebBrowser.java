package laboration6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

public class WebBrowser extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WebReader WRCenter;
	static Object[] columnNames = {"WEBBADRESS", "BENÄMNING"};
	static Object[][] tableData;
	
	public WebBrowser() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		//Sätter size på JFrame
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen.width, screen.height);

		Container container = this.getContentPane();
		
		//LinkTable East
		LinkTable table = new LinkTable();
		JScrollPane links = new JScrollPane(table);
		container.add(links, BorderLayout.EAST);
		
		//JEditorPane North
		JEditorPane JEPNorth = new JEditorPane();
		//anonym klass med keylistener som aktiveras med tangenttryck "enter".
		JEPNorth.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode() == KeyEvent.VK_ENTER){
					//Kör metod showPage på WRCenter, skickar med denna JFrame (webBrowser) och texten i JEPNorth.
					//Visar dialogruta om felaktig url eller att sidan inte kan hittas
					try {
						WRCenter.showPage(JEPNorth.getText());
						tableData = Links.getLinks(JEPNorth.getText());
						table.setModel(new DefaultTableModel(tableData, columnNames));
					} catch (IOException | BadLocationException e) {
						JOptionPane.showMessageDialog(WebBrowser.this, "Page "+ JEPNorth.getText() +" was not found.");
						System.out.println("TableData could not be generated");
					}
				//Förhindrar newline när man trycker enter, (dom gamla keybindingsen kommer inte att köras)
				ke.consume();
				}
			}
		});
		container.add(JEPNorth, BorderLayout.NORTH);
		
		//JEditorPane Center
		WRCenter = new WebReader();
		JScrollPane html = new JScrollPane(WRCenter);
		WRCenter.setContentType("text/html;charset=ISO-8859-1");
		WRCenter.addHyperlinkListener(new HyperlinkListener(){
			public void hyperlinkUpdate(HyperlinkEvent e){
				//om hyperlink är klickad
				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					URL url = e.getURL();
					String urlString = url.toString();
					try{
						WRCenter.showPage(urlString);
						JEPNorth.setText(urlString);
						tableData = Links.getLinks(JEPNorth.getText());
						table.setModel(new DefaultTableModel(tableData, columnNames));
					}catch(IOException|BadLocationException e1){
						JOptionPane.showMessageDialog(WebBrowser.this, "Page "+ JEPNorth.getText() +" was not found.");
					}
				}
			}
		});
		container.add(html, BorderLayout.CENTER);
		
		
		//this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		WebBrowser wb = new WebBrowser();
	}

	
}
