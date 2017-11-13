package laboration4Factory;

public class Man extends Human {
	
	Man(String namn, String pnr){
		super(namn, pnr);
	}

	@Override
	public String toString() {
		return "Namn: " + namn + " Kon: Man " + "Pnr: " + personNummer;
	}
}
