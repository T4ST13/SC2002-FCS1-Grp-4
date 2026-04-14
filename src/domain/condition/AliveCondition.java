package domain.condition;

import domain.combatant.Combatant;

public class AliveCondition implements CombatConition{
    @Override
    public boolean checkCondition(Combatant user, Combatant target) {
        return target.isAlive();
    }
}
