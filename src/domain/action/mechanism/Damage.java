package domain.action.mechanism;

import domain.battle.BattleEngine;
import domain.entity.Combatant;
import domain.entity.CombatStat;
import domain.effect.Flag;

public class Damage extends TargetableMechanism {//deals damage

    public Damage(TargetMode targetMode){
        super(targetMode);
    }

    protected int calcDmg(Combatant user, Combatant target){
        if (getTargetMode() == TargetMode.TARGET)
            return Math.min(target.getCurrentHP(), user.getFinalStat(CombatStat.ATK) - target.getFinalStat(CombatStat.DEF));
        else{
            //don't reflect DEF if it is self-damage (but there's no self damage at this point of development)
            return Math.min(user.getCurrentHP(), user.getFinalStat(CombatStat.ATK));
        }
    }

    @Override
    public void execute(Combatant user, Combatant target){
        Combatant realTarget = this.getRealTarget(user, target);
        int damage = calcDmg(user, realTarget);
        String effectName = realTarget.hasFlag(Flag.INVULNERABLE);
        String message;
        if (effectName != null){//deals no damage if target has INVULNERABLE flag
            damage = 0;
            message = String.format("%s is invulnerable due to %s", realTarget.getName(), effectName);
            BattleEngine.logAction(message);
        }
        realTarget.takeDamage(damage);
        message = String.format("%s attacked %s (DMG: %d)", user.getName(), realTarget.getName(), damage);
        BattleEngine.logAction(message);
        message = String.format("%s HP: %d", realTarget.getName(), realTarget.getCurrentHP());
        BattleEngine.logAction(message);
    }
}
