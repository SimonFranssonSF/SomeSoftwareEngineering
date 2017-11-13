package laboration2U3;

import laboration2.Boardgame;

public class MockObjectModel implements Boardgame{
	private String currentMessage = "No message yet";
	private String[][] status;  // spelplanen
	
	public MockObjectModel(int n){
		status = new String[n][n];
		currentMessage = "Welcome";
	}
	
	@Override
	public boolean move(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return currentMessage;
	}

}
