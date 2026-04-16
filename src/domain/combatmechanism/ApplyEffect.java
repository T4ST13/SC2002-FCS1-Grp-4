package domain.combatmechanism;

import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect;
import domain.effectlogic.EffectLogic;

public class ApplyEffect extends TargetableMechanism{

    private final EffectLogic effectLogic;

    public ApplyEffect(TargetMode targetMode, int maxTarget, int area, EffectLogic effectLogic){
        super(targetMode, maxTarget, area);
        this.effectLogic = effectLogic;
    }

    @Override
    public /*String*/ void execute(Combatant user, Combatant target){
        Combatant realTarget = this.getRealTarget(user, target);
        realTarget.addStatusEffect(new StatusEffect(effectLogic, user));
        String message = String.format("%s applied to %s", effectLogic.getName(), realTarget.getName());
        //target.addStatusEffect(new StatusEffect(effectLogic, user));
        //String message = String.format("%s applied to %s", effectLogic.getName(), target.getName());
        BattleEngine.logAction(message);
        //return String.format("%s applied to %s", effectLogic.getName(), target.getName());
    }
}
