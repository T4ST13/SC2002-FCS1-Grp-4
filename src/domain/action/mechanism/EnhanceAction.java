package domain.action.mechanism;

import domain.action.Action;
import domain.action.logic.ActionLogicType;
import domain.battle.BattleEngine;
import domain.entity.Combatant;

//new feature
//adds a desired mechanism to an action (such as adding stun effect to basic attack)
public class EnhanceAction implements CombatMechanism{
    ActionLogicType templateLogic;
    CombatMechanism newMechanism;
    public EnhanceAction(ActionLogicType templateLogic, CombatMechanism newMechanism){
        this.templateLogic = templateLogic;//the action to be enhanced
        this.newMechanism = newMechanism;//the new mechanism to be added to the target action
    }

    public boolean needsTarget(Combatant user){
        return false;
    }

    public void execute(Combatant user, Combatant target){
        Action targetAction = null;
        for (Action action : target.getActionList()){
            if (action.getName().equals(templateLogic.getName())){
                targetAction = action;//find the target action within the combatant's action list
                break;
            }
        }
        targetAction.addMechanism(newMechanism);//add the new mechanism
        String message = String.format("%s's %s upgraded", target.getName(), targetAction.getName());
        BattleEngine.logAction(message);
    }
}
