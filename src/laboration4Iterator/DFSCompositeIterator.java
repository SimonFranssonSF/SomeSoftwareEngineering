package laboration4Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class DFSCompositeIterator implements Iterator<Component>{
	private ArrayList<Component> c = new ArrayList<Component>(); //Kan istallet anvanda Stack eller en Queue
	private int current = -1;
	
	public DFSCompositeIterator(Composite composite){
		c.add(composite);
		//c.addAll(composite.components);
		
	}
	
	@Override
	public boolean hasNext() {
		int size = c.size();
		return current < size-1;
	}

	@Override
	public Component next() {
		++current;
		//System.out.println(c.get(current));
			//om det ar en sammansattning lagg till dennes ArrayList pa currentindex+1 och kolla den nast (gar till nasta niva)
			if((c.get(current) instanceof Composite)){
				//System.out.println("-------ADDAR ARRAY-------");
				c.addAll(current+1, c.get(current).components); 
			}
		return c.get(current);
	}
	
	public void remove(){
	}
}
