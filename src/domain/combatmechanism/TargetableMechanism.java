package domain.combatmechanism;

import domain.combatant.Combatant;

public abstract class TargetableMechanism implements CombatMechanism {

    private final TargetMode targetMode;
    private final int maxTarget;//might move to different class (grouped behavior)
    private final int area;

    public TargetableMechanism(TargetMode targetMode, int maxTarget, int area){
        this.targetMode = targetMode;
        this.maxTarget = maxTarget;
        this.area = area;
    }

    public TargetMode getTargetMode(){
        return this.targetMode;
    }

    public int getMaxTarget() {
        return maxTarget;
    }

    public int getArea() {
        return area;
    }

    @Override
    public boolean needsTarget(Combatant user) {
        return this.targetMode == TargetMode.TARGET;
    }

    public Combatant getRealTarget(Combatant user, Combatant target){
        if (getTargetMode() == TargetMode.TARGET){
            return target;
        }
        else{
            return user;
        }
    }

    public abstract void execute(Combatant user, Combatant target);
}
