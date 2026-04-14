package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;
import domain.statuseffectlogic.DefendEffect;

public class DefendLogic extends SharedActionLogic {
    private static final String NAME = "Defend";
    private static final boolean CONSUME_TURN = true;//basic attacks consume turn
    private static final StatusEffectLogic EFFECT_LOGIC = new DefendEffect();
    private static final int MAX_TARGET = 1;
    private static final boolean EFFECT_SELF = true;
    public DefendLogic() {
        super(NAME, EFFECT_LOGIC, MAX_TARGET);
    }
}
