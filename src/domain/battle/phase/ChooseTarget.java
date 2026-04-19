package domain.battle.phase;

import domain.battle.BattleEngine;
import domain.entity.Combatant;

public class ChooseTarget extends Phase{//phase where combatant in turn chooses target for the chosen action

    public ChooseTarget(BattleEngine engine){
        super(engine);
    }

    public boolean canEnter(){
        setDone(false);
        return getCurrentAction() != null;
    }

    @Override
    public void execute(){
        Combatant target;
        if (charInTurn() == getEngine().getPlayer())
            if (getCurrentAction().needsTarget()) {//if action requires user to determine target, ask for target
                getUI().displayOptions(getEnemyList());
                int userChoice = getUI().getInput();
                target = getEnemy(userChoice);
                getEngine().setCurrentTarget(target);
            }
            else{//if action does not require target(=self target), set character in turn as target
                getEngine().setCurrentTarget(charInTurn());
            }
        else{
            target = getEngine().getPlayer();
            getEngine().setCurrentTarget(target);//change for readability
        }
        this.setDone(true);
    }
}
