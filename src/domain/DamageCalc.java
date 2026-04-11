package domain;

import domain.combatant.Combatant;

public class DamageCalc {
    public static int calculate(Combatant attacker, Combatant target){
        return attacker.getStat(CombatStat.ATK) - target.getStat(CombatStat.DEF);
    }
}
