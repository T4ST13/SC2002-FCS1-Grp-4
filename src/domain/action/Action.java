package domain.action;

import domain.actionlogic.ActionLogic;
import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect;

public abstract class Action {
    private final Combatant user;
    private final ActionLogic actionLogic; // abit confusing, but actionLogic is just the name (alot of action logic -.-)

    /* == Constructor == */ 
    public Action(Combatant user, ActionLogic actionLogic) {
        this.user = user;
        this.actionLogic = actionLogic;
    }

    /* Getters */
    public String getName() {
        return this.actionLogic.getName();
    }

    public Combatant getUser() {
        return this.user;
    }

    public ActionLogic getActionLogic() {
        return this.actionLogic;
    }

    public abstract boolean isAvailable();

    public void use(Combatant target) {
        // If not avail e.g. maybe stunned
        if (!isAvailable()) {
            throw new IllegalStateException("Action '" + getName() + "' is not available for " + user.getName() + ".");
        }
        // Activate action
        this.actionLogic.activate(this.user, target);
        //might change to let battle engine pass user and delete user attribute in this class
    }
}
