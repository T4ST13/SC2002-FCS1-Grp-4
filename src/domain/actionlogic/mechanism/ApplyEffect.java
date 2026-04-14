package domain.actionlogic.mechanism;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect;
import domain.statuseffectlogic.StatusEffectLogic;

public class ApplyEffect extends TargetableMechanism{

    private final StatusEffectLogic effectLogic;

    public ApplyEffect(TargetMode targetMode, int maxTarget, StatusEffectLogic effectLogic){
        super(targetMode, maxTarget);
        this.effectLogic = effectLogic;
    }

    @Override
    public void execute(Combatant user, Combatant target){
        if (this.getTargetMode() == TargetMode.TARGET){
            target.addStatusEffect(new StatusEffect(this.effectLogic));
        }
        else{
            user.addStatusEffect(new StatusEffect(this.effectLogic));
        }
    }
}
