package domain.combatant;

import domain.actionlogic.ArcaneBlastLogic;
import domain.actionlogic.Skill;
import java.util.Collections;

public class Wizard extends Player {
    private static final String CLASS_NAME = "Wizard";
    private static final int MAX_HP = 200;
    private static final int ATTACK = 50;
    private static final int DEFENSE = 10;
    private static final int SPEED = 20;
    private static final String SKILL_DESCRIPTION = "Deal Basic Attack damage to all enemies. Each enemy defeated adds +10 ATK until end of level.";

    // Constructor
    public Wizard() {
        // Pass to Player class
        super(CLASS_NAME, MAX_HP, ATTACK, DEFENSE, SPEED);
        
        // Empty list placeholder for now.
        // Later, replace with the real enemy list when battle context / setup is ready.
        setSpecialSkill(new Skill(this, new ArcaneBlastLogic(Collections.emptyList()), SKILL_DESCRIPTION));
    }
}