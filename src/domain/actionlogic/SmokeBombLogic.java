package domain.actionlogic;

import domain.statuseffectlogic.SmokeInvEffect;
import domain.statuseffectlogic.StatusEffectLogic;

public class SmokeBombLogic extends ItemLogic {
    private static final String NAME = "Smoke Bomb";
    private static final StatusEffectLogic EFFECT_LOGIC = new SmokeInvEffect();//smoke bomb invulnerability = smoke bomb effect?
    private static final int MAX_TARGET = -1;
    private static final boolean EFFECT_SELF = true;

    public SmokeBombLogic() {
        super(NAME, EFFECT_LOGIC, MAX_TARGET, EFFECT_SELF);
    }
}
