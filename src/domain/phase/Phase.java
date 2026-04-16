package domain.phase;

import domain.UI.UI;
import domain.action.Action;
import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;

import java.util.List;

public abstract class Phase{
    private BattleEngine engine;
    private boolean done = false;

    protected Phase(BattleEngine engine){
        this.engine = engine;;
    }

    public abstract boolean canEnter();

    public abstract void execute();

    public boolean isDone(){
        return done;
    }

    protected void setDone(boolean state){
        done = state;
    }

    public BattleEngine getEngine() {
        return engine;
    }

    protected UI getUI(){
        return engine.getUI();
    }

    protected Combatant charInTurn(){
        return engine.charInTurn();
    }

    protected Action getCurrentAction(){
        return engine.getCurrentAction();
    }

    protected Combatant getCurrentTarget(){
        return engine.getCurrentTarget();
    }

    protected List<Combatant> getEnemyList(){
        return engine.getEnemyList();
    }

    protected Combatant getEnemy(int index){
        return engine.getEnemyList().get(index);
    }
}
