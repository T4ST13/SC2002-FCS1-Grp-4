package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;

public class Skill extends Action {
    private final String description;
    private int remainingCooldown;

    /* == Constructor == */
    public Skill(Player user, SkillLogic skillLogic, String description) {
        super(user, skillLogic);

        if (description == null) {
            throw new IllegalArgumentException("Skill description cannot be null.");
        }

        this.description = description;
        this.remainingCooldown = 0;
    }

    /* == Getters == */
    @Override
    public Player getUser() {
        return (Player) super.getUser();
    }

    @Override
    public SkillLogic getActionLogic() {
        return (SkillLogic) super.getActionLogic();
    }

    public String getDescription() {
        return description;
    }

    public int getBaseCooldown() {
        return getActionLogic().getBaseCooldown();
    }

    public int getRemainingCooldown() {
        return remainingCooldown;
    }

    /* == Skill State == */
    public boolean canUse() {
        return remainingCooldown == 0;
    }

    @Override
    public boolean isAvailable() {
        Player user = getUser();
        return user != null && user.isAlive() && user.canAct() && canUse();
    }

    // Positive value = increase cooldown
    // Negative value = decrease cooldown
    public void changeRemainingCooldown(int change) {
        remainingCooldown += change;

        if (remainingCooldown < 0) {
            remainingCooldown = 0;
        }

        if (remainingCooldown > getBaseCooldown()) {
            remainingCooldown = getBaseCooldown();
        }
    }

    public void startCooldown() {
        remainingCooldown = getBaseCooldown();
    }

    public void resetCooldown() {
        remainingCooldown = 0;
    }

    /* == Use Skill == */
    @Override
    public void trigger(Combatant target) {
        if (!isAvailable()) {
            throw new IllegalStateException(
                "Skill '" + getName() + "' is not currently available for " + getUser().getName() + "."
            );
        }

        // Activate the skill effect
        getActionLogic().activate(getUser(), target);

        // Put skill on cooldown after successful use
        startCooldown();
    }

    @Override
    public String toString() {
        return "Skill [Name =" + getName()
        + ", User =" + getUser().getName()
        + ", remainingCooldown =" + remainingCooldown
        + ", baseCooldown =" + getBaseCooldown() + "]";
    }
}
