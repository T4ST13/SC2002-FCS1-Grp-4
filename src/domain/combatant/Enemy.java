package domain.combatant;

import domain.action.Action;
import domain.actionlogic.DefendLogic;

public abstract class Enemy extends Combatant {
    /* == Constructor for enemy classes == */
    protected Enemy(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
    }
}
