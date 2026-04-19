package domain.battle.phase;

import domain.battle.BattleEngine;

//phase to perform things like updating skill cds and resetting variables for upcoming turn
public class EndTurn extends Phase{
    public EndTurn (BattleEngine engine){
        super(engine);
    }

    @Override
    public boolean canEnter() {
        setDone(false);
        return getEngine().isTurnDone();
    }

    @Override
    public void execute(){
        charInTurn().finishTurn();
        getEngine().setCurrentAction(null);//reset current action and target once they are used
        getEngine().setCurrentTarget(null);
        getEngine().setTurnDone(false);//set turnDone to false for the upcoming turn

        getEngine().nextChar();

        setDone(true);
    }
}

