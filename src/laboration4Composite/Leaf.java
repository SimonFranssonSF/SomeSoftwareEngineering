package laboration4Composite;
//lov/pryl och child till behallare

public class Leaf extends Component{

	Leaf(String prylnamn, double vikt) {
		super(prylnamn, vikt);
		// TODO Auto-generated constructor stub
	}
	
	public double getWeight(){
		//returnerar prylens vikt
		return vikt;
	}
	
	public String toString(){
		//returnerar prylnamnet
		return prylnamn;
	}
	
}
