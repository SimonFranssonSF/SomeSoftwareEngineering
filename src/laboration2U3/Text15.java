package laboration2U3;

import java.util.*;

import laboration2.Boardgame;
class Text15 {
    private static Scanner scan;

	public static void main(String[] u) {
        scan = new Scanner(System.in);
        Boardgame thegame = new FifteenModel(4);                 // new
        System.out.println("\nV�lkommen till femtonspelet\n");
        while (true) {
            // Skriv ut aktuell st�llning
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + thegame.getStatus(i,j)); // getStatus
                System.out.println();
            }
            System.out.println();
            System.out.print("Ditt drag: ");
            int i = scan.nextInt();  // h�mta heltal fr�n terminalf�nstret
            int j = scan.nextInt();
            thegame.move(i,j);	                             // move
            System.out.println(thegame.getMessage());	     // getMessage
        }
    }
}