package domain.actionlogic.mechanism;

import domain.combatant.Combatant;

public abstract class TargetableMechanism implements CombatMechanism {

    private final TargetMode targetMode;
    private final int maxTarget;//might move to different class (grouped behavior)

    public TargetableMechanism(TargetMode targetMode, int maxTarget){
        this.targetMode = targetMode;
        this.maxTarget = maxTarget;
    }

    public TargetMode getTargetMode(){
        return this.targetMode;
    }

    public int getMaxTarget() {
        return maxTarget;
    }

    public abstract void execute(Combatant user, Combatant target);
}
