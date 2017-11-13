package laboration2U3;

import laboration2.Boardgame;

public class TicTacToeModel implements Boardgame {

	private String currentMessage = "No message yet";
	private String[][] status;  // spelplanen
	private int numberOfPlays = 0;
	private int ibrick = -1, jbrick = -1;  //bricka att flytta
	private String activePlayer = "X"; //Dennes tur att spela
	private String inactivePlayer = "O"; //Dennes tur att spela �r det ej
	private boolean gameOver = false;
	
	public TicTacToeModel(int n){
		status = new String[n][n];
		currentMessage = "<html>Welcome, <br><br> Player X starts</html>";
	}
	
	@Override
	public boolean move(int i, int j) {
		//Om spelet ar over och en vinnare finns sa resetter den bradet pa nasta "move"
		if(gameOver == true){
			gameOver = false;
			prepareBoard();
			return true;
		}
		
		//satter vem som ar active och inactive player (vem det ar som spelar)
		if((numberOfPlays & 1) == 0){
			activePlayer = "X";
			inactivePlayer = "O";
		}else{
			activePlayer = "O";
			inactivePlayer = "X";
		}
		
		//Utplaceringsfasen om number of plays �r mindre an 6. Annars flyttningfasen.
		if(numberOfPlays < 6){
			//Placerar ut en x-bricka eller en o-bricka beroende p� om number of plays �r udda eller inte, kollar �ven s� att den klickade platsen �r tom.
			if(status[i][j] == null){
				status[i][j] = activePlayer;
				numberOfPlays++;
				currentMessage = "<html>Player "+ activePlayer +" put an brick <br> on position (row, col) " + i + ", " + j + ". <br><br>It's player " + inactivePlayer + "'s turn.</html>";
				if(checkIfWon() == true){
					gameOver = true;
				}
				return true;
			}else{
				currentMessage = "Illegal move";
				return false;
			}
		//Flyttningsfasen
		}else{
			//Kollar att brickan som ska flyttas �r korrekt och att den flyttas till en till�ten position.
			if(legalBrick(i,j) == true && legalMove(i,j) == true){
				status[i][j] = activePlayer;
				status[ibrick][jbrick] = null;
				currentMessage = "<html>Player "+activePlayer+" moved brick <br> on position (row, col) " + ibrick + ", " + ibrick + "<br>To position "+i +"," + j+". <br><br>It's player "+inactivePlayer+"'s turn.</html>";
				ibrick = -1;
				jbrick = -1;
				numberOfPlays++;
				if(checkIfWon() == true){
					gameOver = true;
				}
				return true;
			}else{
				return false;
			}
		}
		
		
	}

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
		return status[i][j];
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return currentMessage;
	}
	
	private boolean legalMove(int i, int j){
			//returnar alltid false om den klickade rutan inte ar null, detta gor att vi kan "valja" en bricka
			if(status[i][j] != null)
				return false;
			
			if(i > status.length || j > status[0].length){
				return false;
			}
			if(ibrick-i == 1 && jbrick == j){
				return true;
			}else if(ibrick == i && jbrick-j == 1){
				return true;
			}else if (ibrick-i == -1 && jbrick == j){
				return true;
			}else if (ibrick == i && jbrick-j == -1){
				return true;
			}else if(i == ibrick-1 && j == jbrick-1){
				return true;
			}else if(i == ibrick-1 && j == jbrick+1){
				return true;
			}else if(i == ibrick+1 && j == jbrick-1){
				return true;
			}else if(i == ibrick+1 && j == jbrick+1){
				return true;
			}else{
				currentMessage = "<html>Illegal move, <br><br> Click on the square <br> you want to move brick " + ibrick + ", " + jbrick + " <br><br>It's player " + activePlayer + "'s turn</html>";
				return false;
			}
	}
	private boolean legalBrick(int i, int j){
		//ibrick och jbrick �r positionen f�r den bricka som spelaren vill flytta, om ibrich, jbrick inte �r vald:
		if(ibrick == -1 && jbrick == -1){
			//Kollar om r�tt spelare har markerat en bricka som tillh�r honom s�tter is�fall ibrick,jbrick till positionen f�r den bricka som ska flyttas.
			if(status[i][j] != null && status[i][j].equals(activePlayer)){
				ibrick = i;
				jbrick = j;
				currentMessage = "<html>Click on the square <br> you want to move brick " + i + ", " + j + " </html>"; 
				return true;
			}else {
				System.out.println("hej6");
				currentMessage = "<html>Select an brick marked " + activePlayer + " <br> then click an empty  <br> square you want to move, <br><br> It's player "+activePlayer+"'s turn</html>";
				return false;
			}
		}
		//Om jbrick och ibrick �r vald men spelaren �ndrar sig och vill flytta en annan bricka.
		if(status[i][j] != null && status[i][j].equals(activePlayer)){
			currentMessage = "<html>Click on the square <br> you want to move brick " + i + ", " + j + "</html>"; 
			ibrick = i;
			jbrick = j;
			return  true;
		}
		System.out.println("hej");
		return true;
	}
	
	private boolean checkIfWon(){
		//kollar rader
		
			for(int i = 0; i < status.length; i++){
				for (int j = 0; j < status.length-2; j++){
					try{
					if(status[i][j].equals(status[i][j+1]) && status[i][j+1].equals(status[i][j+2]) && status[i][j].equals(status[i][j+2])){
						currentMessage = "<html>Player "+activePlayer + " Win<br><br> Click the board to play again</html>";
						System.out.println("hej1jollo");

						return true;
					}}catch(NullPointerException e){}	
				}
			}
		
		
		//kollar kolumner
			for(int i = 0; i < status.length; i++){
				for (int j = 0; j < status.length-2; j++){
					System.out.print("hello");
					try{
					if(status[j][i].equals(status[j+1][i]) && status[j+1][i].equals(status[j+2][i]) && status[j][i].equals(status[j+2][i])){
						currentMessage = "<html>Player "+activePlayer + " Win<br><br> Click the board to play again</html>";
						System.out.println("hej2jollo");
						return true;
					}}catch(NullPointerException e){}	
				}
			}
		
		
		//Kollar diagonaler
		try{
			if(status[0][0].equals(status[1][1]) && status[0][0].equals(status[2][2])){
				currentMessage = "<html>Player "+activePlayer + " Win<br><br> Click the board to play again</html>";
				return true;
			}
		}catch (NullPointerException e){}
		try{
			if(status[2][0].equals(status[1][1]) && status[1][1].equals(status[0][2])){
				currentMessage = "<html>Player "+activePlayer + " Win<br><br> Click the board to play again</html>";
				return true;
			}
		}catch (NullPointerException e){}
		
		return false;
		
	}
	private void prepareBoard(){
		numberOfPlays = 0;
		ibrick = -1;
		jbrick = -1;
		activePlayer = "X";
		currentMessage = "Player X starts";
		for(int i = 0; i < status.length; i ++){
			for(int j = 0; j < status.length; j ++){
				status[i][j] = null;
			}
		}
	}
}
