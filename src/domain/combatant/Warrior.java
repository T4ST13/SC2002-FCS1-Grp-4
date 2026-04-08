package domain.combatant;

import domain.actionlogic.ShieldBashLogic;

public class Warrior extends Player {
    // Stats from brief
    private static final String CLASS_NAME = "Warrior";
    private static final int MAX_HP = 260;
    private static final int ATTACK = 40;
    private static final int DEFENSE = 20;
    private static final int SPEED = 30;
    private static final String SKILL_DESCRIPTION = "Deal Basic Attack damage to one selected enemy and stun them for the current turn and next turn.";

    // Constructor
    public Warrior() {
        // Pass to Player class
        super(CLASS_NAME, MAX_HP, ATTACK, DEFENSE, SPEED);
        setSpecialSkill(new Skill(this, new ShieldBashLogic(), SKILL_DESCRIPTION));
    }
}