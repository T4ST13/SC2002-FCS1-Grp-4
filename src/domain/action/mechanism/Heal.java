package domain.action.mechanism;

import domain.battle.BattleEngine;
import domain.entity.Combatant;
import domain.entity.CombatStat;

public class Heal extends TargetableMechanism{

    private final int healAmount;

    public Heal(TargetMode targetMode, int healAmount){
        super(targetMode);
        this.healAmount = healAmount;
    }

    protected int calcHeal(Combatant user, Combatant realTarget){
        return Math.min(realTarget.getBaseStat(CombatStat.HP)-realTarget.getCurrentHP(), healAmount);
    }

    @Override
    public void execute(Combatant user, Combatant target){
        Combatant realTarget = this.getRealTarget(user, target);
        int actualHeal = calcHeal(user, realTarget);
        realTarget.heal(actualHeal);
        String message = String.format("%s healed %s (Heal: %d)", user.getName(), realTarget.getName(), actualHeal);
        BattleEngine.logAction(message);
    }
}
