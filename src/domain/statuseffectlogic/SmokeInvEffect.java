package domain.statuseffectlogic;

import domain.combatdata.CombatStat;
import domain.combatant.Combatant;

public class SmokeInvEffect extends StatusEffectLogic {
    private static final String NAME = "Smoke Invulnerability";
    private static final CombatStat RELATED_STAT = CombatStat.NONE;
    private static final int STAT_CHANGE = 0;
    private static final int BASE_DURATION = 2;
    public SmokeInvEffect() {
        super(NAME, RELATED_STAT, STAT_CHANGE, BASE_DURATION);
    }

    @Override
    public void activate(Combatant target){
        target.setInvulnerable(true);
    }
}
