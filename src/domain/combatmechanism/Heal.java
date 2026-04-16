package domain.combatmechanism;

import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;
import domain.combatdata.CombatStat;

public class Heal extends TargetableMechanism{

    private final int healAmount;

    public Heal(TargetMode targetMode, int maxTarget, int area, int healAmount){
        super(targetMode, maxTarget, area);
        this.healAmount = healAmount;
    }

    protected int calcHeal(Combatant user, Combatant realTarget){
        return Math.min(realTarget.getBaseStat(CombatStat.HP)-realTarget.getCurrentHP(), healAmount);
    }

    @Override
    public /*String*/ void execute(Combatant user, Combatant target){
//        if (getTargetMode() == TargetMode.TARGET){
//            target.heal(healAmount);
//        }
//        else{
//            user.heal(healAmount);
//        }
        Combatant realTarget = this.getRealTarget(user, target);
        int actualHeal = calcHeal(user, realTarget);
        realTarget.heal(actualHeal);
        String message = String.format("%s healed %s (Heal: %d)", user.getName(), realTarget.getName(), actualHeal);
        BattleEngine.logAction(message);
        //return String.format("%s healed %s (Heal: %d)", user.getName(), target.getName(), healAmount);
    }
}
