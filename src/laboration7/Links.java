package laboration7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Links {
	
	public static Object[][] getLinks(String webpage) throws MalformedURLException, IOException, BadLocationException{
		String[][] m = new String[50][2];
		InputStream in = new URL(webpage).openConnection().getInputStream();
		InputStreamReader reader = new InputStreamReader(in, "ISO-8859-1");
		
		//tomt htmldokument
		HTMLEditorKit hTMLEditorKit = new HTMLEditorKit();
		HTMLDocument doc = (HTMLDocument) hTMLEditorKit.createDefaultDocument();
		//encoding ska inte orsaka exceptions
		doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
		//reader, htmldocument, position
		new HTMLEditorKit().read(reader,doc,0);
		
		//iterator på dokumentets a-taggar
		HTMLDocument.Iterator iterator = doc.getIterator(HTML.Tag.A);
		int itr = 0;
		while(iterator.isValid() && itr < 50){
			//Denna tags attribut
			SimpleAttributeSet s = (SimpleAttributeSet)iterator.getAttributes();
			
			//hrefattributets värde
			String link = (String) s.getAttribute(HTML.Attribute.HREF);
			
			//om en href finns
			if(link != null){
				String[] protocols = {"http://", "ftp://", "https://"};
				boolean contains = false;
				//kollar om protokoll finns i url eller inte
				for(int i =0; i < protocols.length; i++){
					if(link.toLowerCase().contains(protocols[i].toLowerCase())){
						contains = true;
					}
				}
				//om det inte finns så kan det vara en relativ länk. Appenda href-value till denna sidans address.
				if(!contains){
					link = webpage + link;
				}
				//Lägg in href-värdet i kolumn 1 i matrisen
				m[itr][0] = link;
				int startOffset = iterator.getStartOffset();
				int endOffset = iterator.getEndOffset();
				//hämta data  mellan start och sluttagg
				String content = doc.getText(startOffset, endOffset-startOffset);
				//lägg in denna data i kolumn 2
				m[itr][1] = content;
				itr++;
			}
			iterator.next();
		}
		return m;
	}
	

}
