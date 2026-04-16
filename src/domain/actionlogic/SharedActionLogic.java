package domain.actionlogic;

public class SharedActionLogic extends ActionLogic {
    private static final boolean CONSUME_TURN = true;//consumeTurn fixed to true for all skills

    public SharedActionLogic(ActionLogicType logicType) {
        super(logicType, CONSUME_TURN);
    }
}

