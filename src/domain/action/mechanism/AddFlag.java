package domain.action.mechanism;

import domain.entity.Combatant;
import domain.effect.Flag;

//adds flags, which are used to check special conditions that can't be checked through stats
// (ex. stun effect = NO_ACTION, Smoke bomb = INVULNERABLE)
public class AddFlag extends TargetableMechanism{
    private final Flag flag;
    private final String effectName;//name of effect that created the flag

    public AddFlag(TargetMode targetMode, Flag flag, String effectName){
        super(targetMode);
        this.flag = flag;
        this.effectName = effectName;
    }

    @Override
    public void execute(Combatant user, Combatant target){
        Combatant realTarget = this.getRealTarget(user, target);
        realTarget.addFlag(flag, effectName);
    }

}
