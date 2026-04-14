package domain.actionlogic.mechanism;

import domain.combatant.Combatant;

public interface CombatMechanism {
    public void execute(Combatant user, Combatant target);
}
