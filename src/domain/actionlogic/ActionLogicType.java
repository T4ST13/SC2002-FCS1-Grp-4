package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatdata.CombatStat;
import domain.combatmechanism.*;
import domain.condition.Defeated;
import domain.displayable.Displayable;
import domain.effectlogic.EffectLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ActionLogicType implements Displayable {
    //Shared Action Logic
    BASIC_ATTACK_LOGIC(
        "Basic Attack",
        Arrays.asList(
            new Damage(TargetMode.TARGET, 1, 1)//might take maxTarget out
        )
    ),
    DEFEND_LOGIC(
        "Defend",
        Arrays.asList(
            new ApplyEffect(TargetMode.SELF, 1, 1, EffectLogic.DEFEND_EFFECT)
        )
    ),

    //Item Logic
    POTION_LOGIC(
        "Potion",
        Arrays.asList(
            new Heal(TargetMode.SELF, 1, 1, 10)
        )
    ),
    POWER_STONE_LOGIC(
        "Power Stone",
        Arrays.asList(
            new ActivateSkill()
        )
    ),
    SMOKE_BOMB_LOGIC(
        "Smoke Bomb",
        Arrays.asList(
            new ApplyEffect(TargetMode.SELF, 1, 1, EffectLogic.SMK_BOMB_INV)
            //could change 'new SmokeInvEffect()' to getInstance()
        )
    ),

    //Skill Logic 
    //likely have to separate because need different base durations
    ARCANE_BLAST_LOGIC(
        "Arcane Blast",
        Arrays.asList(
            new Damage(TargetMode.TARGET, 1, 1),
            new ConditionalMechanism(
                new Defeated(TargetMode.TARGET),
                new ApplyEffect(TargetMode.SELF, 1, 1, EffectLogic.ARC_BLAST_EFFECT))
        )
    ),
    SHELD_BASH_LOGIC(
        "Shield Bash",
        Arrays.asList(
            new Damage(TargetMode.TARGET, 1, 1),
            new ApplyEffect(TargetMode.TARGET, 1, 1, EffectLogic.STUN)
        )
    );

    private final String name;
    private List<CombatMechanism> mechanismList = new ArrayList<>();
    //private final boolean hasTarget;

    ActionLogicType(String name, List<CombatMechanism> mechanismList){
        this.name = name;
        this.mechanismList = mechanismList;
        boolean tempHasTarget = false;
//        for (CombatMechanism mechanism : mechanismList){
//            if (mechanism.needsTarget()){
//                tempHasTarget = true;
//                break;
//            }
//        }
//        this.hasTarget = tempHasTarget;
    }

    public String getName() {
        return name;
    }

    public String getDisplayFormat(){
        return getName();
    }

//    public boolean needsTarget(Combatant user){
//        return hasTarget;
//    }

    public List<CombatMechanism> getMechanismList() {
        return mechanismList;
    }
}
