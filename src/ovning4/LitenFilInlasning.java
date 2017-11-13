package ovning4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LitenFilInlasning {
    private static Scanner sc;

	public static void main(String[] args) {
	boolean ok = false;
	System.out.println("Skriv filnamn");
	sc = new Scanner(System.in);
		
	Scanner fil = null;
	while(!ok){
	    String filnamn = sc.nextLine();
	    try{
		fil = new Scanner(new File("src/resources/" + filnamn));
		ok = true;
	    }catch(IOException e){
		System.out.println("Filen finns ej, nytt filnamn: ");
	    }

	}
	while(fil.hasNext()){
	    System.out.println(fil.nextLine());
	}
	System.out.println("Klar");
    }
}
