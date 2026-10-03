package encapsulation.assignment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
            System.out.println("c.takeDamage(" + amount + ") -> health = " + this.health);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
            System.out.println("c.heal(" + amount + ") -> health = " + this.health);
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}
