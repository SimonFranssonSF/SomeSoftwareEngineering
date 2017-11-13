package laboration7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

public class WebBrowser extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WebReader WRCenter;
	static Object[] columnNames = {"WEBBADRESS", "BENÄMNING"};
	static Object[][] tableData;
	FBstack fbButtons;
	Bookmarks bookmarkPanel;
	JPanel northJP;
	JEditorPane addressBar;
	LinkTable table;
	
	public WebBrowser() throws IOException {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen.width, screen.height);

		Container container = this.getContentPane();
		
		//LinkTable East i frame
		table = new LinkTable();
		JScrollPane links = new JScrollPane(table);
		container.add(links, BorderLayout.EAST);
		
		//JEditorPane->Jpanel wrapper->Jpanel actions-> North i JFrame
		Border roundedBorder = new LineBorder(Color.BLACK, 5, true);
		addressBar = new JEditorPane();
		addressBar.setFont(new Font("Serif", Font.PLAIN, 40));
		addressBar.setBorder(roundedBorder);
		//anonym klass med keylistener som aktiveras med tangenttryck "enter".
		addressBar.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode() == KeyEvent.VK_ENTER){
					//Kör metod showPage på WRCenter, skickar med denna JFrame (webBrowser) och texten i addressBar.
					//Visar dialogruta om felaktig url eller att sidan inte kan hittas
					try {
						connect(addressBar.getText());
					} catch (IOException | BadLocationException e) {
						JOptionPane.showMessageDialog(WebBrowser.this, "Page "+ addressBar.getText() +" was not found.");
						System.out.println("TableData could not be generated");
					}
				//Förhindrar newline när man trycker enter, (dom gamla keybindingsen kommer inte att köras)
				ke.consume();
				}
			}
		});
		
		//Jpanel som wrappar adressbar
		JPanel JPurl = new JPanel(new GridLayout());
		JPurl.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPurl.add(addressBar);
		
		
		//Innehåll: Jpanel med fw- och bw buttons, JEditorPane (addressBar/addressfalt), Jbutton Bookmarks 
		JPanel actions = new JPanel();
		actions.setLayout(new BorderLayout());
		ButtonMakeBookmark bookmark = new ButtonMakeBookmark();
		bookmark.addActionListener(this);
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
						connect(urlString);
					}catch(IOException|BadLocationException e1){
						JOptionPane.showMessageDialog(WebBrowser.this, "Page "+ addressBar.getText() +" was not found.");
					}
				}
			}
		});
		//forward backward buttons
		fbButtons = new FBstack(WRCenter, addressBar, table);
		
		actions.add(fbButtons, BorderLayout.WEST);
		actions.add(JPurl, BorderLayout.CENTER);
		actions.add(bookmark, BorderLayout.EAST);
		
		bookmarkPanel = new Bookmarks();
		
		//JPanel North i frame
		northJP = new JPanel();
		northJP.setLayout(new BorderLayout());
		northJP.add(actions, BorderLayout.NORTH);
		northJP.add(bookmarkPanel, BorderLayout.SOUTH);
		container.add(northJP, BorderLayout.NORTH);
		
		
		container.add(html, BorderLayout.CENTER);
		createButtons(); 
		
		//this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(WRCenter.getPage() != null){
			String bookmarkName = JOptionPane.showInputDialog("Name your bookmark for  " + WRCenter.getPage().toString());
			if(bookmarkName != null && bookmarkName != ""){
				try {
					bookmarkPanel.addBookmark(WRCenter.getPage().toString(), bookmarkName);
					bookmarkPanel.readBookmarks();
					createButtons();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	void createButtons() throws NullPointerException{
		bookmarkPanel.setVisible(false);
		bookmarkPanel.removeAll();
		bookmarkPanel.readBookmarks();
		try {
			bookmarkPanel.sortBookmarks();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		bookmarkPanel.add(new JLabel("Bookmarks: "));
		for (String name: bookmarkPanel.bookmarksen.keySet()){
			if(name != null){
            String key = name.toString();
            String value = bookmarkPanel.bookmarksen.get(name).toString();
            ButtonBookmark button = new ButtonBookmark(key);
            button.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){
            		try {
            			connect(value);
					} catch (IOException | BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            });
            button.setActionCommand(value);
            ButtonRemoveBookmark removeButton = new ButtonRemoveBookmark();
            removeButton.setActionCommand(key);
            removeButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						bookmarkPanel.setVisible(false);
						bookmarkPanel.removeBookmark(e.getActionCommand());
						bookmarkPanel = new Bookmarks();
						northJP.add(bookmarkPanel, BorderLayout.SOUTH);
						bookmarkPanel.repaint();
						bookmarkPanel.setVisible(true);
						createButtons();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
            });
            
            BorderLayout f = new BorderLayout();
            f.setHgap(0);
            f.setVgap(0);
            JPanel bms = new JPanel(f);
            bms.add(button, BorderLayout.CENTER);
            bms.add(removeButton,BorderLayout.EAST);
            bookmarkPanel.add(bms);
            }
		}
		bookmarkPanel.validate();
		bookmarkPanel.repaint();
		bookmarkPanel.setVisible(true);
	}
	
	public void connect(String url) throws IOException, BadLocationException{
		WRCenter.showPage(url);
		addressBar.setText(url);
		tableData = Links.getLinks(url);
		table.setModel(new DefaultTableModel(tableData, columnNames));
		fbButtons.addUrl(addressBar.getText());
	}
	
	public static void main(String[] args) throws IOException {
		WebBrowser wb = new WebBrowser();
	}

	
}
