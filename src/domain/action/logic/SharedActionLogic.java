package domain.action.logic;

public class SharedActionLogic extends ActionLogic {//common/basic action like basic attack or defend
    private static final boolean CONSUME_TURN = true;//consumeTurn fixed to true for all skills

    public SharedActionLogic(ActionLogicType logicType) {
        super(logicType, CONSUME_TURN);
    }
}

