package forelasning1;
class Spelkort {
	//Instansvariabler
	String farg;
    int valor;
    
    //Konstruktor
    Spelkort (String f, int v) {
    	farg = f;
    	valor = v;
    }

    //Visa text-utseende f�r objekt
    public String toString () {
    	String valorString;
    	if (valor == 1)
    		valorString = specvalor[0]; // ESS
    	else if (valor >=2 && valor <=10)
    		valorString = "" + valor;   // 2..10
    	else
    		valorString = specvalor[valor - 10]; // KNEKT,DAM,KUNG
    	return farg + " " + valorString;
    }

    // ********************************************************
    // * Den del av klassen som beskriver ett Spelkort-objekt *
    // * �r ovanf�r. Nedanf�r finns static-delen av klassen   *
    // * som existerar OBEROENDE av eventuella objekt.        *
    // ********************************************************

    //KlassVariabel
    static String[] specvalor = {"ESS", "KNEKT", "DAM", "KUNG"};
    
    // main - metod som testar Spelkort skulle mycket v�l kunna ligga h�r
}