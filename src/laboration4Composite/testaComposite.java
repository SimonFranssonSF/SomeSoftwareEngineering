package laboration4Composite;

public class testaComposite {

	public static void main(String[] args) {
		Composite resvaska = new Composite("Resvaska", 1);
		resvaska.add(new Leaf("T-shirt", 2));
		resvaska.add(new Leaf("Byxor", 2));
		resvaska.add(new Leaf("Strumpor", 2));
		resvaska.add(new Leaf("Kallingar", 2));
		System.out.println("Vikt: " + resvaska.getWeight() + " " + resvaska);
		
		Composite necessar = new Composite("necessar", 3);
		necessar.add(new Leaf("Tandborste", 4));
		necessar.add(new Leaf("Tandkram", 4));
		necessar.add(new Leaf("Schampoo", 4));
		System.out.println("Vikt: " + necessar.getWeight() + " " + necessar);
		
		Composite pase = new Composite("pase", 5);
		pase.add(new Leaf("Rakhyvel", 6));
		pase.add(new Leaf("Rakl�dder", 6));
		System.out.println("Vikt: " + pase.getWeight() + " " + pase);
		
		necessar.add(pase);
		resvaska.add(necessar);
		System.out.println("Vikt: " + resvaska.getWeight() + " " + resvaska);	
	}

}
