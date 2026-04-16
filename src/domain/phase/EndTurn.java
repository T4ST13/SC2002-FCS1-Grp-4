package domain.phase;

import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;

public class EndTurn extends Phase{
    public EndTurn (BattleEngine engine){
        super(engine);
    }

    public boolean canEnter(){
        setDone(false);
        return getEngine().isTurnDone();
    }

    @Override
    public void execute(){
        charInTurn().finishTurn();
        for (Combatant combatant : getEngine().getCharOrder()){
            if (combatant != charInTurn()){
                combatant.updateActionMeter();
            }
        }
        getEngine().setTurnDone(false);//set turnDone to false for the upcoming turn
        setDone(true);
    }
}
