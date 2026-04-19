package domain.action.logic;

import java.util.ArrayList;

public class ItemOptions {//used to display items when player chooses them before battle
    private static ArrayList<ItemLogic> itemOptions = new ArrayList<>();

    public static ArrayList<ItemLogic> getItemOptions(){
        if (itemOptions.isEmpty()) {
            for (ActionLogicType logicType : ActionLogicType.values()) {
                if (logicType.getActionType() == ActionType.ITEM) {
                    itemOptions.add(new ItemLogic(logicType));
                }
            }
        }
        return itemOptions;
    }
}