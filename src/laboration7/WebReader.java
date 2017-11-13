package laboration7;

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;

public class WebReader extends JEditorPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebReader() {
		super();
		this.setEditable(false);
		this.setContentType("text/html;charset=ISO-8859-1");
	}
	
	public void showPage(String url) throws IOException{
		URL urlR = null;
		urlR = new URL(url);
		this.setPage(urlR);
		this.setContentType("text/html;charset=ISO-8859-1");
	}
}
