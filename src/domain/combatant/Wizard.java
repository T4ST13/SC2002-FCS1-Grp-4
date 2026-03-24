package domain.combatant;

public class Wizard extends Player {
    private static final String CLASS_NAME = "Wizard";
    private static final int MAX_HP = 200;
    private static final int ATTACK = 50;
    private static final int DEFENSE = 10;
    private static final int SPEED = 20;

    private static final String SKILL_NAME = "Arcane Blast";
    private static final String SKILL_DESCRIPTION = "Deal Basic Attack damage to all enemies. Each enemy defeated adds +10 ATK until end of level.";
    private static final int SKILL_COOLDOWN = 3;

    // Constructor
    public Wizard() {
        // Pass to Player class
        super( 
            CLASS_NAME, 
            MAX_HP,
            ATTACK,
            DEFENSE,
            SPEED,
            SKILL_NAME,
            SKILL_DESCRIPTION,
            SKILL_COOLDOWN
        );
    }
}