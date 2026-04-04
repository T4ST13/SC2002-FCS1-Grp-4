package domain.statuseffect;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect.TickPhase;

public class ArcaneBlastEffect extends StatusEffectLogic {
    private final int attackBonus;

    public ArcaneBlastEffect(int attackBonus) {
        super("Arcane Blast Buff", TickPhase.NONE);
        this.attackBonus = attackBonus;
    }

    @Override
    public int getAttackBonus(Combatant target) {
        return attackBonus;
    }
}
