package domain.combatant;

import domain.action.SharedAction;
import domain.combatdata.CombatType;

public class Enemy extends Combatant {
    public Enemy(CombatType enemyType) {
        super(enemyType);
    }
}
