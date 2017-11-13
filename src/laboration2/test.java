package laboration2;

public class test {
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String possibleDirections = "NSEW";
		int randomIndex = 0 + (int)(Math.random() * ((possibleDirections.length()-1 - 0) + 1));
		System.out.println(randomIndex);
		String randomDirection = Character.toString(possibleDirections.charAt(randomIndex));
		switch(randomDirection){
			case "N": System.out.println("N"); break;
			case "S":System.out.println("S"); break;
			case "W": System.out.println("W"); break;
			case "E": System.out.println("E"); break;
		}
	}

}
