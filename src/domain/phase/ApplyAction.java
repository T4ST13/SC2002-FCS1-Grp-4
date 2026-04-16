package domain.phase;

import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;

public class ApplyAction extends Phase{
    public ApplyAction(BattleEngine engine){
        super(engine);
    }
    @Override
    public boolean canEnter() {
        setDone(false);
        return getCurrentTarget() != null;
    }

    @Override
    public void execute() {
        Combatant currentTarget = getCurrentTarget();
        //getUI().displayMessage(getCurrentAction().use(getCurrentTarget()));
        getCurrentAction().use(currentTarget);//revise later for readability
        if (!currentTarget.isAlive()){
            String message = currentTarget.getName() + " defeated";
            BattleEngine.logAction(message);
            if (currentTarget != getEngine().getPlayer()){
                getEngine().getEnemyList().remove(currentTarget);
                getEngine().getCharOrder().remove(currentTarget);
            }
        }
        if (getCurrentAction().isConsumeTurn()){
            getEngine().setTurnDone(true);
        }
        getEngine().setCurrentAction(null);//reset current action and target once they are used
        getEngine().setCurrentTarget(null);
        this.setDone(true);
    }
}
