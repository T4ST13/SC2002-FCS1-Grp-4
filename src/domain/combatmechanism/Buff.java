package domain.actionlogic.mechanism;

import domain.combatant.Combatant;
import domain.combatdata.CombatStat;

public class Buff {

    CombatStat buffType;
    int buffAmount;

    public Buff(CombatStat buffStat, int buffAmount){
        this.buffStat = buffStat;
        this.buffAmount = buffAmount;
    }

    public void execute(Combatant user, Combatant target){
        target.addBuff(this);
    }

    public CombatStat getType(){
        return this.buffType;
    }

    public int getBuff(){
        return this.buffAmount;
    }
}
