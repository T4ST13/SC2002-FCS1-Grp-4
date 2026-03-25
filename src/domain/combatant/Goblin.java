package domain.combatant;

public class Goblin extends Enemy {
    private static final String CLASS_NAME = "Goblin";
    private static final int MAX_HP = 55;
    private static final int ATTACK = 35;
    private static final int DEFENSE = 15;
    private static final int SPEED = 25;

    // Constructor
    public Goblin() {
        // Pass to Enemy class
        super(CLASS_NAME, MAX_HP, ATTACK, DEFENSE, SPEED);
    }
}
