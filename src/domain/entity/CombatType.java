package domain.entity;

import domain.displayable.Displayable;

import java.util.HashMap;
import java.util.Map;

public enum CombatType implements Displayable {//stores names and stat configuration of each combatant type
    //Playable Char
    WARRIOR("Warrior", 260, 40, 20, 30, true),
    WIZARD("Wizard", 200, 50, 10, 20, true),

    //Enemy Char
    GOBLIN("Goblin", 55, 35, 15, 25, false),
    WOLF("Wolf", 40, 45, 5, 35, false);

    private final String name;
    //map stat values to the stat type = easier to access (don't have to make a getter for every single stat type)
    private final Map<CombatStat, Integer> baseStatMap = new HashMap<>();
    private final boolean playable;
    CombatType(String name, int baseHP, int baseATK, int baseDEF, int baseSPD, boolean playable) {
        this.name = name;
        baseStatMap.put(CombatStat.HP, baseHP);
        baseStatMap.put(CombatStat.ATK, baseATK);
        baseStatMap.put(CombatStat.DEF, baseDEF);
        baseStatMap.put(CombatStat.SPD, baseSPD);
        this.playable = playable;
    }
    
    public String getName(){
        return this.name;
    }

    public int getBaseStat(CombatStat combatStat){
        return baseStatMap.get(combatStat);
    }

    public boolean isPlayable(){
        return playable;
    }

    public String getDisplayFormat(){
        return getName();
    }
}
