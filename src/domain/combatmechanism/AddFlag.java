package domain.combatmechanism;

import domain.combatant.Combatant;
import domain.effectlogic.Flag;

public class AddFlag extends TargetableMechanism{
    private final Flag flag;
    private final String effectName;

    public AddFlag(TargetMode targetMode, int maxTarget, int area, Flag flag, String effectName){
        super(targetMode, maxTarget, area);
        this.flag = flag;
        this.effectName = effectName;
    }

    @Override
    public /*String*/ void execute(Combatant user, Combatant target){
//        if (getTargetMode() == TargetMode.TARGET){
//            target.addFlag(flag, effectName);
//        }
//        else{
//            user.addFlag(flag, effectName);
//        }
        Combatant realTarget = this.getRealTarget(user, target);
        realTarget.addFlag(flag, effectName);
        //return "";
    }

}
