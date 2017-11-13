package laboration4Iterator;

import java.util.ArrayList;

public abstract class Component {
	protected String prylnamn; 
	protected double vikt;
	ArrayList<Component> components = new ArrayList<Component>();
	
	Component(String prylnamn, double vikt){
		this.prylnamn = prylnamn;
		this.vikt = vikt;
	}
	
	public abstract double getWeight();
	public abstract String toString();
	
	//Skulle inte ha varit har men anvander den for att visa bfs och dfs 
	public String getMembers(){
		return prylnamn + " vikt: " + vikt;
	}
}
