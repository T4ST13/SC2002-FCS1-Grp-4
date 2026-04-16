package domain.actionlogic;

public class ItemLogic extends ActionLogic{//add a static cooldown?
    private static final boolean CONSUME_TURN = false;//consumeTurn fixed to false for all items
    public ItemLogic(ActionLogicType logicType) {
        super(logicType, CONSUME_TURN);
    }
}
