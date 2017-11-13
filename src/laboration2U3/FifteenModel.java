package laboration2U3;

import laboration2.Boardgame;

public class FifteenModel implements Boardgame{
	 // Implementera Boardgame-metoderna
	 // Deklarera variabler och �vriga metoder som ni anser beh�vs
	 // som beh�vs f�r ett femtonspel
	 private String currentMessage = "No message yet";
	 private String[][] status;  // spelplanen
	 private int iemp, jemp;                        // index till den tomma rutan
	
	//nxn spelbrade 
	public FifteenModel(int n){
		status = new String[n][n];
		prepareBoard(n);
		currentMessage = "Welcome";
	} 
	@Override
	public boolean move(int i, int j) {
		// TODO Auto-generated method stub
		boolean legalMove = legalMove(i,j);
		
		if(legalMove == true){
			status[iemp][jemp] = status[i][j];
			currentMessage = "<html>You moved brick number " + getStatus(i,j) + " <br>From position (row, col): "  + i + ", " + j + " <br>To position (row, col): "  + iemp + ", " +  jemp + "</html>";
			checkIfWon();
			status[i][j] = null;
			iemp = i;
			jemp = j;
			return true;
		}else{
			currentMessage = "Illegal move";
			return false;
		}
		
	}

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
		//  Spelets st�llning uppdateras d� inuti klassen och kan avl�sas position f�r position genom metoden getStatus(i,j)
		
		return status[i][j];
	}

	@Override
	public String getMessage() {
		// Anrop av getMessage() ger ett aktuellt meddelande som s�ger om draget gick bra eller ej. 
		// TODO Auto-generated method stub
		return currentMessage;
	}
	
	//Placerar ut brickorna p� r�tt plats och k�r sedan slumpm�ssiga anrop till move(i,j)
	private void prepareBoard(int n){
		int bricka = 1;
		for(int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (bricka != n*n){
					status[i][j] = "" + bricka;
					bricka++;
				}else{System.out.println("hej");}
				
			}
		}
		
		iemp = status.length-1;
		jemp = status.length-1;

		String possibleDirections = "NW";
		
		//for loop som gor 256 random flyttningar, beroende pa vart den svarta rutan befinner sig sa kan den flytta till olika positioner. 
		//forsta gangen den gar in i far loopen sa ligger den svarta rutan i nedre hogra hornet. (status.length-1, status.length-1)
		for(int i = 0; i < 256; i++){
			if(iemp >= 1 && iemp <= status.length-2 && jemp >=1 && jemp <= status[0].length-2){
				//can move in all directions
				possibleDirections = "NWSE";
			}else if(iemp >= 1 && iemp <= status.length-2 && jemp == status.length-1){
				//can move in direction North, South and West.
				possibleDirections = "NSW";
			}else if(iemp == 0 && jemp == status.length-1){
				//can move in direction South and West.
				possibleDirections = "SW";
			}else if(iemp == status.length-1 && jemp == status.length-1){
				// can move in direction North and West
				possibleDirections = "NW";
			}else if(iemp == status.length-1 && jemp == 0){
				// can move in direction East and North
				possibleDirections = "EN";
			}else if(iemp == 0 && jemp == 0){
				// can move in direction East and South
				possibleDirections = "ES";
			}else if(iemp >= 1 && iemp <= status.length-2 && jemp == 0){
				// can move in direction North, South, East
				possibleDirections = "NSE";
			}else if(jemp >= 1 && jemp <= status[0].length-2 && iemp == 0){
				// can move in direction South, west and east
				possibleDirections = "SWE";
			}else if(jemp >= 1 && jemp <= status[0].length-2 && iemp == status.length-1){
				// can move in direction North, west and east
				possibleDirections = "NWE";
			}else{
				possibleDirections = "Something went terribly wrong";
			}
			int randomIndex = 0 + (int)(Math.random() * ((possibleDirections.length()-1 - 0) + 1));
			String randomDirection = Character.toString(possibleDirections.charAt(randomIndex));
			
			switch(randomDirection){
				case "N": moveNorth(); break;
				case "S": moveSouth(); break;
				case "W": moveWest(); break;
				case "E": moveEast(); break;
			}
		}
	}
	
	private void moveNorth(){
		move(iemp-1,jemp);
	}
	private void moveSouth(){
		move(iemp+1,jemp);
	}
	private void moveWest(){
		move(iemp,jemp-1);
		}
	private void moveEast(){
		move(iemp,jemp+1);
	}
	
	// kollar om det ar ett lagligt move
	private boolean legalMove(int i, int j){
		if(i > status.length || j > status[0].length){
			return false;
		}
		if(iemp-i == 1 && jemp == j){
			return true;
		}else if(iemp == i && jemp-j == 1){
			return true;
		}else if (iemp-i == -1 && jemp == j){
			return true;
		}else if (iemp == i && jemp-j == -1){
			return true;
		}else{
			return false;
		}
	}
	//kollar om liraren vunnit
	private boolean checkIfWon(){
		int counter = 1;
		boolean won = true;
		for(int i = 0; i < status.length; i++){
			for (int j = 0; j < status.length; j++){
				String brickNr = status[i][j];
				if(Integer.parseInt(brickNr) != counter && counter != status.length*status.length){
					return false;
				}
				counter++;
			}
		}
		if (won == true){
			currentMessage = "Congratulations, you won!";
		}
		return won;
	}
}
