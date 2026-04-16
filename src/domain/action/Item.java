package domain.action;

import domain.actionlogic.ItemLogic;
import domain.combatant.Combatant;

import java.util.List;

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

    public String getUnavailableMessage(){
        return "Not enough " + getName() + " in inventory";
        //might change to null since unavailableMessage will never be used for Item objects
    }

    public String getDisplayFormat(){
        return String.format("%s (%d left)", getName(), count);
    }

    /* == Use == */
    @Override
    public /*List<String>*/ void use(Combatant target) {
        //List<String> messages = super.use(target);
        super.use(target);
        this.changeCount(-1);
        if (!isAvailable()){
            getUser().removeItem(this);
        }
        //return messages;
    }
}
