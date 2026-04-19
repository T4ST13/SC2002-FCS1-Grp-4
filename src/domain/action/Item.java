package domain.action;

import domain.action.logic.ItemLogic;
import domain.entity.Combatant;

//holds item specific attributes and methods like count
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
    //will always be true since the item option will not be available if count<1 in the first place

    @Override
    public String getUnavailableMessage(){
        return "Not enough " + getName() + " in inventory";
    }

    @Override
    public String getDisplayFormat(){
        return String.format("%s (%d left)", getName(), count);
    }

    /* == Use == */
    @Override
    public void use(Combatant target) {
        super.use(target);
        this.changeCount(-1);
        if (!isAvailable()){
            getUser().removeItem(this);
        }
    }
}
