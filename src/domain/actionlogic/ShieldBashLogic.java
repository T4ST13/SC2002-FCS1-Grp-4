package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;
import domain.statuseffectlogic.StunEffect;

public class ShieldBashLogic extends SkillLogic {
    private static final String NAME = "Shield Bash";
    private static final StatusEffectLogic EFFECT_LOGIC = new StunEffect();//shield bash has stun effect
    private static final int MAX_TARGET = 1;
    private static final boolean EFFECT_SELF = false;

    public ShieldBashLogic() {
        super(NAME, EFFECT_LOGIC, MAX_TARGET, EFFECT_SELF);
    }
}
