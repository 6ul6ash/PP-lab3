package Battles;
import droids.Droid;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle2v2 {
    public static String fight(ArrayList<Droid> droids, Scanner sc) {
        System.out.print("Enter number of first droid in Team 1: ");
        int i1 = sc.nextInt();
        Droid t1d1 = droids.get(i1);

        System.out.print("Enter number of second droid in Team 1: ");
        int i2 = sc.nextInt();
        Droid t1d2 = droids.get(i2);

        System.out.print("Enter number of first droid in Team 2: ");
        int j1 = sc.nextInt();
        Droid t2d1 = droids.get(j1);

        System.out.print("Enter number of second droid in Team 2: ");
        int j2 = sc.nextInt();
        Droid t2d2 = droids.get(j2);

        System.out.println("\n=== Battle 2v2 starts! ===");

        boolean turn = true;

        while ((t1d1.isAlive() || t1d2.isAlive()) && (t2d1.isAlive() || t2d2.isAlive())) {
            if (turn) {
                if (t1d1.isAlive()) t1d1.attack(t2d1.isAlive() ? t2d1 : t2d2);
                if (t1d2.isAlive()) t1d2.attack(t2d1.isAlive() ? t2d1 : t2d2);
            } else {
                if (t2d1.isAlive()) t2d1.attack(t1d1.isAlive() ? t1d1 : t1d2);
                if (t2d2.isAlive()) t2d2.attack(t1d1.isAlive() ? t1d1 : t1d2);
            }
            turn = !turn;
        }

        System.out.println("\n=== Outcome ===");
        boolean team1Alive = t1d1.isAlive() || t1d2.isAlive();
        boolean team2Alive = t2d1.isAlive() || t2d2.isAlive();

        if (team1Alive && !team2Alive){
            System.out.println("Team 1 (" + t1d1.getName() + " & " + t1d2.getName() + ") won!");
            return "Team 1";
        }
        else if (team2Alive && !team1Alive){
            System.out.println("Team 2 (" + t2d1.getName() + " & " + t2d2.getName() + ") won!");
            return "Team 2";
        }
        else{
            System.out.println("Draw! All droids are destroyed.");
            return "Draw";
        }

    }
}
