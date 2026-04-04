package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;

public class ItemLogic {
    protected ItemLogic(String name, boolean selfTarget, boolean endTurn) {
        super(name, selfTarget, endTurn);
    }

    @Override
    public boolean isAvailable(Combatant user) {
        return super.isAvailable(user) && user instanceof Player;
    }

    /* == Check if item used by correct user == */
    protected Player requirePlayerUser(Combatant user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        if (!user.isAlive()) {
            throw new IllegalArgumentException("Defeated combatants cannot act.");
        }

        if (!user.canAct()) {
            throw new IllegalStateException(user.getName() + " cannot act right now.");
        }

        if (!(user instanceof Player)) {
            throw new IllegalArgumentException("Only player-controlled combatants can use items.");
        }

        return (Player) user;
    }

    protected void validateTarget(Combatant target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null.");
        }

        if (!target.isAlive()) {
            throw new IllegalArgumentException("Cannot target a defeated combatant.");
        }
    }
}
