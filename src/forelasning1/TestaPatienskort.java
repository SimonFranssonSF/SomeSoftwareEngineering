package forelasning1;
class TestaPatienskort {
	public static void main (String[] arg) {
		String[] färger = {"Hj�rter", "Spader", "Ruter", "Kl�ver"};
	
		// Skapa vektor med plats for 52 Patienskort.
		Patienskort [] kortlek = new Patienskort [52];
	
		// Skapa korten
		int kortnr = 0;
		for (String farg : färger)
			for (int valor = 1; valor <= 13; valor++)
				kortlek[kortnr++] = new Patienskort(farg, valor, true);
	
		
		// Visa korten
		for(Patienskort pk:kortlek)
			System.out.println(pk);
	}
}