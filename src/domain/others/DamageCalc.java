package domain.others;

import domain.combatant.Combatant;
import domain.combatdata.CombatStat;

public class DamageCalc {
    public static int calculate(Combatant attacker, Combatant target){
        return attacker.getStat(CombatStat.ATK) - target.getStat(CombatStat.DEF);
    }
}
