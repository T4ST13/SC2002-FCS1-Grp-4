package domain.statuseffectlogic;

import domain.CombatStat;
import domain.combatant.Combatant;

public class DefendEffect extends StatusEffectLogic {
    private static final String NAME = "Defend";
    private static final CombatStat RELATED_STAT = CombatStat.DEF;//Stun doesn't affect any stat
    private static final int STAT_CHANGE = 10;
    private static final int BASE_DURATION = 2;

    public DefendEffect() {
        super(NAME, RELATED_STAT, STAT_CHANGE, BASE_DURATION);
    }

    @Override
    public void activate(Combatant target){}
}
