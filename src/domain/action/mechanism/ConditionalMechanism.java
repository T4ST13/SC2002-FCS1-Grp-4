package domain.action.mechanism;

import domain.entity.Combatant;
import domain.action.condition.CombatConition;

//for mechanisms that activate on conditions (ex. Arcane Blast effect applied to user only if target is defeated)
public class ConditionalMechanism implements CombatMechanism{
    CombatConition condition;
    CombatMechanism mechanism;

    public ConditionalMechanism(CombatConition condition, CombatMechanism mechanism){
        this.condition = condition;
        this.mechanism = mechanism;
    }

    @Override
    public boolean needsTarget(Combatant user) {
        return mechanism.needsTarget(user);
    }

    @Override
    public void execute(Combatant user, Combatant target) {
        if (condition.checkCondition(user, target)){
            mechanism.execute(user, target);
        }
    }
}
