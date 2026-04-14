package domain.statuseffect;

import domain.others.TurnBasedCount;
import domain.combatant.Combatant;
import domain.statuseffectlogic.StatusEffectLogic;
//import domain.statuseffectlogic.StatusEffectLogic.TickPhase;

public class StatusEffect implements TurnBasedCount {
    private final StatusEffectLogic effectLogic;
    private int remainingTurns;

    public StatusEffect(StatusEffectLogic effectLogic) {
        this.effectLogic = effectLogic;
        this.remainingTurns = this.effectLogic.getBaseDuration();
    }

    /* == Getters == */
    public int getRemainingTs() {
        return remainingTurns;
    }

    public StatusEffectLogic getEffectLogic() {
        return effectLogic;
    }

    public String getName() {
        return effectLogic.getName();
    }

    public void trigger(Combatant target){
        effectLogic.activate(target);
    }

    public void passTurn(){
        remainingTurns--;
    }
}
