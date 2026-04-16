package domain.combatmechanism;

import domain.combatant.Combatant;
import domain.combatdata.CombatStat;

public class Buff implements CombatMechanism{

    private final CombatStat buffType;
    private final int buffAmount;

    public Buff(CombatStat buffType, int buffAmount){
        this.buffType = buffType;
        this.buffAmount = buffAmount;
    }

    public /*String*/ void execute(Combatant user, Combatant target){
        target.addBuff(this);
        //return "";
    }
    /*user and target will receive the same object (Combatant that is in turn) from the BattleEngine
    because Buff objects will only be executed when going through effectList of a Combatant*/

    public boolean needsTarget(Combatant user){//might need to update mechanism for determining needsTarget
        return false;
    }

    public CombatStat getType(){
        return buffType;
    }

    public int getAmount(){
        return buffAmount;
    }
}
