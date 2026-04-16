package domain.combatmechanism;

import domain.combatant.Combatant;

public interface CombatMechanism {
    public /*String*/ void execute(Combatant user, Combatant target);

    public abstract boolean needsTarget(Combatant user);
}
