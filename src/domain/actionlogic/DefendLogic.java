package domain.actionlogic;

import domain.combatant.Combatant;
import domain.statuseffect.DefendEffect;
import domain.statuseffect.StatusEffect;

public class DefendLogic extends ActionLogic {
    public DefendLogic() {
        super("Defend", true, true); // follows super: ActionLogic(name, selfTarget, endTurn)
    }

    @Override
    public TargetMode getTargetMode() {
        return TargetMode.SELF;
    }

     @Override
    // TO DO: Add checks (e.g. if user is alive)
    public void activate(Combatant user, Combatant target) {
        // Action
        user.addStatusEffect(new StatusEffect(user, new DefendEffect(), DURATION)); 
    }
}
