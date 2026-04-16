package domain.phase;

import domain.battleengine.BattleEngine;

public class TriggerEffect extends Phase{
    private BattleEngine engine;

    public TriggerEffect(BattleEngine engine){
        super(engine);
    }
    @Override
    public boolean canEnter() {
        setDone(false);
        return getCurrentAction() == null;
    }

    @Override
    public void execute() {
        getUI().displayMessage(String.format("%s's turn", charInTurn().getName()));
        charInTurn().setupForTurn();
        charInTurn().activateEffects();
        setDone(true);
    }
}
