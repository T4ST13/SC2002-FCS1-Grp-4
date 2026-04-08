package domain.statuseffect;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect.TickPhase;

public class DefendEffect extends StatusEffectLogic {
    private static final int DEFENSE_BONUS = 10;

    public DefendEffect() {
        super("Defend", TickPhase.TURN_START);
    }

    @Override
    public int getDefenseBonus(Combatant target) {
        return DEFENSE_BONUS;
    }
}
