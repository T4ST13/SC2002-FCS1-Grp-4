package domain.statuseffectlogic;

import domain.CombatStat;
import domain.combatant.Combatant;

public class ArcaneBlastEffect extends StatusEffectLogic/* implements StatRelated*/{
    private static final String NAME = "Arcane Blast";
    private static final CombatStat RELATED_STAT = CombatStat.ATK;
    private static final int STAT_CHANGE = 10;
    private static final int BASE_DURATION = -1;//ArcaneBlastEffect is permanent

    public ArcaneBlastEffect() {
        super(NAME, RELATED_STAT, STAT_CHANGE, BASE_DURATION);
    }

    @Override
    public void activate(Combatant target){}
}
