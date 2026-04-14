package domain.unused;

import domain.actionlogic.ArcaneBlastLogic;
import domain.action.Skill;
import domain.combatant.Player;

public class Wizard extends Player {
    private static final String NAME = "Wizard";
    private static final int BASE_HP = 200;
    private static final int BASE_ATK = 50;
    private static final int BASE_DEF = 10;
    private static final int BASE_SPD = 20;
    private static final String SKILL_DESCRIPTION = "Deal Basic Attack damage to all enemies. Each enemy defeated adds +10 ATK until end of level.";

    // Constructor
    public Wizard() {
        // Pass to Player class
        super(NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_SPD);
        this.getActionList().add(new Skill(this, new ArcaneBlastLogic()));
    }
}