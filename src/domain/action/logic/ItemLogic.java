package domain.action.logic;

import domain.displayable.Displayable;

public class ItemLogic extends ActionLogic implements Displayable {
    private static final boolean CONSUME_TURN = false;//consumeTurn fixed to false for all items
    public ItemLogic(ActionLogicType logicType) {
        super(logicType, CONSUME_TURN);
    }

    @Override
    public String getDisplayFormat(){
        return logicType.getName();
    }
}
