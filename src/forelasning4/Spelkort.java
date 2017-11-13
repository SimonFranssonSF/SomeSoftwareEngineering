package forelasning4;

public class Spelkort {
	String farg;
	int valor;
	
	public Spelkort(String f, int v){
		farg = f;
		valor = v;
	}
	
	public boolean equals(Object other){
		if(!(other instanceof Spelkort)){
			return false;
		}
		Spelkort spk = (Spelkort) other;
		return farg.equals(spk.farg) && valor == spk.valor;
	}
	
	public String toString(){
		String valorString;
		if(valor == 1){
			valorString = specValor[0];
		}else if (valor <= 10){
			valorString = " " + valor;
		}else{
			valorString = specValor[valor - 10];
		}
		return farg + " " + valorString;
	}
	
	 /*********************************
     *  Objektmall ovanför           *
     *  Klassgemensamt nedanför      *
     *********************************/
	static String[] specValor = {"ESS","KNÄKT","DAM","KUNG"};
	
	public static void main(String[] args) {
		String[] farger = {"Hjarter", "Spader", "Ruter", "Klover"};
		Spelkort[] kortlek = new Spelkort[52];
		int kortnr=0;
		for (String farg : farger)
		    for (int valor=1; valor<=13; valor++)
			kortlek[kortnr++] = new Spelkort(farg,valor);

		for (Spelkort spk : kortlek)
		    System.out.println(spk);
		System.out.println();
	}

}
