package laboration4Composite;

public abstract class Component {
	protected String prylnamn; //Resvaska, necessar, pase etc
	protected double vikt;
	
	Component(String prylnamn, double vikt){
		this.prylnamn = prylnamn;
		this.vikt = vikt;
	}
	
	public abstract double getWeight();
	public abstract String toString();
}
