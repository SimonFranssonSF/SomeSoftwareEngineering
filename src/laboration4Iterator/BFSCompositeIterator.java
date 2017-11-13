package laboration4Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class BFSCompositeIterator implements Iterator<Component>{
	private ArrayList<Component> c = new ArrayList<Component>(); //Kan istallet anvanda Stack eller Queue
	private int current = -1;
	
	public BFSCompositeIterator(Composite composite){
		c.add(composite);
		c.addAll(composite.components);
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
		if((c.get(current) instanceof Composite)){
			System.out.println("-------ADDAR ARRAY-------");
			c.addAll(c.get(current).components); 
		}
		return c.get(current);
	}
	
	public void remove(){
	}
}
