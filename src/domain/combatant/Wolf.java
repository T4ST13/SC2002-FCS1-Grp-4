package domain.combatant;

public class Wolf extends Enemy {
    private static final String NAME = "Wolf";
    private static final int BASE_HP = 40;
    private static final int BASE_ATK = 45;
    private static final int BASE_DEF = 5;
    private static final int BASE_SPD = 35;
    
    // Constructor
    public Wolf() {
        // Pass to Enemy class
        super(NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_SPD);
    }
}
