package domain.action;

import domain.action.logic.ActionLogic;
import domain.battle.BattleEngine;
import domain.entity.Combatant;
import domain.action.mechanism.CombatMechanism;
import domain.displayable.Displayable;

import java.util.ArrayList;
import java.util.List;

//holds logic for an action + attributes unique to each action
public abstract class Action implements Displayable {
    private final Combatant user;
    private final ActionLogic actionLogic;
    private List<CombatMechanism> mechanismList;

    /* == Constructor == */ 
    protected Action(Combatant user, ActionLogic actionLogic) {
        this.user = user;
        this.actionLogic = actionLogic;
        this.mechanismList = new ArrayList<>(actionLogic.getLogicType().getMechanismList());
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

    public void addMechanism(CombatMechanism mechanism){
        mechanismList.add(mechanism);
    }

    public void resetMechanism(){
        mechanismList = new ArrayList<>(actionLogic.getLogicType().getMechanismList());
    }

    public void use(Combatant target) {
        if (!isAvailable()) {
            BattleEngine.logAction(getUnavailableMessage());
            return;
        }
        for (CombatMechanism mechanism : mechanismList) {
            mechanism.execute(user, target);
        }
        this.resetMechanism();
    }

    public abstract boolean isAvailable();

    public abstract String getUnavailableMessage();
}
