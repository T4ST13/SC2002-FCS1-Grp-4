package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;

public class Item extends Action {
    private int count;

    /* == Constructor == */
    public Item(Player user, ItemLogic itemLogic, int count) {
        super(user, itemLogic);

        if (count < 0) {
            throw new IllegalArgumentException("Item count cannot be negative.");
        }

        this.count = count;
    }

    /* == Getters == */
    @Override
    public Player getUser() {
        return (Player) super.getUser();
    }

    @Override
    public ItemLogic getActionLogic() {
        return (ItemLogic) super.getActionLogic();
    }

    public int getCount() {
        return count;
    }

    /* == Item State == */
    public boolean canUse() {
        return count > 0;
    }

    @Override
    public boolean isAvailable() {
        Player user = getUser();
        return user != null && user.isAlive() && user.canAct() && canUse();
    }

    // Positive value = gain items
    // Negative value = consume items
    public void changeCount(int change) {
        count += change;

        if (count < 0) {
            count = 0;
        }
    }

    /* == Use Item == */
    @Override
    public void trigger(Combatant target) {
        if (!isAvailable()) {
            throw new IllegalStateException(
                "Item '" + getName() + "' is not currently available for " + getUser().getName() + "."
            );
        }

        // Activate item effect first
        getActionLogic().activate(getUser(), target);

        // Only consume item after successful use
        changeCount(-1);
    }

    @Override
    public String toString() {
        return "Item [Name =" + getName()
        + ", User =" + getUser().getName()
        + ", count =" + count + "]";
    }
}
