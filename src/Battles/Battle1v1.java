package Battles;
import droids.Droid;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle1v1 {
    public static String fight(ArrayList<Droid> droids, Scanner sc) {
        System.out.print("Enter number of first droid: ");
        int i = sc.nextInt();
        Droid d1 = droids.get(i);
        System.out.print("Enter number of second droid: ");
        int y = sc.nextInt();
        Droid d2 = droids.get(y);

        System.out.println("\n=== Battle starts! ===");
        boolean turn = true;

        while (d1.isAlive() && d2.isAlive()) {
            if (turn) d1.attack(d2);
            else d2.attack(d1);
            turn = !turn;
        }

        System.out.println("\n=== Outcome ===");
        if (d1.isAlive() && !d2.isAlive()) {
            System.out.println(d1.getName() + " won!");
            return d1.getName();
        } else if (d2.isAlive() && !d1.isAlive()) {
            System.out.println(d2.getName() + " won!");
            return d2.getName();
        } else {
            System.out.println("Draw! Both droids are destroyed.");
            return "Draw";
        }
    }
}
