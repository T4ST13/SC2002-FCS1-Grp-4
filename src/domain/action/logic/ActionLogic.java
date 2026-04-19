package domain.action.logic;

import domain.entity.Combatant;
import domain.action.mechanism.CombatMechanism;

public abstract class ActionLogic{//holds logic for an action

    ActionLogicType logicType;
    private final boolean consumeTurn;

    protected ActionLogic(ActionLogicType logicType, boolean consumeTurn) {//might need to include consumeTurn into enum
        this.logicType = logicType;
        this.consumeTurn = consumeTurn;
    }

    /* == Getters == */
    public ActionLogicType getLogicType(){
        return logicType;
    }
    public String getName() {
        return this.logicType.getName();
    }

    public boolean isConsumeTurn() {
        return this.consumeTurn;
    }

    public boolean needsTarget(Combatant user) {
        for (CombatMechanism mechanism : logicType.getMechanismList()){
            if (mechanism.needsTarget(user)){
                return true;
            }
        }
        return false;
    }
}
