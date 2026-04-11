package domain.action;

import domain.actionlogic.ItemLogic;
import domain.combatant.Player;

public class Item extends Action {
    private int count;

    /* == Constructor == */
    public Item(Player user, ItemLogic itemLogic) {
        super(user, itemLogic);
        count = 1;//new item made means it exists
    }

    /* == Getters == */
    public int getCount() {
        return count;
    }

    /* == Setters == */
    public void changeCount(int change) {
        count += change;
    }
    //positive change = count increase
    //negative change = count decrease

    /* == Status == */
    @Override
    public boolean isAvailable() {
        return count > 0;
    }

    /* == Use == */
}
