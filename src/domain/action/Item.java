package domain.action;

import domain.actionlogic.ItemLogic;
import domain.combatant.Combatant;

public class Item extends Action {
    private int count;

    /* == Constructor == */
    public Item(Combatant user, ItemLogic itemLogic) {
        super(user, itemLogic);
        count = 1;//new item made means it exists
    }

    /* == Getters == */
    public int getCount() {
        return this.count;
    }

    /* == Setters == */
    public void changeCount(int change) {
        this.count += change;
    }

    /* == Status == */
    @Override
    public boolean isAvailable() {
        return count > 0;
    }

    /* == Use == */
    @Override
    public void use(Combatant target) {
        super.use(target);
        this.changeCount(-1);
    }
}
