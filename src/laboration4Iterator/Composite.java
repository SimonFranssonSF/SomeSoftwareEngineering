package laboration4Iterator;

import java.util.Iterator;

//behallare

public class Composite extends Component implements Iterable<Component> {
	
	Composite(String prylnamn, double vikt) {
		super(prylnamn, vikt);
	}
	
	public void add(Component c){
		components.add(c);
	}
	
	public void remove(Component c){
		components.remove(c);
	}
	
	public void getChild(int i){
		components.get(i);
	}
	
	//Typisk operation for objekt i en sammansattning
	public double getWeight(){
		//returnerar summan av behallarens vikt tillsammans med dess innehall (child/components)
		double sammansattVikt = this.vikt;
		for(int i = 0; i < components.size(); i++){
			sammansattVikt += components.get(i).getWeight();
		}
		return sammansattVikt;
	}
	
	
	public String toString(){
		//returnerar namnet pa behallaren foljt av namnen pa dess innehall
		String returnString = "Behallare: " + this.prylnamn + " Innehall: ";
		for(int i = 0; i < components.size(); i++){
			returnString += " " + components.get(i) + " ";
		}
		return  returnString;
	}

	@Override
	/*public Iterator<Component> iterator() {
		return new BFSCompositeIterator(this);
	}*/
	
	public Iterator<Component> iterator() {
		return new DFSCompositeIterator(this);
	}
}
