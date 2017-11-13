package laboration2;

public class FifteenModel implements Boardgame {
	 // Implementera Boardgame-metoderna
	 // Deklarera variabler och övriga metoder som ni anser behövs
	 // som behövs för ett femtonspel
	 private String currentMessage = "No message yet";
	 private String[][] status = new String[4][4];  // spelplanen
	 private int iemp, jemp;                        // index till den tomma rutan
	
	 
	public FifteenModel(){
		prepareBoard();
	} 
	@Override
	public boolean move(int i, int j) {
		// TODO Auto-generated method stub
		boolean legalMove = legalMove(i,j);
		if(legalMove == true){
			status[iemp][jemp] = status[i][j];
			currentMessage = "You moved brick number " + getStatus(i,j) + " at position " + " row: " + i + " col: " + j + " to position " + " row: " + iemp + " col: " +  jemp;
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
		//  Spelets ställning uppdateras då inuti klassen och kan avläsas position för position genom metoden getStatus(i,j)
		
		return status[i][j];
	}

	@Override
	public String getMessage() {
		// Anrop av getMessage() ger ett aktuellt meddelande som säger om draget gick bra eller ej. 
		// TODO Auto-generated method stub
		return currentMessage;
	}
	
	//Placerar ut brickorna på rätt plats och kör sedan slumpmässiga anrop till move(i,j)
	private void prepareBoard(){
		int bricka = 1;
		for(int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if (bricka != 16){
					status[i][j] = "" + bricka;
					bricka++;
				}
				
			}
		}
		
		iemp = 3;
		jemp = 3;

		String possibleDirections = "NW";
		
		for(int i = 0; i < 256; i++){
			if(iemp >= 1 && iemp <= status.length-2 && jemp >=1 && jemp <= status[0].length-2){
				//can move in all directions
				possibleDirections = "NWSE";
			}else if(iemp >= 1 && iemp <= status.length-2 && jemp == 3){
				//can move in direction North, South and West.
				possibleDirections = "NSW";
			}else if(iemp == 0 && jemp == 3){
				//can move in direction South and West.
				possibleDirections = "SW";
			}else if(iemp == 3 && jemp == 3){
				// can move in direction North and West
				possibleDirections = "NW";
			}else if(iemp == 3 && jemp == 0){
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
			}else if(jemp >= 1 && jemp <= status[0].length-2 && iemp == 3){
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
	
	// checks if its a legal move
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
}
