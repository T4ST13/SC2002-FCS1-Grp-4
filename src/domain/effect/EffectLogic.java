package domain.effect;

import domain.entity.CombatStat;
import domain.action.mechanism.AddFlag;
import domain.action.mechanism.Buff;
import domain.action.mechanism.CombatMechanism;
import domain.action.mechanism.TargetMode;

import java.util.Arrays;
import java.util.List;

public enum EffectLogic {
    //from shared actions
    DEFEND_EFFECT(
        "Defend Effect", 
        2,
        Arrays.asList(
            new Buff(CombatStat.DEF, 10)
        )
    ),

    //from items
    SMK_BOMB_INV(
        "Smoke Bomb Invulnerability",
        2,
        Arrays.asList(
            new AddFlag(TargetMode.SELF, Flag.INVULNERABLE, "Smoke Bomb")//change how you get name later
        )
    ),

    //from skills
    ARC_BLAST_EFFECT(
        "Arcane Blast Effect",//could add end condition in mech list
        -1,
        Arrays.asList(
            new Buff(CombatStat.ATK, 10)
        )
    ),
    STUN(
        "Stun",
        2,
        Arrays.asList(
                new AddFlag(TargetMode.TARGET, Flag.NO_ACTION, "Stun")//change how you get name later
        )
    );

    private final String name;
    private final int baseDuration;//add conditional mechanism for statuseffects that dissapear on conditions (will have to place it in front of mech list and also prevent reading through mech that comes after)
    private final List<CombatMechanism> mechanismList;

    EffectLogic(String name, int baseDuration, List<CombatMechanism> mechanismList){
        this.name = name;
        this.baseDuration = baseDuration;
        this.mechanismList = mechanismList;
    }

    public String getName(){
        return name;
    }

    public int getBaseDuration() {
        return baseDuration;
    }

    public List<CombatMechanism> getMechanismList() {
        return mechanismList;
    }

}