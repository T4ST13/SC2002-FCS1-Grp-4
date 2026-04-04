package domain.statuseffect;

import domain.combatant.Combatant;
import domain.statuseffectlogic.StatusEffectLogic;

public class StatusEffect {
    public static final int PERMANENT_DURATION = -1; // for permanent effects, e.g. arcane blast gives perma +5 ATK

    public enum TickPhase {
        TURN_START,
        TURN_END,
        NONE
    }

    private final Combatant target;
    private final StatusEffectLogic statusEffectLogic;
    private int remainingTurns;

    public StatusEffect(Combatant target, StatusEffectLogic statusEffectLogic, int duration) {
        this.target = target;
        this.statusEffectLogic = statusEffectLogic;
        this.remainingTurns = duration;
    }

    /* == Getters == */
    public Combatant getTarget() {
        return target;
    }

    public StatusEffectLogic getStatusEffectLogic() {
        return statusEffectLogic;
    }

    public String getName() {
        return statusEffectLogic.getName();
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

    public void onTurnStart() {
        if (statusEffectLogic.getTickPhase() == TickPhase.TURN_START) {
            decreaseDuration();
        }
    }

    public void onTurnEnd() {
        if (statusEffectLogic.getTickPhase() == TickPhase.TURN_END) {
            decreaseDuration();
        }
    }

    public int getAttackBonus() {
        return statusEffectLogic.getAttackBonus(target);
    }

    public int getDefenseBonus() {
        return statusEffectLogic.getDefenseBonus(target);
    }

    public boolean preventsAction() {
        return statusEffectLogic.preventsAction(target);
    }

    public int modifyIncomingDamage(Combatant attacker, int incomingDamage) {
        return statusEffectLogic.modifyIncomingDamage(target, attacker, incomingDamage);
    }

    public boolean isExpired() {
        return remainingTurns == 0;
    }

    private void decreaseDuration() {
        if (remainingTurns > 0) {
            remainingTurns--;
        }
    }

    @Override
    public String toString() {
        String durationText = (remainingTurns == PERMANENT_DURATION)
            ? "permanent"
            : String.valueOf(remainingTurns);

        return getName() + " [target=" + target.getName() + ", turns=" + durationText + "]";
    }
}
