package domain.statuseffect;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect.TickPhase;

public class SmokeBombEffect extends StatusEffectLogic {
    public SmokeBombEffect() {
        super("Smoke Bomb", TickPhase.TURN_START);
    }

    @Override
    public int modifyIncomingDamage(Combatant target, Combatant attacker, int incomingDamage) {
        if (attacker != null && !attacker.isPlayerControlled()) {
            return 0;
        }

        return Math.max(0, incomingDamage);
    }
}
