package domain.action.mechanism;

import domain.battle.BattleEngine;
import domain.entity.Combatant;
import domain.effect.StatusEffect;
import domain.effect.EffectLogic;

public class ApplyEffect extends TargetableMechanism{//apply status effect to a target

    private final EffectLogic effectLogic;

    public ApplyEffect(TargetMode targetMode, EffectLogic effectLogic){
        super(targetMode);
        this.effectLogic = effectLogic;
    }

    @Override
    public void execute(Combatant user, Combatant target){
        Combatant realTarget = this.getRealTarget(user, target);
        realTarget.addStatusEffect(new StatusEffect(effectLogic, user));
        String message = String.format("%s applied to %s", effectLogic.getName(), realTarget.getName());
        BattleEngine.logAction(message);
    }
}
