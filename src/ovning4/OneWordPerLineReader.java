package ovning4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneWordPerLineReader implements FileReader{
	
    public OneWordPerLineReader() {
	//read(new Scanner(System.in));
    }

    @Override
    public List<String> read(Scanner sc) {
	ArrayList<String> words = new ArrayList<String>();
	while(sc.hasNext()){
	    words.add(sc.nextLine());
	}
	return words;
    }
	
    public static void main(String[] args) {
	new OneWordPerLineReader();
    }
}