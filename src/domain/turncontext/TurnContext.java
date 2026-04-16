package domain.turncontext;

import domain.UI.UI;
import domain.action.Action;
import domain.combatant.Combatant;

public class TurnContext {
    private final UI userInterface;
    private final Combatant charInTurn;
    private Combatant target;
    private Action chosenAction;

    public TurnContext(UI userInterface, Combatant charInTurn){
        this.userInterface = userInterface;
        this.charInTurn = charInTurn;
    }

    public UI getUI() {
        return this.userInterface;
    }

    public Combatant getCharInTurn() {
        return charInTurn;
    }

    public Combatant getTarget(){
        return this.target;
    }

    public void setTarget(Combatant target){
        this.target = target;
    }

    public Action getAction(){
        return this.chosenAction;
    }

    public void setAction(Action action){
        this.chosenAction = action;
    }


}
