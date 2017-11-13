package forelasning7;

import java.util.*;
import java.awt.*;
class VotesModel extends Observable {
    private String[] chocs = {"Neuhaus","Valrhona","Amedei",
		      "Charlemagne","Chocovic","Godiva"};

    private Color[] cols = {Color.cyan,Color.red, Color.blue,
		    Color.magenta,Color.orange,Color.yellow};

    private int n = chocs.length;
    private int [] freqs = new int[n];

    void count(int i) {
	freqs[i]++;   // ***** VotesModel is changed here *****
	change();  
    }

    void change() {
	setChanged();        // method from Observable
	notifyObservers();   // method from Observable
    }

    Color getCol(int i) {
	return cols[i];
    }

    String getChoc(int i) {
	return chocs[i];
    }

    int getFreq(int i){
	return freqs[i];
    }

    int getN () {
	return n;
    }
}
