package forelasning1;
class TestaSpelkort {
    public static void main (String[] arg) {
    //Lokala variabler
	String[] farger = {"Hj�rter", "Spader", "Ruter", "Kl�ver"};
	Spelkort[] kortlek = new Spelkort[52];
	
	// Skapa korten
	int kortnr = 0;
	for (String farg : farger)
	    for (int valor = 1; valor<=13; valor++)
	    	kortlek[kortnr++] = new Spelkort(farg, valor);
	
	// Visa korten:
	for (Spelkort spk : kortlek)
	    System.out.println(spk);
    }
}