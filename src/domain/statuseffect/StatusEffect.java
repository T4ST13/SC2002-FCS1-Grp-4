package domain.statuseffect;

import domain.TurnBasedCount;
import domain.combatant.Combatant;
import domain.statuseffectlogic.StatusEffectLogic;
//import domain.statuseffectlogic.StatusEffectLogic.TickPhase;

public class StatusEffect implements TurnBasedCount {
    private final StatusEffectLogic effectLogic;
    private int remainingTurns;

    public StatusEffect(StatusEffectLogic effectLogic, int remainingTurns) {
        this.effectLogic = effectLogic;
        this.remainingTurns = remainingTurns;
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
