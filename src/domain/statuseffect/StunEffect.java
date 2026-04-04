package domain.statuseffect;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect.TickPhase;

public class StunEffect extends StatusEffectLogic {
    public StunEffect() {
        super("Stun", TickPhase.TURN_END);
    }

    @Override
    public boolean preventsAction(Combatant target) {
        return true;
    }
}