package domain.battle.phase;

import domain.action.Action;
import domain.battle.BattleEngine;
import domain.effect.Flag;

public class ChooseAction extends Phase {//phase where combatant in turn chooses action

    public ChooseAction(BattleEngine engine){
        super(engine);
    }
    @Override
    public boolean canEnter() {
        String effectName = charInTurn().hasFlag(Flag.NO_ACTION);
        setDone(false);
        if (effectName == null && !getEngine().isTurnDone()) {
            return true;
        } else {
            getEngine().setTurnDone(true);
            if (effectName != null)
                BattleEngine.logAction(String.format("%s cannot act due to %s", charInTurn().getName(), effectName));
            return false;
        }
    }

    @Override
    public void execute() {
        Action chosenAction;
        if (charInTurn() == getEngine().getPlayer()) {//if player turn, choose action
            getUI().displayOptions(charInTurn().getActionList());
            int userChoice = getUI().getInput();
            chosenAction = charInTurn().getAction(userChoice);
        }
        else{//if enemy turn, action is fixed to basic attack
            chosenAction = charInTurn().getAction(0);
        }
        if (chosenAction.isAvailable()){
            getEngine().setCurrentAction(chosenAction);
            setDone(true);
        }
        else {
            getUI().displayMessage(chosenAction.getUnavailableMessage());
        }
    }
}
