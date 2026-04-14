package domain.actionlogic.mechanism;

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
    public void execute(Combatant user, Combatant target) {
        if (condition.checkCondition(user, target)){
            mechanism.execute(user, target);
        }
    }
}
