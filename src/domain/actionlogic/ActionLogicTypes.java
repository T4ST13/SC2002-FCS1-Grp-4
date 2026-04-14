package domain.logicdata;

import domain.actionlogic.mechanism.CombatMechanism;
import domain.actionlogic.mechanism.Damage;
import domain.actionlogic.mechanism.TargetMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ActionLogicTypes {
    //Shared Action Logic
    BASIC_ATTACK(
        "Basic Attack",
        Arrays.asList(
            new Damage(TargetMode.TARGET, 1)
        )
    ),
    DEFEND(
        "Defend", 
        Arrays.asList(
            new Buff(TargetMode.TARGET, 1)
        )
    ),

    //Skill Logic //likely have to separate because need different base durations

    //Item Logic
    private final String name;
    private List<CombatMechanism> actionLogic = new ArrayList<>();

    ActionLogicTypes(String name, List<CombatMechanism> actionLogic){
        this.name = name;
        this.actionLogic = actionLogic;
    }
}
