package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;

public class PotionLogic extends ItemLogic {
    private static final String NAME = "Potion";
    private static final StatusEffectLogic EFFECT_LOGIC = null;//potion does not incur a special status effect
    private static final int MAX_TARGET = -1;//maxTarget = -1 means self target
    private static final boolean EFFECT_SELF = false;// separate status effect

    public PotionLogic(){
        super(NAME, EFFECT_LOGIC, MAX_TARGET, EFFECT_SELF);
    }
}
