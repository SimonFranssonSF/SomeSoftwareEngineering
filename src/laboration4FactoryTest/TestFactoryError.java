package laboration4FactoryTest;

import laboration4Factory.Human;
// Supposed to not compile
public class TestFactoryError{
	public static void main(String[] args) {
		//Human anna = new Woman("Anna", "xxxxxx-012x");
		//Human anna = new Man("Anna", "xxxxxx-012x");
		//Woman anna = new Woman("Anna", "xxxxxx-012x");
		//Man anna = new Man("Anna", "xxxxxx-012x");
		//Human anna = new Human("Anna", "xxxxxx-012x");
		//Human anna = new Man();
		
		//anonym subklass
		
		Human h = new Human("Anna", "xxxxxx-012x"){

			@Override
			public String toString() {
				return null;
			}};
	}
}
