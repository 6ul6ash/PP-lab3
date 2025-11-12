package droids;
import droids.types.*;
import java.util.Scanner;

public class Droid {
    private String name;
    private int health;
    private int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Droid() {
    }

    // Гетери
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    // Сетери
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(Droid target) {
        if (target == null || !target.isAlive()) return;
        target.setHealth(target.getHealth() - this.damage);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage");
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage + "\n");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public static Droid addDroid(int type, Scanner sc) {
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("HP: ");
        int hp = sc.nextInt();
        System.out.print("Damage: ");
        int dmg = sc.nextInt();

        switch (type) {
            case 1:
                return new DamageDealer(name, hp, dmg);
            case 2:
                return new Tank(name, hp, dmg);
            case 3:
                return new Healer(name, hp, dmg);
            default:
                return null;
        }
    }
}


