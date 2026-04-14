package domain.combatant;

import domain.action.SharedAction;
import domain.actionlogic.BasicAttackLogic;
import domain.combatdata.CombatType;

public class Enemy extends Combatant {
    protected Enemy(CombatType enemyType) {
        super(enemyType);
        this.addAction(new SharedAction(this, new BasicAttackLogic()));//all characters can perform basic attack
        //change 'new Logic()' to getInstance()
    }
}
