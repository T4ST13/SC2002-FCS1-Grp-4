package domain.actionlogic;

// Need to import classes since we using protected
import domain.combatant.Combatant;

public abstract class ActionLogic {
    public enum TargetMode {
        SELF, SINGLE, AOE
    }

    private final String name;
    private final boolean selfTarget;
    private final boolean endTurn;

    protected ActionLogic(String name, boolean selfTarget, boolean endTurn) {
        this.name = name;
        this.selfTarget = selfTarget;
        this.endTurn = endTurn;
    }

    /* == Getters == */
    public String getName() {
        return name;
    }

    // Note: Lowkey with targetmode this may be abit redundant
    public boolean isSelfTarget() {
        return selfTarget;
    }

    public boolean isEndTurn() {
        return endTurn;
    }

    public boolean isAvailable(Combatant user) {
        return user != null && user.isAlive() && user.canAct();
    }

    /* == The Action (override in subclasses) == */
    // Getting the Correct Target Mode
    public abstract TargetMode getTargetMode();
    
    public abstract void activate(Combatant user, Combatant target);
}

// TO DO: Add checks (e.g if the user is alive), status effects, skills