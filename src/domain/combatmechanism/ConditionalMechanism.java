package domain.combatmechanism;

import domain.combatant.Combatant;
import domain.condition.CombatConition;

public class ConditionalMechanism implements CombatMechanism{
    CombatConition condition;
    CombatMechanism mechanism;

    public ConditionalMechanism(CombatConition condition, CombatMechanism mechanism){
        this.condition = condition;
        this.mechanism = mechanism;
    }

    @Override
    public boolean needsTarget(Combatant user) {//will have to change to check condition needsTarget() as well
        return mechanism.needsTarget(user);
    }

    @Override
    public /*String*/ void execute(Combatant user, Combatant target) {
//        String message = "";
//        if (condition.checkCondition(user, target)){
//            message = mechanism.execute(user, target);
//        }
//        return message;
        if (condition.checkCondition(user, target)){
            mechanism.execute(user, target);
        }
    }
}
