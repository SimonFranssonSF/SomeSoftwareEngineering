package laboration4Iterator;

import java.util.Iterator;

public class testIterator {
	public static void main(String[] args) {
		Composite resvaska = new Composite("Resvaska", 0);
		resvaska.add(new Leaf("T-shirt", 1));
		resvaska.add(new Leaf("Byxor", 1));
		resvaska.add(new Leaf("Strumpor", 1));
		Composite necessar = new Composite("necessar", 1);
			necessar.add(new Leaf("Tandborste", 2));
			necessar.add(new Leaf("Tandkram", 2));
			Composite pase = new Composite("pase", 2);
				pase.add(new Leaf("Rakhyvel", 3));
				pase.add(new Leaf("Raklodder", 3));
			necessar.add(pase);
			necessar.add(new Leaf("Schampoo", 2));
		resvaska.add(necessar);
		resvaska.add(new Leaf("Kallingar", 1));
		
		Iterator<Component> component = resvaska.iterator();
		Component c;
		while(component.hasNext()) {
			c = component.next();
			System.out.println(c.getMembers());
			if(!component.hasNext()){
				break;
			}
		}
		

		
	}
}
