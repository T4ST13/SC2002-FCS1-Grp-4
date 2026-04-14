package domain.actionlogic.mechanism;

import domain.combatant.Combatant;

public class Heal extends TargetableMechanism{

    private final int healAmount;

    public Heal(TargetMode targetMode, int maxTarget, int healAmount){
        super(targetMode, maxTarget);
        this.healAmount = healAmount;
    }

    @Override
    public void execute(Combatant user, Combatant target){
        if (this.getTargetMode() == TargetMode.TARGET){
            target.heal(this.healAmount);
        }
        else{
            user.heal(this.healAmount);
        }
    }
}
