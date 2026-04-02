package domain.actionlogic;

import domain.combatant.Combatant;

public class Action {
    private final Combatant user;
    private final ActionLogic actionLogic; // abit confusing, but actionLogic is just the name (alot of action logic -.-)

    /* == Constructor == */ 
    public Action(Combatant user, ActionLogic actionLogic) {
        this.user = user;
        this.actionLogic = actionLogic;
    }

    /* Getters */
    public Combatant getUser() {
        return user;
    }

    public ActionLogic getActionLogic() {
        return actionLogic;
    }

    public String getName() {
        return actionLogic.getName();
    }

    public boolean isAvailable() {
        return actionLogic.isAvailable(user);
    }

    // Triggers action on target, NOT self 
    public void trigger(Combatant target) { 
        // If not avail e.g. maybe stunned
        if (!isAvailable()) {
            throw new IllegalStateException("Action '" + getName() + "' is not currently available for " + user.getName() + ".");
        }

        // Activate action
        actionLogic.activate(user, target);

        @Override 
        public String toString() {
            return "Action [Name =" + getName() 
            + ", User =" + user.getName()
            + ", selfTarget =" + actionLogic.isSelfTarget()
            + ", endTurn =" + actionLogic.isEndTurn() +"]";
        }
    }
}
