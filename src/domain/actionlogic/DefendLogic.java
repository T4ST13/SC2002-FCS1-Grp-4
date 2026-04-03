package domain.actionlogic;

import domain.combatant.Combatant;

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
        user.addDefenseModifier(10); // placeholder no., in future whatever gives def boost update var name in () to match 
    }
}
