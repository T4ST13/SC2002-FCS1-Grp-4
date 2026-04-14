package domain.condition;

import domain.combatant.Combatant;

public interface CombatConition {
    public boolean checkCondition(Combatant user, Combatant target);//expand to 2 Combatant or just create a BattleContext class and use getCombatant()
}
