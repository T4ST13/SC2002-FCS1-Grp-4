package domain.phase;

import domain.battleengine.BattleEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhaseFlow {
    private int phaseIndex=0;
    private List<Phase> phaseFlow = new ArrayList<>();

    public PhaseFlow(BattleEngine engine){
        phaseFlow.addAll(Arrays.asList(
                new TriggerEffect(engine),
                new ChooseAction(engine),
                new ChooseTarget(engine),
                new ApplyAction(engine),
                new EndTurn(engine)
            )
        );
    }

    public Phase getNext(){
        phaseIndex %= phaseFlow.size();
        phaseFlow.get(phaseIndex);
        return phaseFlow.get(phaseIndex++);
    }
}
