package ovning4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelimitedReader implements FileReader {
    String delimiters;
    String exempel = "";
    DelimitedReader() {
	delimiters = "[ ,!?\":;]+";
    }
    
    DelimitedReader(String d){
	delimiters = d;
    }

    @Override
    public List<String> read(Scanner sc) {
	ArrayList<String> words = new ArrayList<String>();
	String line;
	String[] parts;
	while(sc.hasNext()){
	    line = sc.nextLine();
	    if(line.equals(""))
		continue;
	    
	    parts = line.split(delimiters);
	    for(String part: parts){
		if(part.equals(""))
		    continue;
		words.add(part);
	    }
	}
	return words;
    }
}