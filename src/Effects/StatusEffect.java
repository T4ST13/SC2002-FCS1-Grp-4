package Effects;

import domain.combatant.Combatant;

public interface StatusEffect {
	void onTurnStart(Combatant target);
    boolean isExpired();
}
