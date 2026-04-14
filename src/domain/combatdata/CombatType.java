package domain.combatdata;

import java.util.HashMap;
import java.util.Map;

public enum CombatType {
    //Playable Char
    WARRIOR("Warrior", 260, 40, 20, 30),
    WIZARD("Wizard", 200, 50, 10, 20),

    //Enemy Char
    GOBLIN("Goblin", 55, 35, 15, 25),
    WOLF("Wolf", 40, 45, 5, 35);

    private final String name;
    private final Map<CombatStat, Integer> baseStatMap = new HashMap<>();//HashMap doesn't accept primitive types, so need to wrap int -> Integer

    CombatType(String name, int baseHP, int baseATK, int baseDEF, int baseSPD) {
        this.name = name;
        baseStatMap.put(CombatStat.HP, baseHP);
        baseStatMap.put(CombatStat.ATK, baseATK);
        baseStatMap.put(CombatStat.DEF, baseDEF);
        baseStatMap.put(CombatStat.SPD, baseSPD);
    }
    
    public String getName(){
        return this.name;
    }

    public int getBaseStat(CombatStat combatStat){
        return baseStatMap.get(combatStat);
    }
}
