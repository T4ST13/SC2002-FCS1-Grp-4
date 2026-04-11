package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;

public abstract class ItemLogic extends ActionLogic{
    private static final boolean CONSUME_TURN = false;//consumeTurn fixed to false for all items
    protected ItemLogic(String name, StatusEffectLogic effectLogic, int maxTarget, boolean effectSelf) {
        super(name, CONSUME_TURN, effectLogic, maxTarget, effectSelf);
    }
}
