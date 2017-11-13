package laboration4Factory;

public class Woman extends Human {
	Woman(String namn, String pnr){
		super(namn, pnr);
	}

	@Override
	public String toString() {
		return "Namn: " + namn + " Kon: Kvinna " + " Pnr: " + personNummer;
	}
}
