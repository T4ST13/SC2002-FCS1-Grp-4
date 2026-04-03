package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;

public abstract class SkillLogic extends ActionLogic {
    private final int baseCooldown;

    protected SkillLogic(String name, boolean selfTarget, boolean endTurn, int baseCooldown) {
        super(name, selfTarget, endTurn);
        this.baseCooldown = baseCooldown;
    }

    public int getBaseCooldown() {
        return baseCooldown;
    }

    @Override
    public boolean isAvailable(Combatant user) {
        return super.isAvailable(user) && user instanceof Player && ((Player) user).canUseSpecial();
    }

    /* == Check if skills interacting with correct targets */
    protected Player requirePlayerUser(Combatant user) {
        if (!(user instanceof Player)) {
            throw new IllegalArgumentException("Only player-controlled combatants can use skills.");
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
