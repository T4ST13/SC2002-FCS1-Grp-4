package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;

public class SharedActionLogic extends ActionLogic {
    private static final boolean CONSUME_TURN = true;//consumeTurn fixed to true for all skills

    protected SharedActionLogic(String name, StatusEffectLogic effectLogic, int maxTarget) {
        super(name, CONSUME_TURN, effectLogic, maxTarget);
    }
}

