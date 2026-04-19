package domain.action.logic;

public class SkillLogic extends ActionLogic {
    private static final boolean CONSUME_TURN = true;//consumeTurn fixed to true for all skills
    private static final int BASE_COOLDOWN = 3;//cd fixed to 3 for all skills (need to change if new skills have unique cd)

    public SkillLogic(ActionLogicType logicType) {
        super(logicType, CONSUME_TURN);
    }

    public int getBaseCd() {
        return BASE_COOLDOWN;
    }
}
