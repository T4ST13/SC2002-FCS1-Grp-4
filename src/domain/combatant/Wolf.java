package domain.combatant;

public class Wolf extends Enemy {
    private static final String CLASS_NAME = "Wolf";
    private static final int MAX_HP = 40;
    private static final int ATTACK = 45;
    private static final int DEFENSE = 5;
    private static final int SPEED = 35;

    // Constructor
    public Wolf() {
        // Pass to Enemy class
        super(CLASS_NAME, MAX_HP, ATTACK, DEFENSE, SPEED);
    }
}
