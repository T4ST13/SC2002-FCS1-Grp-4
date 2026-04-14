package domain.statuseffectlogic;

import domain.combatdata.CombatStat;
import domain.combatant.Combatant;

public class StunEffect extends StatusEffectLogic {
    private static final String NAME = "Stun";
    private static final CombatStat RELATED_STAT = CombatStat.NONE;//Stun doesn't affect any stat
    private static final int STAT_CHANGE = 0;
    private static final int BASE_DURATION = 2;
    public StunEffect() {
        super(NAME, RELATED_STAT, STAT_CHANGE, BASE_DURATION);
    }

    @Override
    public void activate(Combatant target) {
        target.setActive(false);
    }
}