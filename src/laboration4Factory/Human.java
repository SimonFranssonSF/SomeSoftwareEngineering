package laboration4Factory;
// Om nast sista siffran ar udda sa ska en instans av Man returneras, om den �r jamn returneras ett objekt av Woman.

public abstract class Human{
	String personNummer;
	String namn;
	
	  Human(String namn, String pnr){
		this.namn = namn;
		this.personNummer = pnr;
	}
	
	public static Human create(String namn, String pnr){
		Human human;
		if(((Character.getNumericValue(pnr.charAt(9))) & 1) == 0){
    	   //nast sista siffran i personnummret ar jamn sa det ar en kvinna
    	   human = new Woman(namn, pnr);
    	}else{
    	   human = new Man(namn, pnr);
       }
		return human;
    }
	
	public abstract String toString();
}
