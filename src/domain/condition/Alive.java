package domain.condition;

import domain.combatant.Combatant;
import domain.combatmechanism.TargetMode;

public class Alive implements CombatConition{
    TargetMode targetMode;

    public Alive(TargetMode targetMode){
        this.targetMode = targetMode;
    }
    @Override
    public boolean checkCondition(Combatant user, Combatant target) {
        if (this.targetMode == TargetMode.TARGET) {
            return target.isAlive();
        }
        else{
            return user.isAlive();
        }
    }
}
