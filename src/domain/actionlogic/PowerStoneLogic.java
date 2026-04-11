package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;

public class PowerStoneLogic extends ItemLogic {
    private static final String NAME = "Power Stone";
    private static final StatusEffectLogic EFFECT_LOGIC = null;//power stone does not incur a status effect byitself
    private static final int MAX_TARGET = -1;//maxTarget = -1 means self target
    private static final boolean EFFECT_SELF = false;// separate status effect

    public PowerStoneLogic(){
        super(NAME, EFFECT_LOGIC, MAX_TARGET, EFFECT_SELF);
    }
}
