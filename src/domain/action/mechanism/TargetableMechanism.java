package domain.action.mechanism;

import domain.entity.Combatant;

//inherited by mechanisms that allow targetting
public abstract class TargetableMechanism implements CombatMechanism {

    private final TargetMode targetMode;

    public TargetableMechanism(TargetMode targetMode){
        this.targetMode = targetMode;
    }

    public TargetMode getTargetMode(){
        return this.targetMode;
    }


    @Override
    public boolean needsTarget(Combatant user) {
        return this.targetMode == TargetMode.TARGET;//needs target if target mode is specified as such
    }

    //some mechanisms might available for both target and self target
    //(ex. ApplyEffect can be used to apply effect to a target (ex. Shield Bash) or the user (ex. Arcane Blast)
    //because we are passing both user and target as parameters for the execute method, we have to determine which one is the real target
    protected Combatant getRealTarget(Combatant user, Combatant target){
        if (getTargetMode() == TargetMode.TARGET){
            return target;
        }
        else{
            return user;
        }
    }

    public abstract void execute(Combatant user, Combatant target);
}
