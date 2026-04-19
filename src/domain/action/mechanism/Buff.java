package domain.action.mechanism;

import domain.entity.Combatant;
import domain.entity.CombatStat;

public class Buff implements CombatMechanism{//provide stat buffs
    private final CombatStat buffType;//type of stat to be buffed
    private final int buffAmount;

    public Buff(CombatStat buffType, int buffAmount){
        this.buffType = buffType;
        this.buffAmount = buffAmount;
    }

    public void execute(Combatant user, Combatant target){
        target.addBuff(this);
    }

    public boolean needsTarget(Combatant user){
        return false;
    }

    public CombatStat getType(){
        return buffType;
    }

    public int getAmount(){
        return buffAmount;
    }
}
