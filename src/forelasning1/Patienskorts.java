package forelasning1;
//Patienskort �rver fr�n Spelkort
class Patienskort extends Spelkort {
	//Instans varibel
    boolean rattvand;

    //Konstruktor, Konstruktorn i superklassen Spelkort anropas
    //Anrop av superklassens konstruktor g�rs alltid f�rst i konstruktorn i en subklass
    Patienskort (String f, int v, boolean rv) {
    	super(f,v);
    	rattvand = rv;
    }
    
    //Metod f�r att v�nda p� kortet
    void vand () {
    	rattvand = !rattvand;
    }
    
    //Metod f�r att kunna skriva ut objektet
    public String toString() {
		if (rattvand)
		    return super.toString();
		else
		    return "BAKSIDA";
	}
}