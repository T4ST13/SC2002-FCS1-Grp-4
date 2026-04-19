package domain.battle.phase;

import domain.battle.BattleEngine;
import domain.entity.Combatant;

public class ApplyAction extends Phase{//phase where chosen action is applied to the chosen target
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
        getCurrentAction().use(currentTarget);
        if (!currentTarget.isAlive()){
            String message = currentTarget.getName() + " defeated";
            BattleEngine.logAction(message);
            if (currentTarget != getEngine().getPlayer()){
                getEngine().getEnemyList().remove(currentTarget);
            }
        }
        if (getCurrentAction().isConsumeTurn()){
            getEngine().setTurnDone(true);
        }
        getEngine().setCurrentAction(null);
        getEngine().setCurrentTarget(null);
        this.setDone(true);
    }
}

