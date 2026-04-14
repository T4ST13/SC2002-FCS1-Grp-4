package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;

public class BasicAttackLogic extends SharedActionLogic {
    private static final String NAME = "Basic Attack";
    private static final boolean CONSUME_TURN = true;//basic attacks consume turn
    private static final StatusEffectLogic EFFECT_LOGIC = null;
    private static final int MAX_TARGET = 1;
    private static final boolean EFFECT_SELF = false;
    public BasicAttackLogic() {
        super(NAME, EFFECT_LOGIC, MAX_TARGET);
    }
}
