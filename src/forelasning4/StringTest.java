package forelasning4;

class StringTest {

    // Kör programmet med  java StringTest VINDRUVA
    // u[0] får värdet VINDRUVA
    
    public static void main(String[] u) {

	String s1 = "VINDRUVA";
	String s2 = u[0];
	String s3 = "VIND" + "RUVA";
	String s4 = "";
	s4 += "VINDRUVA";

	System.out.println();
	System.out.println("         ==    equals()");
	System.out.print("s1 s2   ");
	System.out.print(s1==s2);
	System.out.print("   ");
	System.out.println(s1.equals(s2));
	System.out.print("s1 s3   ");
	System.out.print(s1==s3);
	System.out.print("   ");
	System.out.println(s1.equals(s3));
	System.out.print("s1 s4   ");
	System.out.print(s1==s4);
	System.out.print("   ");
	System.out.println(s1.equals(s4));
	System.out.print("s2 s3   ");
	System.out.print(s2==s3);
	System.out.print("   ");
	System.out.println(s2.equals(s3));
	System.out.print("s2 s4   ");
	System.out.print(s2==s4);
	System.out.print("   ");
	System.out.println(s2.equals(s4));
	System.out.print("s3 s4   ");
	System.out.print(s3==s4);
	System.out.print("   ");
	System.out.println(s3.equals(s4));

	System.out.println();
	System.out.println(s1.getClass());
    }
}
