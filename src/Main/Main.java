package Main;

import Battles.*;
import droids.Droid;
import droids.types.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Droid> droids = new ArrayList<>();
        droids.add(new DamageDealer("AssaultDroid", 100, 20));
        droids.add(new Tank("HeavyDroid", 150, 15));
        droids.add(new Healer("SupportDroid", 80, 5));

        boolean running = true;

        while (running) {

            System.out.println("1. Create droid");
            System.out.println("2. Show droids");
            System.out.println("3. Battle 1v1");
            System.out.println("4. Battle 2v2");
            System.out.println("5. Save battle");
            System.out.println("6. Replay battle");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1 – DamageDealer");
                    System.out.println("2 – Tank");
                    System.out.println("3 – Healer");
                    int type = sc.nextInt();

                    Droid d = Droid.addDroid(type, sc);   // передаєш тип
                    if (d != null) droids.add(d);
                    break;

                case 2:
                    showDroids(droids, sc);
                    break;

                case 3:
                    String result1v1 = Battle1v1.fight(droids, sc);
                    break;

                case 4:
                    String result2v2 = Battle2v2.fight(droids, sc);
                    break;

                case 5:
                    System.out.print("Save result of which battle? (1 - 1v1, 2 - 2v2): ");
                    int i = sc.nextInt();
                    sc.nextLine();

                    if (i == 1) {
                        lastBattleResult = Battle1v1.fight(droids, sc);
                        lastBattleType = "1v1";
                        saveBattle("1v1 result: " + lastBattleResult);
                    } else if (i == 2) {
                        lastBattleResult = Battle2v2.fight(droids, sc);
                        lastBattleType = "2v2";
                        saveBattle("2v2 result: " + lastBattleResult);
                    } else {
                        System.out.println("Invalid choice. No result saved.");
                    }
                    break;

                case 6:
                    replayBattle(droids, sc);
                    break;

                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void showDroids(ArrayList<Droid> droids,Scanner sc) {
        System.out.println("=== List of droids ===");
        for (int i = 0; i < droids.size(); i++) {
            Droid d = droids.get(i);
            System.out.println("Index " + i + ": " + d.getName());
            d.showInfo();
        }
    }

    public static void saveBattle(String result) {
        try (FileWriter writer = new FileWriter("battle_results.txt", true)) {
            writer.write("=== Battle Result ===\n");
            writer.write(result + "\n\n");
            System.out.println("Battle result saved to battle_results.txt");
        } catch (IOException e) {
            System.out.println("Error saving battle result: " + e.getMessage());
        }
    }

    static String lastBattleType = "";  // "1v1" або "2v2"
    static String lastBattleResult = "";

    public static void replayBattle(ArrayList<Droid> droids, Scanner sc) {
        if (lastBattleType.isEmpty()) {
            System.out.println("No battle has been fought yet.");
            return;
        }

        System.out.println("Replaying last battle: " + lastBattleType);
        String result;

        if (lastBattleType.equals("1v1")) {
            result = lastBattleResult;
        } else { // "2v2"
            result = lastBattleResult;
        }

        System.out.println("Battle replay finished: " + lastBattleResult + " won");
    }

}

