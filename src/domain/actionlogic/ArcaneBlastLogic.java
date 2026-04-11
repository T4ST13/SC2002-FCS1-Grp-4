package domain.actionlogic;

import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect;
import domain.statuseffectlogic.ArcaneBlastEffect;
import domain.statuseffectlogic.StatusEffectLogic;

public class ArcaneBlastLogic extends SkillLogic {
    private static final String NAME = "Arcane Blast";
    private static final StatusEffectLogic EFFECT_LOGIC = new ArcaneBlastEffect();//arcane blast has arcane blast effect
    private static final int MAX_TARGET = 1;
    private static final boolean EFFECT_SELF = true;

    public ArcaneBlastLogic() {
        super(NAME, EFFECT_LOGIC, MAX_TARGET, EFFECT_SELF);
    }

    public void applyEffect(Combatant target){
        if(!target.isAlive()){//required condition for ArcaneBlast status effect to be applied = target is defeated
            super.applyEffect(target);
        }
    }
}
