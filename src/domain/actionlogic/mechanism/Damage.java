package domain.actionlogic.mechanism;

import domain.combatant.Combatant;
import domain.combatdata.CombatStat;

public class Damage extends TargetableMechanism {

    public Damage(TargetMode targetMode, int maxTarget){
        super(targetMode, maxTarget);
    }

    protected int calcDmg(Combatant user, Combatant target){
        if (this.getTargetMode() == TargetMode.TARGET)
            return Math.max(0, user.getStat(CombatStat.ATK) - target.getStat(CombatStat.DEF));
        else{
            return user.getStat(CombatStat.ATK);//will have to change to fixed stat
        }
    }

    @Override
    public void execute(Combatant user, Combatant target){
        if (this.getTargetMode() == TargetMode.TARGET) {
            target.takeDamage(this.calcDmg(user, target));
        }
        else{
            target.takeDamage(this.calcDmg(user, target));
        }
    }
}
