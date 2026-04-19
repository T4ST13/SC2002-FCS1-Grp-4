package domain.effect;

import domain.action.mechanism.CombatMechanism;
import domain.util.TurnBasedCount;
import domain.entity.Combatant;

//holds effect logic and other factors unique to each status effect
//ex. remaining turns or Combatant who created the effect
public class StatusEffect implements TurnBasedCount {
    private final EffectLogic effectLogic;
    private int remainingTurns;
    private final Combatant creator;

    public StatusEffect(EffectLogic effectLogic, Combatant creator) {
        this.effectLogic = effectLogic;
        this.remainingTurns = this.effectLogic.getBaseDuration();
        this.creator = creator;
    }

    /* == Getters == */
    public int getRemainingTs() {
        return remainingTurns;
    }

    public EffectLogic getEffectLogic() {
        return effectLogic;
    }

    public String getName() {
        return effectLogic.getName();
    }

    public void execute(Combatant target){
        for (CombatMechanism mechanism : this.effectLogic.getMechanismList()){
            mechanism.execute(this.creator, target);
        }
    }

    public void passTurn(){
        remainingTurns--;
    }
}
