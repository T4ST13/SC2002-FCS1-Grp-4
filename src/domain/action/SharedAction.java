package domain.action;

import domain.actionlogic.SharedActionLogic;
import domain.combatant.Combatant;

public class SharedAction extends Action{
    /* == Constructor == */
    public SharedAction(Combatant user, SharedActionLogic sharedActionLogic) {
        super(user, sharedActionLogic);
    }

    @Override
    public boolean isAvailable(){
        return true;//shared action like basic attack or defend are always available in a turn
    }
}
