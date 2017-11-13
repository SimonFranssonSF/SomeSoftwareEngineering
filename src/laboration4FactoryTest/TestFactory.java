package laboration4FactoryTest;

import laboration4Factory.Human;

public class TestFactory {

	public static void main(String[] args) {
		//Human anna = new Woman("Anna", "xxxxxx-012x");
		//Human anna = new Man("Anna", "xxxxxx-012x");
		//Woman anna = new Woman("Anna", "xxxxxx-012x");
		//Man anna = new Man("Anna", "xxxxxx-012x");
		//Human anna = new Human("Anna", "xxxxxx-012x");
		//Human anna = new Man();
		
		Human anna = Human.create("Anna", "xxxxxx-012x");
		Human magnus = Human.create("Magnus","xxxxxx-011x");
		
		System.out.println(anna);
	    System.out.println(magnus);
	}

}
