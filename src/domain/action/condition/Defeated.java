package domain.action.condition;

import domain.entity.Combatant;
import domain.action.mechanism.TargetMode;

public class Defeated implements CombatConition{
    TargetMode targetMode;

    public Defeated(TargetMode targetMode){
        this.targetMode = targetMode;
    }

    @Override
    public boolean checkCondition(Combatant user, Combatant target) {
        if (this.targetMode == TargetMode.TARGET) {
            return !target.isAlive();
        }
        else{
            return !user.isAlive();
        }
    }
}
