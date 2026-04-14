package domain.unused;

import domain.action.Skill;
import domain.actionlogic.ShieldBashLogic;
import domain.combatant.Player;

public class Warrior extends Player {
    // Stats from brief
    private static final String NAME = "Warrior";
    private static final int BASE_HP = 260;
    private static final int BASE_ATK = 40;
    private static final int BASE_DEF = 20;
    private static final int BASE_SPD = 30;
    private static final String SKILL_DESCRIPTION = "Deal Basic Attack damage to one selected enemy and stun them for the current turn and next turn.";

    // Constructor
    public Warrior() {
        // Pass to Player class
        super(NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_SPD);
        this.getActionList().add(new Skill(this, new ShieldBashLogic()));
    }
}