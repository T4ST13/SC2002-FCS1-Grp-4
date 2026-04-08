package domain.statuseffect;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect.TickPhase;

public abstract class StatusEffectLogic {
    private final String name;
    private final TickPhase tickPhase;

    protected StatusEffectLogic(String name, TickPhase tickPhase) {
        this.name = name;
        this.tickPhase = tickPhase;
    }
    
    /* == Getters == */
    public String getName() {
        return name;
    }

    public TickPhase getTickPhase() {
        return tickPhase;
    }

    public int getAttackBonus(Combatant target) {
        return 0;
    }

    public int getDefenseBonus(Combatant target) {
        return 0;
    }

    public boolean preventsAction(Combatant target) {
        return false;
    }

    public int modifyIncomingDamage(Combatant target, Combatant attacker, int incomingDamage) {
        return Math.max(0, incomingDamage);
    }
}