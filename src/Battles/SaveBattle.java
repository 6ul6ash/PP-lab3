package Battles;
import java.io.FileWriter;
import java.io.IOException;

class BattleLogger {
    public static void saveBattle(String result) {
        try (FileWriter writer = new FileWriter("battle_results.txt", true)) {
            writer.write("=== Battle Result ===\n");
            writer.write(result + "\n\n");
            System.out.println("Battle result saved to battle_results.txt");
        } catch (IOException e) {
            System.out.println("Error saving battle result: " + e.getMessage());
        }
    }
}
