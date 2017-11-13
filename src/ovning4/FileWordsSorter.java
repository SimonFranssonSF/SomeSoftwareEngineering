package ovning4;

/**
 * FileWordsSorter.java
 */
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class FileWordsSorter {

    private FileReader reader;
    private JFileChooser chooser;

    public FileWordsSorter(FileReader reader) {
	this.reader = reader;
	this.chooser = new JFileChooser(".");
    }

    public void sortFile() {
	int result = chooser.showOpenDialog(null);
	if (result == JFileChooser.APPROVE_OPTION) {
	    File theFile = chooser.getSelectedFile();
	     	     
	    try {
		List<String> theList = reader.read(new Scanner(theFile));
		Collator coll = Collator.getInstance(new Locale("sv", "SE"));
		Collections.sort(theList, coll);
		printList(theList);
	    } catch (FileNotFoundException ex) {
		System.out.println("File was not found");
	    }
	}
    }

    private static void printList (List<String> list) {
	for (String s : list) {
	    System.out.println(s);
	}
    }

    // För att behålla terminal/DOS-fönster öppet
    /*
    public static void pressAnyKey() {
	BufferedReader input = new BufferedReader
	    (new InputStreamReader(System.in));
	System.out.print("Press any key...");
	try {
	    input.readLine();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    */
    
    public static void main(String[] args) {
	//FileWordsSorter f = new FileWordsSorter(new DelimitedReader());
	FileWordsSorter f = new FileWordsSorter(new OneWordPerLineReader());
	f.sortFile();
	//pressAnyKey();
    }
}
