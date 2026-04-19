package domain.action.condition;

import domain.entity.Combatant;

public interface CombatConition {
    boolean checkCondition(Combatant user, Combatant target);
}
