package domain.actionlogic;

import domain.statuseffectlogic.StatusEffectLogic;

public abstract class SkillLogic extends ActionLogic {
    private static final boolean CONSUME_TURN = true;//consumeTurn fixed to true for all skills
    private static final int BASE_COOLDOWN = 3;//cd fixed to 3 for all skills (need to change if new skills have unique cd)

    protected SkillLogic(String name, StatusEffectLogic effectLogic, int maxTarget, boolean effectSelf) {
        super(name, CONSUME_TURN, effectLogic, maxTarget);
    }

    public int getBaseCooldown() {
        return BASE_COOLDOWN;
    }
}
