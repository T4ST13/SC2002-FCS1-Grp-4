package domain.combatant;

public class Goblin extends Enemy {
    private static final String NAME = "Goblin";
    private static final int BASE_HP = 55;
    private static final int BASE_ATK = 35;
    private static final int BASE_DEF = 15;
    private static final int BASE_SPD = 25;

    // Constructor
    public Goblin() {
        // Pass to Enemy class
        super(NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_SPD);
    }
}
