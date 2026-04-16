package domain.action;

import domain.actionlogic.ActionLogic;
import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;
import domain.displayable.Displayable;

import java.util.List;

public abstract class Action implements Displayable {
    private final Combatant user;
    private final ActionLogic actionLogic;

    /* == Constructor == */ 
    public Action(Combatant user, ActionLogic actionLogic) {
        this.user = user;
        this.actionLogic = actionLogic;
    }

    /* Getters */
    public String getName() {
        return actionLogic.getName();
    }

    public boolean isConsumeTurn() {
        return actionLogic.isConsumeTurn();
    }

    public boolean needsTarget() {
        return actionLogic.needsTarget(user);
    }

    public Combatant getUser() {
        return user;
    }

    public ActionLogic getActionLogic() {
        return actionLogic;
    }

    public abstract boolean isAvailable();

    public abstract String getUnavailableMessage();

    public /*List<String>*/ void use(Combatant target) {
//        // If not avail e.g. maybe stunned
//        if (!isAvailable()) {
//            return Arrays.asList(getUnavailableMessage());
//        }
//        // Activate action
//        return actionLogic.activate(user, target);
//        //might change to let battle engine pass user and delete user attribute in this class
        // If not avail e.g. maybe stunned
        if (!isAvailable()) {
            BattleEngine.logAction(getUnavailableMessage());
        }
        // Activate action
        actionLogic.activate(user, target);
        //might change to let battle engine pass user and delete user attribute in this class
    }
}
