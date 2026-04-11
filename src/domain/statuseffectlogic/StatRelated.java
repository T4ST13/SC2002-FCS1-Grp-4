package domain.statuseffectlogic;

import domain.combatant.Combatant;

public interface StatRelated {
    public abstract void changeStat(Combatant target);
    public abstract void restoreStat(Combatant target);
}
