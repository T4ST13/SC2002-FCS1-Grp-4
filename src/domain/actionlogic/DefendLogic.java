package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;
import domain.statuseffectlogic.DefendEffect;

public class DefendLogic extends ActionLogic {
    private static final String NAME = "Defend";
    private static final boolean CONSUME_TURN = true;//basic attacks consume turn
    private static final StatusEffectLogic EFFECT_LOGIC = new DefendEffect();
    private static final int MAX_TARGET = 1;
    private static final boolean EFFECT_SELF = true;
    public DefendLogic() {
        super(NAME, CONSUME_TURN, EFFECT_LOGIC, MAX_TARGET, EFFECT_SELF);
    }
}
