package domain.combatmechanism;

import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;
import domain.combatdata.CombatStat;
import domain.effectlogic.Flag;

public class Damage extends TargetableMechanism {

    public Damage(TargetMode targetMode, int maxTarget, int area){
        super(targetMode, maxTarget, area);
    }

    protected int calcDmg(Combatant user, Combatant target){
        if (getTargetMode() == TargetMode.TARGET)
            return Math.min(target.getCurrentHP(), user.getFinalStat(CombatStat.ATK) - target.getFinalStat(CombatStat.DEF));
        else{
            return Math.min(user.getCurrentHP(), user.getFinalStat(CombatStat.ATK));//might have to change to fixed stat
        }
    }

    @Override
    public /*String*/ void execute(Combatant user, Combatant target){
        Combatant realTarget = this.getRealTarget(user, target);
        int damage = calcDmg(user, realTarget);
        String effectName = realTarget.hasFlag(Flag.INVULNERABLE);
        String message;
        if (effectName != null){
            damage = 0;
            message = String.format("%s is invulnerable due to %s", realTarget.getName(), effectName);
            BattleEngine.logAction(message);
        }
        realTarget.takeDamage(damage);
        message = String.format("%s attacked %s (DMG: %d)", user.getName(), realTarget.getName(), damage);
        BattleEngine.logAction(message);
        message = String.format("%s HP: %d", realTarget.getName(), realTarget.getCurrentHP());
        BattleEngine.logAction(message);
        //return String.format("%s attacked %s (DMG: %d)", user.getName(), realTarget.getName(), damage);
    }
}
