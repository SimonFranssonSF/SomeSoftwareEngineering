package laboration2;

public interface Boardgame {
	   public boolean move(int i, int j); //ger false om draget gick bra, annars false 
	   public String getStatus(int i, int j);      
	   public String getMessage();
}

