package laboration7;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;

public class Bookmarks extends JPanel{
	TreeMap<String, String> bookmarksen = new TreeMap<String, String>(new BookmarkComp());
	//File file;

	
	public Bookmarks() throws IOException {
		//file = new File("src/resources/", "bookmarks.txt");
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		readBookmarks();
		iterate();
	}
	
	void readBookmarks() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/resources/bookmarks.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String line="";
        String line2="";

        while (line != null && line2 != null) {
            try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				line2 = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(line != null && line2 != null ){
            bookmarksen.put(line,line2);
            }
        }
        try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void iterate() throws NullPointerException{
		
		for (String name: bookmarksen.keySet()){
			//System.out.println(name);
			if(name != null){
            String key = name.toString();
            String value = bookmarksen.get(name).toString();  
            //System.out.println(key + " " + value);  
            }
		}
	}
	
	public void addBookmark(String url, String name) throws IOException{
		BufferedWriter output = new BufferedWriter(new FileWriter(new File("src/resources/", "bookmarks.txt"), true));
		output.append(name);
		output.newLine();
		output.append(url);
		output.newLine();
		output.close();
	}
	
	public void removeBookmark(String name) throws IOException{
		File temp = new File("src/resources/", "temp.txt");
		BufferedReader reader = new BufferedReader(new FileReader("src/resources/bookmarks.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/temp.txt"));

		String lineToRemove = name;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)){
		    	reader.readLine();
		    	continue;	
		    }
		    writer.append(currentLine);
		    writer.newLine();
		}
		writer.close();
        reader.close();
		boolean successful = temp.renameTo(new File("src/resources/bookmarks.txt"));
	}
	
	public void sortBookmarks() throws IOException{
		readBookmarks();
		//bookmarksen.remove(null);
		//System.out.println(bookmarksen.keySet().size());
		
		//sortedBookmarks.putAll(this.bookmarksen);
		
		File temp = new File("src/resources/", "temp.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/temp.txt"));
		for(Map.Entry<String,String> entry : bookmarksen.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  writer.append(key);
			  writer.newLine();
			  writer.append(value);
			  writer.newLine();
		}
		writer.close();
		boolean successful = temp.renameTo(new File("src/resources/bookmarks.txt"));
	}
	
	
}
