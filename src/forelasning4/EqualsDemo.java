package forelasning4;

class EqualsDemo {

    public static void main (String[] u) {

	System.out.println();

	Spelkort kort1 = new Spelkort("Spader",11);
	Spelkort kort2 = new Spelkort("Spader",11);

	System.out.println("Kort1: " + kort1);
	System.out.println("Kort2: " + kort2);
	System.out.println();

	System.out.println("Korten lika? " + kort1.equals(kort2));
	System.out.println("Kort lika med 17? " + kort1.equals(17));
	System.out.println();
    }
}
