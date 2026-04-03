package domain.actionlogic;

import domain.combatant.Combatant;

public class BasicAttackLogic extends ActionLogic {
    public BasicAttackLogic() {
        super("Basic Attack", false, true); // follows super: ActionLogic(name, selfTarget, endTurn)
    }

    @Override
    public TargetMode getTargetMode() {
        return TargetMode.SINGLE;
    }

    @Override
    // TO DO: Add checks (e.g. if user is alive)
    public void activate(Combatant user, Combatant target) {
        // Action
        int damage = user.calcDamage(target);
        target.takeDamage(damage);
    }
}
