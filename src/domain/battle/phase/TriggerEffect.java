package domain.battle.phase;

import domain.battle.BattleEngine;

//very first phase when a character's turn comes
//applies status effect regardless of whether the character can act
public class TriggerEffect extends Phase{
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
